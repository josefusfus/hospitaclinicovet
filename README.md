# Hospital Clínico Veterinario API

![Java](https://img.shields.io/badge/Java-11-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen)
![H2 Database](https://img.shields.io/badge/Database-H2-orange)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-brightgreen)

## Índice

1. [Descripción](#descripción)
2. [Características](#características)
3. [Requisitos](#requisitos)
4. [Instalación](#instalación)
5. [Uso](#uso)
   - [Acceso a la Consola H2](#acceso-a-la-consola-h2)
   - [Documentación de la API con Swagger](#documentación-de-la-api-con-swagger)
   - [Endpoints](#endpoints)
6. [Seguridad](#seguridad)
7. [Pruebas con Postman](#pruebas-con-postman)

## Descripción

La **Hospital Clínico Veterinario API** es una aplicación backend desarrollada en Java 11 utilizando Spring Boot. Esta API permite la gestión de hospitalizaciones veterinarias de mascotas, incluyendo la creación, modificación y eliminación de ingresos, así como la gestión de los datos de las mascotas.

## Características

- **Gestión de Ingresos**: Crear, modificar, anular y consultar ingresos.
- **Gestión de Mascotas**: Crear, dar de baja y consultar datos de mascotas.
- **Autenticación**: Protegido con autenticación básica.
- **Documentación**: Integración con Swagger para documentación y pruebas de API.

## Requisitos

- **Java 11** o superior
- **Maven 3.6** o superior
- **IntelliJ IDEA** o cualquier otro IDE de Java

## Instalación

**Clonar el repositorio**

   - git clone https://github.com/josefusfus/hospitaclinicovet.git
   - 
**Ejecutar la app**
   - ejecutar el archivo .jar desde el directorio donde esté descargado el repo
     "java -jar target/hospitalclinicovetapi-0.0.1-SNAPSHOT.jar"

## Uso
**Acceso a la consola H2**
 - URL: http://localhost:8080/h2-console
 - JDBC URL: jdbc:h2:file:./data/testdb
 - User Name: sa
 - Password: password

**Documentación de la API con Swagger**
- URL: http://localhost:8080/swagger-ui.html

**Endpoints**

**Ingresos**

**Obtener todos los ingresos**

   - GET /hospitalclinicovet-api/ingreso
     
**Crear un nuevo ingreso**

   - POST /hospitalclinicovet-api/ingreso
   - Cuerpo:
      {
        "fechaAltaIngreso": "2023-01-01",
        "estado": "ALTA",
        "mascota": { "id": 1 },
        "dniRegistrador": "12345678A"
      }
     
**Modificar un ingreso**

 - PUT /hospitalclinicovet-api/ingreso
 - Cuerpo:
   {
  "id": 1,
  "fechaAltaIngreso": "2023-01-01",
  "fechaFinIngreso": "2023-01-15",
  "estado": "FINALIZADO",
  "mascota": { "id": 1 },
  "dniRegistrador": "12345678A"
   }

**Anular un ingreso**

- DELETE /hospitalclinicovet-api/ingreso/{id}

**Mascotas**

**Obtener datos de una mascota**

   - GET /hospitalclinicovet-api/mascota/{idMascota}

**Obtener ingresos de una mascota**

   - GET /hospitalclinicovet-api/mascota/{idMascota}/ingreso

**Crear una nueva mascota**

   - POST /hospitalclinicovet-api/mascota
   - Cuerpo:{
  "especie": "Perro",
  "raza": "Labrador",
  "edad": 3,
  "codigoIdentificacion": "ABC123",
  "dniResponsable": "12345678A"
}

**Dar de baja una mascota**

   - DELETE /hospitalclinicovet-api/mascota/{idMascota}


## Seguridad

La aplicación está protegida con autenticación básica. Las credenciales predeterminadas son:

  - Usuario: jlsaez
  - Contraseña: seleccioname

  - Sino usas la colección de Postman para probarla recuerda en el apartado autenticación añadir las credenciales de seguridad

## Pruebas con Postman

Para facilitar las pruebas, se incluye una colección de Postman que puedes importar.

 - Importar la Colección de Postman que se encuentra en el repositoria en el directorio Pruebas Postman
 - Descargar el archivo "Pruebas api rest hospitalclinicovet.postman_collection.json"
 - Abrir Postman y hacer clic en el botón "Import".
 - Seleccionar el archivo .json descargado y hacer clic en "Import".
 - Ahora estará la colección importada en tu Postman, lista para ser utilizada.
 - La colección incluye todas las solicitudes necesarias para interactuar con la API del Hospital Clínico Veterinario.


