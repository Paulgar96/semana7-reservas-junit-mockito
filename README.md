# UEES UCOM0310 — Semana 7 — Proyecto base Ae6

Proyecto base para las actividades individuales de Semana 7.

## Requisitos
- Java 21
- Maven 3.9+
- Git

## Verificación inicial
```bash
mvn clean test
```

## Cobertura
```bash
mvn clean test
```

Luego abrir:
`target/site/jacoco/index.html`

## Regla de trabajo
No modifiques el código productivo solo para hacer pasar una prueba sin justificar el cambio.
Primero diseña el caso, luego implementa la prueba y finalmente interpreta el resultado.
## Ae6 — Suite de pruebas del sistema de reservas

### Objetivo
Verificar las reglas de cancelación, descuentos, confirmación y
validación de reservas mediante JUnit 5 y Mockito.

### Casos y pruebas
La matriz está en docs/01_MATRIZ_CASOS_PLANTILLA.md.
Las pruebas están en src/test/java y utilizan la estructura
Arrange–Act–Assert (AAA).

Se comprueban valores límite de cancelación, descuentos,
totales negativos, disponibilidad, reservas nulas, cambios
de estado e identificadores inválidos.

### Uso de Stub y Mock
DisponibilidadClient se controla con when(...).thenReturn(...)
para simular disponibilidad. ReservaRepository y Notificador
se verifican con verify(...) y never() para comprobar el
guardado y la notificación, o su ausencia.

Los objetos Reserva utilizados son reales.

### Cómo verificar
Requisitos: JDK 21 y Maven.

Desde la raíz del proyecto ejecutar:

```bash
mvn clean test
```

Resultado registrado: 17 pruebas, 0 fallos y 0 errores.

El reporte de JaCoCo se genera en:
target/site/jacoco/index.html

### Cobertura y limitaciones
La ejecución registrada alcanzó 100 % de instrucciones y ramas.
El análisis está en docs/02_ANALISIS_COBERTURA_PLANTILLA.md.

La cobertura completa no garantiza todos los comportamientos.
Quedan posibles mejoras, como comprobar descuentos con tipos
en minúsculas y estudiar fallos del repositorio o del notificador.
Las pruebas no verifican servicios externos reales.

### Control de versiones
Rama de trabajo: ae6/suite-pruebas.
Rama base del Pull Request: main.

### Declaración de Inteligencia Artificial
Se utilizó ChatGPT como apoyo para diseñar casos, implementar
pruebas e interpretar la cobertura. Revisé el código y ejecuté
las pruebas localmente; asumo la responsabilidad del trabajo entregado.