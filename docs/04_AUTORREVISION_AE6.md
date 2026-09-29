# Autorrevisión técnica — Ae6

## Código y pruebas
- [x] Revisé los cambios de las pruebas mediante git diff.
- [x] Los nombres describen el escenario y el comportamiento esperado.
- [x] Las pruebas nuevas separan Arrange, Act y Assert.
- [x] Se verifican resultados, estados y excepciones.
- [x] Se conserva la prueba del límite de cancelación de dos horas.
- [x] Los objetos Reserva son reales; los dobles controlan dependencias externas.
- [x] Sin disponibilidad, la reserva permanece PENDIENTE y no se guarda ni notifica.
- [x] La ejecución registrada terminó con 17 pruebas, 0 fallos y 0 errores.

## Matriz y cobertura
- [x] Revisé la correspondencia entre los casos y los resultados esperados.
- [x] La matriz incluye casos normales, alternativos, límite, inválidos y excepciones.
- [x] Analicé el reporte de JaCoCo global y de ReservaService.
- [x] Incorporé pruebas para los comportamientos pendientes del constructor de Reserva.
- [x] Documenté el 100 % de instrucciones y ramas y sus limitaciones.

## Git y documentación
- [x] Trabajé en la rama ae6/suite-pruebas.
- [x] Revisé el historial de commits descriptivos.
- [x] Comprobé que target no está registrado en Git.
- [x] Revisé los cambios de la matriz, el análisis y el README.
- [x] El README incluye requisitos, ejecución y declaración de uso de IA.

## Pendientes antes de entregar
- [ ] Revisar los archivos modificados para descartar datos sensibles.
- [ ] Incorporar y verificar las evidencias de ejecución y cobertura.
- [ ] Publicar la rama y crear el Pull Request hacia main.
- [ ] Revisar Files changed y la descripción del Pull Request.
- [ ] Registrar el enlace del Pull Request.
- [ ] Completar y revisar el reporte técnico final.

## Limitaciones
La suite verifica la lógica con dependencias simuladas.
No comprueba una base de datos, disponibilidad ni correo reales.
Quedan posibles mejoras para tipos en minúsculas y fallos del
repositorio o del notificador. El 100 % de cobertura no garantiza
que todos los comportamientos estén protegidos.