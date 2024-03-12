# Política de Nomenclatura beMaster

## Política de Nomenclatura para Bases de Datos

### Nombres de Tablas

- Utilizar el formato `snake_case`.
- Nombrar las tablas de manera descriptiva y singular.
- Utilizar nombres en plural solo si la tabla representa una relación muchos a muchos.
- Ejemplo: `usuario`, `producto`

### Nombres de Columnas

- Utilizar el formato `snake_case`.
- Nombrar las columnas de manera descriptiva y singular.
- Utilizar nombres en plural solo si la columna representa una relación muchos a muchos.
- Utilizar `id` como nombre de columna para las llaves primarias.
- Utilizar el nombre de la entidad seguido de `_id` para las llaves foráneas.
- Ejemplo: `usuario_id`, `producto_id`

### Consultas y Operaciones

- Organizar las consultas SQL de manera clara y legible.
- Utilizar alias descriptivos para tablas en consultas con múltiples joins.
- Utilizar comentarios para explicar consultas complejas o procedimientos almacenados.

### Triggers

- Nombrar los triggers de manera descriptiva y clara.
- Utilizar el formato `nombre_tabla_evento`, donde el evento puede ser `before_insert`, `after_update`, etc.
- Ser descriptivo en la acción realizada por el trigger.

### Procedimientos Almacenados

- Utilizar el formato `nombre_accion`, donde la acción describe claramente la funcionalidad del procedimiento almacenado.
- Ser descriptivo y utilizar nombres que reflejen claramente la función y su propósito.
- Organizar los procedimientos almacenados en un esquema coherente según su funcionalidad.

## Backend

### Nombres de Clases
- Utilizar el formato PascalCase.
- Ser descriptivo y evitar abreviaturas.
- Ejemplo: `UsuarioService`, `ProductoController`

### Nombres de Métodos
- Utilizar el formato camelCase.
- Ser descriptivo y utilizar verbos que indiquen la acción realizada.
- Ejemplo: `crearUsuario`, `obtenerProductos`

### Nombres de Archivos
- Utilizar el formato PascalCase para archivos principales.
- Ser descriptivo y reflejar claramente el contenido del archivo.
- Ejemplo: `UsuarioService.js`, `ProductoController.js`

### Nombres de Funciones
- Utilizar el formato camelCase.
- Ser descriptivo y reflejar claramente el propósito de la función.
- Ejemplo: `calcularTotal`, `validarUsuario`

### Nombres de Variables y Atributos
- Utilizar el formato camelCase.
- Ser descriptivo y reflejar claramente el propósito y contenido.
- Ejemplo: `nombreUsuario`, `cantidadProductos`

## Frontend

### Nombres de Clases
- Utilizar el formato PascalCase.
- Ser descriptivo y evitar abreviaturas.
- Ejemplo: `UsuarioComponent`, `ProductoService`

### Nombres de Métodos
- Utilizar el formato camelCase.
- Ser descriptivo y utilizar verbos que indiquen la acción realizada.
- Ejemplo: `agregarProducto`, `eliminarUsuario`

### Nombres de Archivos
- Utilizar el formato kebab-case para archivos principales.
- Ser descriptivo y reflejar claramente el contenido del archivo.
- Ejemplo: `usuario-form.component.html`, `producto.service.ts`

### Nombres de Funciones
- Utilizar el formato camelCase.
- Ser descriptivo y reflejar claramente el propósito de la función.
- Ejemplo: `filtrarProductos`, `validarUsuario`

### Nombres de Variables y Atributos
- Utilizar el formato camelCase.
- Ser descriptivo y reflejar claramente el propósito y contenido.
- Ejemplo: `nombreUsuario`, `cantidadProductos`

## GitHub

### Nombres de Ramas
- Utilizar el formato kebab-case.
- Ser descriptivo y reflejar el propósito de la rama.
- Prefijar con el tipo de tarea, como `feature/`, `bugfix/`.
- Ejemplo: `feature/nueva-funcionalidad`

### Nombres de Etiquetas (Tags)
- Utilizar el formato kebab-case.
- Ser descriptivo y representar la versión o hito.
- Ejemplo: `v1.0.0`

### Nombres de Archivos de Configuración
- Utilizar nombres estándar y descriptivos.
- Mantener minúsculas y separar palabras con guiones bajos.
- Ejemplo: `README.md`, `package.json`

### Mensajes de Confirmación (Commits)
- Utilizar mensajes claros y descriptivos.
- Seguir el formato convencional de mensaje de confirmación.
- Ejemplo: `Agregar función de autenticación de usuarios`

### Nombres de Repositorios
- Utilizar nombres descriptivos y claros.
- Mantener minúsculas y separar palabras con guiones o guiones bajos.
- Ejemplo: `mi-proyecto-web`

### Nombres de Organizaciones
- Utilizar nombres descriptivos y claros.
- Mantener minúsculas y separar palabras con guiones o guiones bajos.
- Ejemplo: `equipo-desarrollo