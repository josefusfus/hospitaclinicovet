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
6. [Ejemplo de Datos](#ejemplo-de-datos)
7. [Seguridad](#seguridad)
8. [Desarrollo](#desarrollo)
   - [Configuración del Entorno de Desarrollo](#configuración-del-entorno-de-desarrollo)
   - [Generar JAR Ejecutable](#generar-jar-ejecutable)
9. [Contribución](#contribución)
10. [Licencia](#licencia)
11. [Pruebas con Postman](#pruebas-con-postman)

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

1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/tu-usuario/hospital-clinico-veterinario-api.git
   cd hospital-clinico-veterinario-api

## Seguridad

La aplicación está protegida con autenticación básica. Las credenciales predeterminadas son:

  -Usuario: user
  -Contraseña: password

## Pruebas con Postman

Para facilitar las pruebas, hemos incluido una colección de Postman que puedes importar.

 - Importar la Colección de Postman que se encuentra en el repositoria en el directorio Pruebas PostmanDescargar el archivo Pruebas api rest hospitalclinicovet.postman_collection.json
 - Abrir Postman y hacer clic en el botón "Import".
 - Seleccionar el archivo .json descargado y hacer clic en "Import".
 - Ahora tendrás la colección importada en tu Postman, lista para ser utilizada.
 - La colección incluye todas las solicitudes necesarias para interactuar con la API del Hospital Clínico Veterinario.


