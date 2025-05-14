# MySql Highschool Project

Este proyecto es una aplicación Java que interactúa con una base de datos MySQL para gestionar información de estudiantes. Utiliza HikariCP para la gestión del pool de conexiones y SLF4J para el registro de logs.

## Características

- Conexión a una base de datos MySQL utilizando HikariCP.
- Consulta de estudiantes por código postal.
- Configuración sencilla y modular.

## Requisitos previos

- **Java 21** o superior.
- **Maven** para la gestión de dependencias.
- **MySQL** instalado y configurado.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd MySql
   ```

2. Configura la base de datos:
   - Crea la base de datos y las tablas ejecutando el script SQL ubicado en `src/main/resources/highschool.sql`.

3. Configura las credenciales de la base de datos:
   - Modifica las credenciales en la clase `ConfigPool` (`src/main/java/org/ivan/dao/ConfigPool.java`):
     ```java
     config.setJdbcUrl("jdbc:mysql://localhost:3306/highschool");
     config.setUsername("root");
     config.setPassword("TU_CONTRASEÑA");
     ```

4. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```

## Uso

1. Ejecuta la aplicación:
   ```bash
   java -jar target/MySql-1.0-SNAPSHOT.jar
   ```

2. Introduce un código postal cuando se te solicite para buscar estudiantes.

## Estructura del proyecto

- `src/main/java/org/ivan/dao`: Gestión del pool de conexiones.
- `src/main/java/org/ivan/service`: Lógica de negocio para interactuar con la base de datos.
- `src/main/java/org/ivan/student`: Modelo de datos para los estudiantes.
- `src/main/resources`: Archivos de configuración y scripts SQL.

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

- [MySQL Connector](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
- [HikariCP](https://mvnrepository.com/artifact/com.zaxxer/HikariCP)
- [SLF4J](https://mvnrepository.com/artifact/org.slf4j/slf4j-api)

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, abre un issue o un pull request para sugerir mejoras.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).

