# Agregar en el properties
**Se requiere genera una firma única, esta es la que debe conocer el backend**
#Jwt Security
jwt.secret = roITo2yN5V8W6RbcVJ0G
jwt.expiration = 36000


.
├── Controller
│   ├── CiudadController
│   └── PaisController
├── Entity
│   ├── Ciudad
│   └── Pais
├── DTO
│   ├── ICiudadDto
│   └── IPaisDto
├── IRepository
│   ├── ICiudadRepository
│   └── IPaisRepository
├── IService
│   ├── ICiudadService
│   └── IPaisService
├── Service
│   ├── CiudadService
│   └── PaisService
└── Security
    ├── Controller
    │   ├── UsuarioController
    │   ├── RolController
    │   └── PermisoRolController
    ├── Entity
    │   ├── Usuario
    │   ├── Rol
    │   └── PermisoRol
    ├── Jwt
    |   ├── JwtEntryPoint
    │   ├── JwtProvider
    │   ├── JwtTokenFilter
    ├── DTO
    │   ├── IUsuarioDto
    │   ├── IRolDto
    │   └── IPermisoRolDto
    ├── IRepository
    │   ├── IUsuarioRepository
    │   ├── IRolRepository
    │   └── IPermisoRolRepository
    ├── IService
    │   ├── IUsuarioRepository
    │   ├── IRolRepository
    │   └── IPermisoRolRepository
    └── Service
        ├── UsuarioService
        ├── RolService
        └── PermisoRolService


 JwtEntryPoint

 ```java
 @Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        logger.error("fail en el método commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
    }
	
}
 ```
 
 JwtProvider
 ```java
 @Component
public class JwtProvider {

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180))
                .signWith(getSecret(secret))
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacío");
        } catch (SignatureException e) {
            logger.error("fail en la firma");
        }
        return false;
    }

    public String refreshToken(JwtDto jwtDto) throws ParseException {
        try {
            Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(jwtDto.getToken());
        } catch (ExpiredJwtException e) {
            JWT jwt = JWTParser.parse(jwtDto.getToken());
            JWTClaimsSet claims = jwt.getJWTClaimsSet();
            String nombreUsuario = claims.getSubject();
            List<String> roles = (List<String>) claims.getClaim("roles");

            return Jwts.builder()
                    .setSubject(nombreUsuario)
                    .claim("roles", roles)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + expiration))
                    .signWith(getSecret(secret))
                    .compact();
        }
        return null;
    }

    private Key getSecret(String secret){
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }
	
}
 ```
 
 
JwtTokenFilter
```java
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(req);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            logger.error("fail en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
	
}
```

MainSecurity
```java
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MainSecurity {

	@Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    AuthenticationManager authenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
        authenticationManager = builder.build();
        http.authenticationManager(authenticationManager);

        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests().requestMatchers("/auth/**").permitAll().anyRequest().authenticated();
        
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "Access-Control-Allow-Origin"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

```

UserController => AuthController
```java
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    IModuleRepository moduleRepository;
    
    @Autowired
    IFormRepository formRepository;

    @PostMapping("/nuevo")
    public ResponseEntity<ApiResponseDto<String>> nuevo(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<ApiResponseDto<String>>(new ApiResponseDto<String>("campos mal puestos o email inválido", null, false), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByUsername(userDto.getUsername()))
            return new ResponseEntity<ApiResponseDto<String>>(new ApiResponseDto<String>("Ese nombre ya existe", null, false), HttpStatus.BAD_REQUEST);
        
        User usuario = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        
        userDto.getRoles().forEach(role -> {
        	roles.add(rolService.getById(role).get());
        });
        
        usuario.setRoles(roles);
        usuario.setCreatedAt(LocalDateTime.now());
        
        usuarioService.save(usuario);
        
        return new ResponseEntity<ApiResponseDto<String>>(new ApiResponseDto<String>("usuario guardado", null, true), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<UserDto>> login(@RequestBody UserDto userDto, BindingResult bindingResult){
        try {
        	if(bindingResult.hasErrors()) return new ResponseEntity<ApiResponseDto<UserDto>>(new ApiResponseDto<UserDto>("Campos mal puestos", null, false), HttpStatus.BAD_REQUEST);
			
        	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            
            Optional<User> userO = usuarioService.getByUsername(userDto.getUsername());
            User user = userO.get();
            
            userDto.setId(user.getId());
            userDto.setToken(jwt);
            userDto.setModulos(moduleRepository.findByUserId(user.getId()));
            userDto.setFormularios(formRepository.getFormsByUser(user.getId()));
            
            return new ResponseEntity<ApiResponseDto<UserDto>>(new ApiResponseDto<UserDto>("Sesión iniciada", userDto, true), HttpStatus.OK);
        	
		} catch (Exception e) {
			return new ResponseEntity<ApiResponseDto<UserDto>>(new ApiResponseDto<UserDto>(e.getMessage(), null, false), HttpStatus.BAD_REQUEST);
		}
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity<JwtDto>(jwt, HttpStatus.OK);
    }
}
```