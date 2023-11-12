# Proyecto de Practica: Gestión administrativo para una boutique

Con esta aplicación podemos gestionar la ventas, realizar reportes, controlar el ingreso y salida de productos, y marcar asistencia de empleados.


**Indice**

* [Entorno de desarrollo](#entorno-de-desarrollo)
* [Dependencias](#dependencias)
* [Base de datos e Instalación](#base-de-datos-e-instalación)
    - [Esquema](#esquema)
    - [Instalar](#instalar)
    - [Generar Credenciales Cifradas](#generar-credenciales-cifradas)
* [Previsualización](#previsualización)
    - [Vista previa de programa](#vista-previa-de-programa)
    - [Vista previa de PDF](#vista-previa-de-pdf)
* [Actualizaciones](#actualizaciones)
* [Consideración](#consideración)


**Credenciales por defecto**

| Usuario | Contraseña | Rol |
| ------------ | ------------ | ------------ | 
| admin | admin | ADMIN |
| admin2 | admin | ADMIN |
| cajero | admin | CAJERO |
| cajero2 | admin | CAJERO |
| almacen | admin | ALMACEN |


# Entorno de desarrollo

- Angular v14.0.0
- Java 8


| Herramienta | Versión |
| ------------ | ------------ | 
|  Spring Tool Suite 4  | 4.12.0.RELEASE |
| MySQL Workbench 8.0 | 8.0.31 |



# Dependencias

```xml
<dependencies>

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-jpa</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.thymeleaf.extras</groupId>
		<artifactId>thymeleaf-extras-springsecurity5</artifactId>
	</dependency>	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<scope>runtime</scope>
		<optional>true</optional>
	</dependency>	

	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>8.0.29</version>
	</dependency>
		<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
			
	<dependency>
		<groupId>com.github.librepdf</groupId>
		<artifactId>openpdf</artifactId>
		<version>1.3.29</version>
	</dependency>
	
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<scope>provided</scope>
	</dependency>
	
	
</dependencies>
```



# Base de datos e Instalación

### Esquema

![](https://i.postimg.cc/gdcmNwp3/data-vanyluck.png)

### Instalar

Instalar los script de `BASE_DE_DATOS` en el siguiente orden

* SCRIPT_BASE_DATOS
* ALTERACION_TABLAS
* PROCESOS_ALMACENADOS
* INSERTAR_DATOS

### Generar Credenciales Cifradas

Debemos ingresar a http://localhost:8080/admin/config e ingresar la contraseña y nos lo mostrará cifrado, con eso podemos actualizarlo en la base de datos.


 ![](https://i.postimg.cc/hSbR0n3C/img-8.png) 



# Previsualización

## Vista previa de programa

[Ver todas las capturas aquí.](https://drive.google.com/drive/folders/14NQ0OrYtI6IAaRkwnCwt4LxmpDzzHXYs?usp=drive_link "Ver todas las capturas aquí.")

 ![](https://i.postimg.cc/hg0RmK7h/img-5.png) 


## Vista previa de PDF


- [PDF Reporte](https://drive.google.com/file/d/1ClQWHereeEddy5rlXOE2dhy1fFhHZC8Z/view?usp=drive_link "PDF Reporte")

![](https://i.postimg.cc/QCWhM9Dp/reporte.jpg) 


# Actualizaciones

- Versión 1

# Consideración

Proyecto realizado con fines educativos.

> Nombres, apellidos, números de contacto, números de documento, empresas, marcas correos, que figuran en la base de datos, son datos referenciales ficticios.
> Las imagenes de vestidos fueron extraídos de Unsplash https://unsplash.com/
> El nombre VanyLuck es ficticio.