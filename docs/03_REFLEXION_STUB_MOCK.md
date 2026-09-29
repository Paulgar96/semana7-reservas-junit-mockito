# Reflexión sobre Stub y Mock

En este laboratorio utilicé un Stub para controlar la respuesta
del servicio de disponibilidad mediante when(...).thenReturn(...).
Esto permitió simular reservas disponibles y no disponibles
sin consultar un servicio externo.

Utilicé Mock para comprobar las interacciones mediante verify(...).
Verifiqué que una reserva disponible se guardara y notificara.
Con never() comprobé que estas acciones no ocurrieran cuando
no había disponibilidad y que una reserva nula no consultara
ninguna dependencia.

La diferencia práctica es que el Stub proporciona respuestas
preparadas, mientras que el Mock permite verificar las llamadas
realizadas. Un mismo objeto creado con Mockito puede cumplir
ambos papeles según cómo se utilice en la prueba.

Aprendí que verificar el resultado y las interacciones permite
probar la lógica sin una base de datos ni un servidor de correo.
Además, JaCoCo me ayudó a identificar que cancelar() no estaba
probado y a incorporar una prueba que comprueba el estado final.