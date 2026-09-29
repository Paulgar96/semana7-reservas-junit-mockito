# Análisis de cobertura

## Resultado observado

- Cobertura de líneas: 92,31 % (36 de 39 líneas).
- Cobertura de instrucciones: aumentó de 87 % a 90 %.
- Cobertura de ramas: 83 % (15 de 18 ramas).
- Clase o método analizado: Reserva.cancelar().
- Antes de la prueba adicional, cancelar() tenía 0 % de cobertura.
- La suite final ejecutó 14 pruebas, sin fallos ni errores.

## Huecos relevantes

1. El método cancelar() no estaba probado. Se agregó una prueba
   que verifica que una reserva confirmada cambie a CANCELADA.

2. Todavía faltan pruebas del constructor de Reserva:
   rechazar un identificador nulo o en blanco y asignar NORMAL
   cuando el tipo sea nulo. Estos escenarios permitirían
   cubrir las ramas pendientes.

## Decisiones

- ¿Qué prueba nueva se añadió?
  cancelarReservaConfirmadaCambiaEstadoACancelada.

- ¿Qué riesgo protege?
  Detecta que cancelar() no cambie el estado o asigne un
  estado incorrecto a una reserva confirmada.

- ¿Por qué no basta con el porcentaje?
  La cobertura indica qué código se ejecutó, pero no garantiza
  que las pruebas comprueben todos los resultados importantes.
  Por ejemplo, la prueba de reserva sin disponibilidad verifica
  la excepción y que no se guarde ni notifique, pero todavía
  podría añadir una aserción que compruebe que la reserva
  conserve su estado PENDIENTE.

- Comparación después de agregar la prueba:
  La cobertura de instrucciones aumentó de 87 % a 90 %.
  La cobertura de ramas permaneció en 83 %, porque cancelar()
  no contiene condiciones.
  ## Actualización de cobertura — Ae6

La suite ejecutó 17 pruebas, sin fallos ni errores. JaCoCo registró
100 % de cobertura de instrucciones (138/138) y ramas (18/18).

ReservaService alcanzó 100 % de instrucciones y ramas en confirmar,
calcularTotal y puedeCancelar. En la versión final no existen métodos
o ramas con menor cobertura de ejecución.

Antes de Ae6, la cobertura global era aproximadamente 90 % de
instrucciones y 83 % de ramas. Los comportamientos pendientes estaban
en Reserva: validación del identificador, tipo nulo y métodos getters.

Como resultado del análisis se incorporaron pruebas para rechazar
identificadores nulos o en blanco y comprobar que un tipo nulo asigna
NORMAL, conserva el identificador e inicia en estado PENDIENTE.
Además, se reforzó el escenario sin disponibilidad para comprobar
que la reserva permanece PENDIENTE.

El 100 % de cobertura indica que se ejecutaron todas las instrucciones
y ramas medidas; no garantiza que se verificaron todos los escenarios.
Por ejemplo, todavía podría incorporarse una prueba que compruebe
que el tipo "vip" en minúsculas recibe el descuento del 15 %.
Aunque ejecuta una rama ya cubierta, protegería el comportamiento
de comparación sin distinguir mayúsculas y minúsculas.