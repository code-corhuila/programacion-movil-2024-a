# CRUD

### comodin
1. `npm i sweet-alert`
2. `npm i ionicons`


1. Instalar axios `npm i axios` o  `npm install axios`: Axios es una biblioteca JavaScript popular para hacer solicitudes HTTP en navegadores y Node.js. Es conocida por su sintaxis sencilla y su capacidad para manejar solicitudes y respuestas de forma eficiente, ofreciendo características avanzadas como la cancelación de solicitudes y la transformación automática de datos.

2. Métodos esenciales: 
    * Obtener todos los registros `findAllRecords` por el verbo `GET`
    * Obtener por ID `findRecordById` por el verbo `GET`
    * Crear registro `createRecord` por el verbo `POST`
    * Actualizar registro `updateRecord` por el verbo `PUT`
    * Eliminar registro físico `deleteRecordPhysical` por el verbo `DELETE`
    * Eliminado lógico `deleteRecordLogical` por el verbo `PUT`

3. Ruta base de la API: `localhost:9000/shopping-car/api/`
    - Endpoint para clientes: `localhost:9000/api/cliente/`
        - GET para obtener todos los cliente: `GET: localhost:9000/api/cliente`
        - GET para obtener un cliente por ID: `GET: localhost:9000/api/cliente/{id}`
        - POST para crear un cliente: `POST: localhost:9000/api/cliente`
        - PUT para actualizar un cliente: `PUT: localhost:9000/api/cliente/{id}`
        - PUT para realizar un eliminado lógico de un cliente: `PUT: localhost:9000/api/cliente/delete-logical/{id}`
        - DELETE para eliminar un cliente físicamente: `DELETE: localhost:9000/api/cliente/{id}`        

4. Estructura
    ```js
        // Obtener todos los registros
        async function fetchAllRecords() { ... }

        // Obtener por ID
        async function fetchRecordById(id) { ... }

        // Crear registro
        async function createRecord(data) { ... }

        // Actualizar registro
        async function updateRecord(id, data) { ... }

        // Eliminar registro físico
        async function removeRecordPhysical(id) { ... }

        // Eliminado lógico
        async function removeRecordLogical(id) { ... }
    ```

5. Ejemplo de consumir servicios
    
    ```js
    const axios = require('axios');

    const baseURL = 'http://localhost:9000/shopping-car/';

    // Obtener todos los registros
    async function findAllRecords() {
        try {
            const response = await axios.get(baseURL + 'cliente');
            return response.data;
        } catch (error) {
            console.error('Error al obtener todos los registros:', error);
            throw error;
        }
    }

    // Obtener por ID
    async function findRecordById(id) {
        try {
            const response = await axios.get(`${baseURL}cliente/${id}`);
            return response.data;
        } catch (error) {
            console.error('Error al obtener el registro por ID:', error);
            throw error;
        }
    }

    // Crear registro
    async function createRecord(data) {
        try {
            const response = await axios.post(baseURL + 'cliente', data);
            return response.data;
        } catch (error) {
            console.error('Error al crear el registro:', error);
            throw error;
        }
    }

    // Actualizar registro
    async function updateRecord(id, data) {
        try {
            const response = await axios.put(`${baseURL}cliente/${id}`, data);
            return response.data;
        } catch (error) {
            console.error('Error al actualizar el registro:', error);
            throw error;
        }
    }

    // Eliminar registro físico
    async function deleteRecordPhysical(id) {
        try {
            const response = await axios.delete(`${baseURL}cliente/${id}`);
            return response.data;
        } catch (error) {
            console.error('Error al eliminar el registro físico:', error);
            throw error;
        }
    }

    // Eliminado lógico
    async function deleteRecordLogical(id) {
        try {
            const response = await axios.put(`${baseURL}cliente/${id}`, { deleted: true });
            return response.data;
        } catch (error) {
            console.error('Error al realizar el eliminado lógico:', error);
            throw error;
        }
    }

    ```

    # Reto

    1. Crear enlace de base de datos personalizado
    2. Configurar el servicio de la api Producto (agregar métodos de eliminado lógico y físico, usar deletedAt como campo de LocalDateTime)
    3. Configurar los componentes para permitir guardar desde el frontend en productos.
    4. Publciar en el repositorio de quiz (quiz-3)