
mysql
-----------------
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.3&packaging=jar&jvmVersion=17&groupId=com.corhuila&artifactId=shopping-car&name=shopping-car&description=Carrito%20de%20compras%20para%20xyz&packageName=com.corhuila.shopping-car&dependencies=web,data-jpa,devtools,mysql


mongoDB
------------------
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.3&packaging=jar&jvmVersion=17&groupId=com.corhuila&artifactId=shopping-car&name=shopping-car&description=Carrito%20de%20compras%20para%20xyz&packageName=com.corhuila.shopping-car&dependencies=web,devtools,data-mongodb


Dependencias
---------------------------------

Spring Web
Spring Boot DevTools
JPA (Únicamente para motores SQL)
MySQL Driver - Spring Data MongoDB - MS SQL Server Driver- otro

Swagger
---------------------------------

```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.0.4</version>
    </dependency>
```

#### Subir proyecto al IDE de preferencia 

* Intellij IDEA - Community
* Spring Boot Tools
* Visual Studio Code

#### Crear la arquitectura del backend

* Entity
* Dto
* IRespository
* IService
* Service
* Controller
* Util

#### Ejemplo: 

##### Entity
```java
    @Entity
    @Table(name = "nombre_entidad") // Corresponde al snake_case / unders_core de la table de la bd
    public class Factura {

        @Id // PK
        @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
        private Long id; // atributo de la entidad | camelCase

        @Column(name = "fecha", nullable = false) // atributo de la tabla | snake_case
        private LocalDateTime fecha; // atributo de la clase | calmelCase

        @ManyToOne(fetch = FetchType.EAGER, optional = false) // tipo de relación 1-n, n-n
        @JoinColumn(name = "cliente_id", nullable = false) // referencia de pk - fk | snake_case
        private Cliente cliente; // atributo de referencia de la entidad
        
        //Encapsulamiento
    }
```

##### IRepository
```java
    @Repository
    public interface IClienteRepository extends JpaRepository<Cliente, Long> {
     
    }
```

##### IService
``` java
    public interface IClienteService {

        List<Cliente> findAll(); // Devuelve una lista de clientes

        Optional<Cliente> findById(Long id); // Devuelve un cliente por su id

        Cliente save(Cliente cliente); // Guarda un cliente

        void update(Cliente cliente, Long id); // Actualiza un cliente

        void delete(Long id); // Elimina un cliente
    }

```

##### ServiceCliente  //Cumplir contrato
```java
    @Service
    public class ClienteService implements IClienteService {

        //Conectar con los datos - IRepository
        // Inyección de dependencia
        @Autowired
        private IClienteRepository repository;


        @Override
        public List<Cliente> findAll() {
        return repository.findAll();
        }

        @Override
        public Optional<Cliente> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public Cliente save(Cliente cliente) {
            return repository.save(cliente);
        }

        @Override
        public void update(Cliente cliente, Long id) {
            //Obtener el objeto cliente y el id
            //Verificar con el id, si exiten los datos
            Optional<Cliente> ps = repository.findById(id);

            //Cargar nuevo objeto
            if (ps.isEmpty()){
                Cliente clienteUpdate = ps.get();
                clienteUpdate.setNombre(cliente.getNombre());
                clienteUpdate.setDocumento(cliente.getDocumento());
                clienteUpdate.setMetodoPago(cliente.getMetodoPago());
                clienteUpdate.setDireccion(cliente.getDireccion());

                //Actualizar el objeto cliente
                repository.save(clienteUpdate);
            }else{
                System.out.println("No existe el cliente");
            }
        }

        @Override
        public void delete(Long id) {
            repository.deleteById(id);
        }
    }
```