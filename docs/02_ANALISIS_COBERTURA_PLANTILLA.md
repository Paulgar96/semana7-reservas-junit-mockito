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