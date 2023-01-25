 # 	:fork_and_knife: **Restaurante** 


## Descripción

La aplicación es un inventario de un restarurante
donde se puede:
<ul>
<li>Inicio de Sesión y Registro de un nuevo usuario</li>
<li>Visualizar el menu con sus respectivos precios.</li>
<li>Cargar nuevas bebidas y comidas</li>
<li>Editar bebidas y comidas ya existentes</li>
<li>Eliminar bebidas y comidas existentes</li>
<li>Todos los cambios se veran reflejados en el menu</li>
<li>Cerrar Sesión</li>
</ul>

## Tecnologías Utilizadas

<ul type="square">
<li>Java</li>
<li>Spring Boot</li>
<li>Spring Security</li>
<li>HTML</li>
<li>CSS</li>
<li>Docker</li>
<li>Postgres</li>
</ul>

## Instalación

Pasos a Seguir: 

<ol>
<li>Clonar el Repositorio

```
git clone https://github.com/sharonOstrovsky/Restaurante.git
```

</li>
<li>Crear una Base de Datos en Postgres con el nombre 

>resto 

</li>
<li>Cambiar usuario y contraseña en application.properties

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/resto
spring.datasource.username=nombreUsuario
spring.datasource.password=contraseña
spring.jpa.hibernate.ddl-auto=create

loggin.level.org.hibernate.sql=DEBAG

loggin.level.org.hibernate.type=TRACE
spring.main.allow-circular-references=true
```

</li>
</ol>


## Pasos Realizados
   1. Crear Restorante de comida rapida  
   2. Hacer Entidades:  
    A. Restaurante   
    B. User    
    C. Comida   
    D. Bebida   
    E. Role   
   
   3. Hacer Servicios: <br>
      A. ComidaService  
      B. UserService     
      C. BebidaService   
      D. RestoranteService <br>
   4. Hacer Interfaces de Servicios: <br>
   A. BebidasServiceImp <br>
   B. ComidaServiceImp <br>
   C. RestauranteServiceImp <br>
   D. UsuarioServiceImp <br>
 
   5. Hacer Controllers: <br>
   A. ComidaController(CRUD)   <br>
   B. BebidaController(CRUD)   
   C. UsuarioController    <br>
   D. PaginaController <br>
   
   6. Hacer Repository   <br>
      A.ComidaRepository  <br>
      B.BebidaRepository  <br>
      C.RoleRepository   <br>
      D.UsuarioRepository   <br>

   7. Hacer DTO

   8. Hacer config (seguridad): <br>
   A. WebSecurityConfig

   9. Base de Datos en Postgres   <br>

   10. Hacer html y css   <br> 

   11. Hacer Dockerfile   <br>

   12.  Subir a Render <br> 
             
## Autores

<ul>
<li>Sharon Ostrovsky</li>
<li>Damian Bettini</li>
</ul>

