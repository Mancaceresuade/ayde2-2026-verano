# Grafo Ponderado — Ejercicio UADE

Proyecto Java con **Spring Boot 3.2** que implementa un grafo ponderado no dirigido con soporte de hasta 100 vértices, expuesto como API REST.

---

## Estructura del proyecto

```
src/
├── main/java/ar/edu/uade/
│   ├── App.java                    # Punto de entrada Spring Boot
│   ├── iGrafoPonderadoTDA.java     # Interfaz del grafo ponderado
│   ├── GrafoPonderadoEstatico.java # Implementación estática (matriz de adyacencia)
│   ├── GrafoController.java        # REST Controller (/api/grafo)
│   └── AristaRequest.java          # DTO para el body de agregar arista
└── test/java/ar/edu/uade/
    └── GrafoPonderadoEstaticoTest.java  # Tests JUnit 4
```

---

## Interfaz `iGrafoPonderadoTDA`

| Método | Descripción |
|--------|-------------|
| `crearGrafo()` | Crea un grafo vacío / reinicia el estado |
| `agregarVertice(int v)` | Agrega el vértice `v` (0–99) |
| `eliminarVertice(int v)` | Elimina `v` y todas sus aristas |
| `agregarArista(int v, int w, double peso)` | Agrega arista ponderada entre `v` y `w` |
| `eliminarArista(int v, int w)` | Elimina la arista entre `v` y `w` |

---

## Implementación `GrafoPonderadoEstatico`

Representación mediante **matriz de adyacencia estática** de tamaño 100×100.

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `vertices[100]` | `boolean[]` | Vértices activos |
| `aristas[100][100]` | `boolean[][]` | Matriz de adyacencia |
| `pesos[100][100]` | `double[][]` | Peso de cada arista |

El grafo es **no dirigido**: `agregarArista(v, w, p)` actualiza `[v][w]` y `[w][v]` simétricamente.

Métodos de consulta adicionales (no parte de la interfaz):

| Método | Retorno | Descripción |
|--------|---------|-------------|
| `existeVertice(int v)` | `boolean` | ¿El vértice existe? |
| `existeArista(int v, int w)` | `boolean` | ¿Existe arista entre v y w? |
| `getPeso(int v, int w)` | `double` | Peso de la arista (lanza excepción si no existe) |

---

## API REST — `GrafoController`

Base URL: `http://localhost:8080/api/grafo`

### Vértices

| Método HTTP | Endpoint | Descripción |
|-------------|----------|-------------|
| `POST` | `/crear` | Crea / reinicia el grafo |
| `POST` | `/vertice/{v}` | Agrega vértice `v` |
| `DELETE` | `/vertice/{v}` | Elimina vértice `v` y sus aristas |
| `GET` | `/vertice/{v}` | Consulta si el vértice `v` existe |

### Aristas

| Método HTTP | Endpoint | Body / Params | Descripción |
|-------------|----------|---------------|-------------|
| `POST` | `/arista` | `{"v":0,"w":1,"peso":5.0}` | Agrega arista con peso |
| `DELETE` | `/arista/{v}/{w}` | — | Elimina arista entre `v` y `w` |
| `GET` | `/arista/{v}/{w}` | — | Consulta existencia y peso de la arista |

### Ejemplos `curl`

```bash
# Crear el grafo
curl -X POST http://localhost:8080/api/grafo/crear

# Agregar vértices 0 y 1
curl -X POST http://localhost:8080/api/grafo/vertice/0
curl -X POST http://localhost:8080/api/grafo/vertice/1

# Agregar arista (0-1) con peso 7.5
curl -X POST http://localhost:8080/api/grafo/arista \
     -H "Content-Type: application/json" \
     -d '{"v":0,"w":1,"peso":7.5}'

# Consultar si existe la arista y su peso
curl http://localhost:8080/api/grafo/arista/0/1

# Eliminar la arista
curl -X DELETE http://localhost:8080/api/grafo/arista/0/1

# Eliminar el vértice 0 (y sus aristas)
curl -X DELETE http://localhost:8080/api/grafo/vertice/0
```

---

## Ejecución del servicio web

### Requisitos previos
- **Java 17+** instalado
- **Maven 3.6+** en el PATH

### 1. Compilar y ejecutar (modo desarrollo)

```bash
mvn spring-boot:run
```

El servidor arranca en `http://localhost:8080`.

### 2. Generar JAR ejecutable y correrlo

```bash
# Generar el JAR
mvn package -DskipTests

# Ejecutar el JAR generado
java -jar target/ejercicio-1.0-SNAPSHOT.jar
```

### 3. Ejecutar los tests

```bash
mvn test
```

---

## Dependencias principales

| Dependencia | Versión | Uso |
|-------------|---------|-----|
| `spring-boot-starter-parent` | 3.2.3 | BOM / configuración base |
| `spring-boot-starter-web` | (heredada) | Servidor HTTP + REST |
| `junit` | 4.13.2 | Tests unitarios |
