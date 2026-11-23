# Módulo 2: Gestión de Carga Académica

Implementación aislada del módulo de asignación y validación de horarios. Las entidades `Sede`, `Curso`, `Docente` y `DisponibilidadDocente` son solo soporte FK/lectura para la carga; no se incluyen CRUD ni pantallas de otros módulos.

## Estructura

```text
backend/src/main/java/pe/edu/grupo4/
  base/entity/                 # soporte relacional mínimo
  base/repository/             # consultas de soporte
  carga/{controller,service,repository,entity,dto,mapper}
  shared/exception/            # errores REST normalizados
frontend/src/app/
  core/{interceptors,models,services}
  features/carga-academica/    # componente aislado del módulo 2
```

## Backend

Requiere Java 17+, Maven 3.9+ y PostgreSQL 15+ (opcional; H2 se usa por defecto).

```powershell
cd backend
mvn spring-boot:run
```

H2 usa `jdbc:h2:mem:carga_academica`; consola en `http://localhost:8080/h2-console`. Swagger UI está en `http://localhost:8080/swagger-ui.html`.

Para PostgreSQL crea la base `carga_academica`, aplica `src/main/resources/schema.sql` y luego `data.sql`, define `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, y arranca con:

```powershell
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
```

### Endpoints

| Método | Ruta | Uso |
|---|---|---|
| GET | `/api/v1/cargas-academicas?ciclo=&sedeId=&docenteId=` | Lista y filtra cargas activas |
| GET | `/api/v1/cargas-academicas/{id}` | Consulta una carga |
| POST | `/api/v1/cargas-academicas` | Registra una carga |
| PUT | `/api/v1/cargas-academicas/{id}` | Edita y revalida la carga |
| DELETE | `/api/v1/cargas-academicas/{id}` | Anula conservando el registro |
| GET | `/api/v1/catalogos` | Opciones de solo lectura para el formulario |

Los conflictos horarios, traslado, disponibilidad, especialidad y tope devuelven 409. Errores de datos inválidos devuelven 400 y recursos no encontrados devuelven 404. El formato de error es `{timestamp,status,error,message,path}`.

Validaciones: intersección estricta de intervalos dentro del mismo ciclo y día; mínimo 60 minutos entre sedes distintas; disponibilidad que cubre todo el bloque para sede/día; coincidencia de especialidad; suma de duración de bloques activos frente al máximo semanal.

### Pruebas y cobertura

```powershell
mvn clean verify
```

JaCoCo genera `target/site/jacoco/index.html` y verifica cobertura de líneas >=95% para `pe.edu.grupo4.carga.service`. La suite verificada contiene 17 pruebas unitarias de servicio, 5 pruebas MockMvc y una prueba de integración H2. En la ejecución actual, el paquete de servicios registra 12/12 líneas cubiertas; la integración también valida los catálogos semilla y el conflicto por duplicación. Las pruebas MVC cubren 200, 201, 400, 404 y 409.

## Frontend

Requiere Node.js 20.11+ y npm.

```powershell
cd frontend
npm install
npm start
```

La API base se configura en `src/environments/environment.ts`. Ejecutar pruebas Angular con `npm test -- --watch=false`; generar reporte con `npm run test:coverage`.

Las asignaciones de UI, interceptor de errores, modelos y servicio de este módulo están bajo `src/app/features/carga-academica/` y `src/app/core/`.
