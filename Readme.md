# Prueba de certificación Desarrollador full stack Java trainee

Institución: Talento Digital para Chile.

EXAMEN DE CERTIFICACIÓN: Caso “Classicmodels Sales Force”

“Classicmodels” es una empresa dedicada a la fabricación y comercialización de modelos a escala de distintos tipos de vehículos motorizados tales como automóviles, motocicletas, trenes y aviones, entre otros. Sus modelos son de alto realismo y de gran calidad, razón por la cual ha logrado posicionarse en el mercado de los coleccionistas a nivel mundial.

La empresa se creó en los años sesentas como una empresa familiar, y debido a la buena calidad de sus modelos, fue rápidamente creciendo. Actualmente, cuenta con oficinas en las principales capitales del mundo, tales como New York, Boston, San Francisco, Paris, Tokyo, Sydeny, y London.

El crecimiento de la empresa no ha estado exento de dificultades, de hecho, el principal reclamo es el atraso en los pedidos debido a que no se lleva un buen control de las existencias y las órdenes. Al respecto, el CEO de la organización ha solicitado al CTO que impulse un proyecto de mejora de los sistemas de inventarios y existencias que ya data de los años 90s y no se le han hecho grandes mejoras.

El CTO está muy entusiasmado con el proyecto y rápidamente ha formado un equipo de proyectos de primera línea del cual usted forma parte como desarrollador full-stack Java. El equipo de proyectos también lo conforma un Jefe de Proyectos, un Diseñador UX/UI, un Diseñador Web, un Analista Funcional, un Desarrollador Mobile, y un Arquitecto de Software.

El proyecto busca, dentro de otras cosas, ordenar el sistema de inventario y de órdenes que se cursan desde las distintas oficinas. A continuación, se listan los requisitos funcionales de alto nivel del sistema:

• El sistema debe permitir la consulta de inventarios y existencia de los productos de las distintas líneas (automóviles, motocicletas, trenes, aviones, etc).

• El sistema debe permitir la consulta de las órdenes que se encuentran en proceso.

• El sistema debe permitir el cálculo de descuentos y promociones al momento de ingresar una orden.

A la fecha, ha transcurrido gran parte del proyecto y se tiene el siguiente avance:

• Ya se cuenta con un prototipo funcional del aplicativo.

• Existe un modelo de datos diseñado.

• Existe una base de datos con datos de prueba.

• Existe una aplicación web desarrollada con Spring Framework que desarrolla algunas de las funcionalidades requeridas.


![](https://raw.githubusercontent.com/eliseoOrellana/classicmodels/main/bd.png)


----

Requerimientos a Desarrollar: Objetivos generales.

El jefe de proyectos, quien lleva un control meticuloso de las actividades del proyecto, le ha solicitado a Usted que realice las siguientes tareas:
1. Realizar consultas a la base de datos
2. Construir un algoritmo de cálculo de comisiones de venta
3. Construir una unidad de pruebas para verificar los algoritmos de cálculo de comisiones de venta
4. Crear un Monitor de Gestión de Vendedores
5. Crear una API REST que disponibilice la información del monitor de gestión de vendedores

----

Requerimientos a Desarrollar: Objetivos especificos.


1. Realizar consultas a la base de datos
El objetivo es realizar consultas a la base de datos para obtener información relevante sobre vendedores y clientes. Para esto, se implementarán varias consultas y se generarán archivos SQL correspondientes(Ejemplos de los resultados esperados en erchivo pdf).

a) Consulta de Representantes de Venta por País y Oficina
    Se requiere una nómina con los datos de los representantes de venta (Sales Rep) junto al país y oficina al cual pertenece. Ordene alfabéticamente por país, ciudad y primer nombre.

b) Consulta de Clientes de Empresas de Responsabilidad Limitada
    Se requiere tener un listado de los clientes que corresponden a empresas de responsabilidad limitada (Ltd), con sus límites de crédito ordenados de mayor a menor.

c) Consulta de Representantes de Venta y su Cartera de Clientes
    Se requiere tener un listado con los representantes de venta (Sales Rep) y su cartera de clientes (cantidad de empresas que atienden), ordenado de forma descendente desde la cartera más grande. 

d) Consulta de Ranking de Ventas por Oficina
   Se requiere un ranking de ventas por oficina. Esto es, la cantidad de órdenes que han sido cursadas por los clientes, asociados a los representantes de venta de cada oficina. El listado debe estar ordenado por cantidad de ventas de mayor a menor. 

e) Consulta de Ranking de Clientes que más Compraron en el Año 2004
   Se requiere un ranking de los clientes que más compraron (monto de la orden, es decir, precio por cantidad pedida de cada producto de la orden) durante el año 2004, ordenado de mayor a menor suma de monto.

2. Construir un algoritmo de cálculo de comisiones de venta
    Se desarrollarán dos algoritmos de cálculo de comisiones, uno simple y otro complejo, para        incentivar la gestión de ventas de los representantes.

Algoritmo de Cálculo Simple.
...

Algoritmo de Cálculo Complejo.
...

3. Construir una unidad de pruebas para verificar los algoritmos de cálculo de comisiones de venta
    Se crearán pruebas unitarias para garantizar el correcto funcionamiento de los algoritmos de cálculo de comisiones.

    Pruebas de Algoritmo de Cálculo Complejo.

4. Crear un Monitor de Gestión de Vendedores
Se implementará una página web dinámica para listar y buscar vendedores, utilizando tecnologías como JSP, taglibs JSTL y Bootstrap.

Despliegue de Listado de Oficinas
...

Despliegue de Listado de Sales Managers
...

Despliegue de Listado de Representantes de Venta
...

5. Crear una API REST que disponibilice la información del monitor de gestión de vendedores
Se proporcionará un servicio REST para acceder a la información del monitor de gestión de vendedores, permitiendo filtrar por oficina y sales manager.

---

## Instrucciones de Uso

Requisitos Previos

• Instalacion Dockerdesktop [https://www.docker.com/products/docker-desktop/]

Comenzar

• Clonar el repositorio desde [https://github.com/eliseoOrellana/classicmodels.git].

• Construye las imágenes de Docker y ejecuta los contenedores usando Docker Compose:

```bash
docker-compose up --build
```

• Una vez que los contenedores estén en funcionamiento, puedes acceder a la aplicación web en:
 [(http://localhost:8080/)].


• Para la revision de la bd.(credenciales en el docker compose o application.properties).
 [(http://localhost:8081/)].

Para acceder a la API REST, utilizar las siguientes rutas:

ej. 

[http://localhost:8080/api/salesManager?officeCode=USA&salesManagerId=1143]


• Para detener la aplicación y eliminar los contenedores, presiona Ctrl + C para detener Docker Compose y luego ejecuta:

```bash
docker-compose down
```

## Configuración de la Aplicación

La aplicación Spring Boot se conecta a una base de datos MySQL utilizando la siguiente configuración:

URL de la Base de Datos: jdbc:mysql://localhost:3306/classic  [http://localhost:8081/]
Usuario: root
Contraseña: 1234

# Inicialización de la Base de Datos
La base de datos MySQL se inicializa con algunos datos de muestra al iniciar. Puedes encontrar los scripts SQL para crear insertar datos iniciales en el archivo bd inserts test.txt.

# Desarrollo
Si deseas modificar el código de la aplicación, puedes hacerlo editando los archivos en el directorio src/main/java. Después de hacer cambios, puedes reconstruir las imágenes de Docker y reiniciar los contenedores para ver las actualizaciones.
El contenedor Docker fue configurado con volumes para persistencia de datos y no se borren cada vez que reinicias el servicio.

# Soporte
Para cualquier problema o pregunta relacionada con la aplicación, no dudes en contactarme.

...
## Acknowledgements

 - [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
 - [Awesome README](https://github.com/matiassingers/awesome-readme)
 - [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)


## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


## License

[MIT](https://choosealicense.com/licenses/mit/)


## 🛠 Skills
Java, Spring Boot, Thymeleaf, JPA, REST, HTML, CSS, JS, MVC.



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://eliseoorellana.github.io/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/eliseo-orellana-sandoval/)


