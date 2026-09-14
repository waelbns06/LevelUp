# LevelUp

LevelUp es una aplicación de gestión para una tienda de videojuegos desarrollada como proyecto durante el CFGS de Desarrollo de Aplicaciones Web (DAW).

La aplicación permite gestionar productos, clientes y categorías, además de consultar información relacionada con facturación y stock. La interfaz está desarrollada con JavaFX y los datos se almacenan en una base de datos MySQL.

---

## Vista de la aplicación

<p align="center">
  <img src="docs/images/app-principal.png" alt="Pantalla principal de LevelUp" width="850">
</p>

## Funcionalidades

### Gestión de productos

- Consulta del catálogo de productos.
- Gestión de la información de los productos.
- Clasificación mediante categorías.
- Consulta de productos con bajo stock.
- Operaciones sobre los datos almacenados en MySQL.

### Gestión de clientes

- Consulta de clientes registrados.
- Acceso a la información de cada cliente.
- Consulta de datos relacionados con facturación.

### Resúmenes

La aplicación permite consultar distintos resúmenes a partir de la información almacenada en la base de datos:

- Facturación por cliente.
- Facturación por categoría.
- Productos con bajo stock.

---

## Gestión de productos

<p align="center">
  <img src="docs/images/crud-productos.png" alt="Gestión de productos en LevelUp" width="850">
</p>

El proyecto está organizado en diferentes capas para separar los modelos de datos, la conexión con la base de datos, los repositorios y la interfaz gráfica.

---

## Base de datos

LevelUp utiliza MySQL para almacenar la información de la aplicación.

El repositorio incluye el archivo:

```text
database.sql
```

Este archivo contiene la estructura necesaria para crear la base de datos utilizada por el proyecto.

<p align="center">
  <img src="docs/images/modelo-er-levelup.png" alt="Modelo entidad relación de LevelUp" width="800">
</p>

Entre las principales entidades utilizadas por la aplicación se encuentran:

- Productos
- Categorías
- Clientes
- Información relacionada con facturación

---

## Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| Java | Lógica principal de la aplicación |
| JavaFX | Desarrollo de la interfaz gráfica |
| FXML | Definición de las vistas |
| MySQL | Base de datos |
| JDBC | Conexión entre Java y MySQL |
| Maven | Gestión de dependencias |
| OpenRouter | Integración con modelos de lenguaje |
| Git y GitHub | Control de versiones |

---

## Estructura del proyecto

```text
LevelUp/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── com/example/levelup/
│       │   │   ├── database/
│       │   │   │   └── ConexionDB.java
│       │   │   │
│       │   │   ├── model/
│       │   │   │   ├── Categoria.java
│       │   │   │   ├── Cliente.java
│       │   │   │   ├── Producto.java
│       │   │   │   ├── ProductoBajoStock.java
│       │   │   │   ├── ResumenFacturacionCategoria.java
│       │   │   │   └── ResumenFacturacionCliente.java
│       │   │   │
│       │   │   ├── repository/
│       │   │   │   ├── RepositorioCategoriaDAO.java
│       │   │   │   ├── RepositorioClienteDAO.java
│       │   │   │   ├── RepositorioDAO.java
│       │   │   │   ├── RepositorioProductoDAO.java
│       │   │   │   └── RepositorioResumenDAO.java
│       │   │   │
│       │   │   ├── Launcher.java
│       │   │   ├── LevelUpApplication.java
│       │   │   └── LevelUpController.java
│       │   │
│       │   └── module-info.java
│       │
│       └── resources/
│           └── com/example/levelup/
│               └── levelup-view.fxml
│
├── docs/
│   └── images/
│       ├── app-principal.png
│       ├── crud-productos.png
│       ├── modelo-er-levelup.png
│       ├── mysql.png
│       └── openrouter.png
│
├── database.sql
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

---

## Conexión con MySQL

La conexión con la base de datos se realiza desde:

```text
ConexionDB.java
```

Los datos sensibles, como la contraseña de MySQL o las claves de servicios externos, no se almacenan directamente en el repositorio.

Para ejecutar el proyecto es necesario disponer localmente de un archivo:

```text
config.properties
```

Ejemplo de configuración:

```properties
db.password=TU_PASSWORD
OPENROUTER_API_KEY=TU_API_KEY
```

El archivo `config.properties` está incluido en `.gitignore` para evitar que las credenciales se publiquen accidentalmente en GitHub.

---

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/waelbnS06/LevelUp.git
```

### 2. Acceder al proyecto

```bash
cd LevelUp
```

### 3. Crear la base de datos

Abrir MySQL Workbench o cualquier cliente compatible con MySQL y ejecutar el archivo:

```text
database.sql
```

### 4. Configurar las credenciales

Crear el archivo `config.properties` utilizado por la aplicación y añadir las credenciales locales necesarias.

### 5. Instalar las dependencias

El proyecto utiliza Maven.

En Windows:

```bash
mvnw.cmd clean install
```

En Linux o macOS:

```bash
./mvnw clean install
```

### 6. Ejecutar la aplicación

El proyecto puede abrirse desde un IDE compatible con Maven y JavaFX, como IntelliJ IDEA.

La aplicación se inicia desde:

```text
Launcher.java
```

---

## MySQL

<p align="center">
  <img src="docs/images/mysql.png" alt="Base de datos MySQL de LevelUp" width="850">
</p>

La persistencia de los datos se realiza mediante MySQL. Para organizar el acceso a la información se utilizan repositorios DAO, separando las consultas a la base de datos del resto de la aplicación.

---

## Integración con OpenRouter

<p align="center">
  <img src="docs/images/openrouter.png" alt="Integración de OpenRouter en LevelUp" width="850">
</p>

Durante el desarrollo del proyecto también se trabajó con OpenRouter para realizar una integración con modelos de lenguaje mediante API.

Las claves necesarias para acceder a servicios externos se mantienen fuera del repositorio mediante el archivo de configuración local.

---

## Conceptos aplicados

Durante el desarrollo de LevelUp se han trabajado los siguientes conceptos:

- Programación orientada a objetos.
- Desarrollo de interfaces con JavaFX.
- Diseño de vistas mediante FXML.
- Bases de datos relacionales.
- Consultas SQL.
- Conexión con bases de datos mediante JDBC.
- Patrón DAO.
- Separación del proyecto en capas.
- Gestión de dependencias con Maven.
- Uso de APIs externas.
- Gestión de credenciales mediante archivos de configuración.
- Control de versiones con Git y GitHub.

---

## Sobre el proyecto

LevelUp fue desarrollado durante el CFGS de Desarrollo de Aplicaciones Web con el objetivo de poner en práctica distintos conocimientos trabajados durante el curso.

El proyecto combina una aplicación de escritorio desarrollada en Java con una base de datos MySQL, utilizando JavaFX para la interfaz y una estructura basada en modelos, repositorios y controladores.

---

## Autor

**Wael Benessalih Bilal**

Estudiante de Desarrollo de Aplicaciones Web (DAW).

GitHub: [@waelbnS06](https://github.com/waelbnS06)
