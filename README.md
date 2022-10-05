# Microservicio Prices

### Descripción
Este microservicio expone un API REST para consultar los precios asociados a productos de cada marca.


### Stack Tecnológico
- Java 11
- Maven 3
- Spring Boot 2.7.4
- Base de datos H2 2.1.214

### Cómo ejecutar la aplicación
Desde un terminal ejecutar el siguiente comando

```shell
mvn spring-boot:run
``` 

### Interfaz web de Open API
Para acceder a la consola web de Open Api abrir un navegador y escribir la siguiente url en la barra de direcciones

http://localhost:8080/swagger-ui/index.html

### Consola H2
Se ha desabilitado la consola web H2, si se quiere habilitar se debe parar la aplicación y descomentar las siguientes
líneas en el fichero de configuración application.yml

```yaml
#  h2:
#    console.enabled: true
```

### Trazas de las consultas lanzadas a base de datos
Al igual que con la consola de H2 están desabilitadas por defecto, para habilitarlas descomentar las siguientes líneas
en fichero application.yml

```yaml
#    show-sql: true
#    properties.hibernate.format_sql: true

#logging:
#  level:
#    org.hibernate.type: trace
```