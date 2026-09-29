# Matriz de casos

| ID | Regla | Escenario | Entrada | Esperado | Tipo | Riesgo |
|---|---|---|---|---|---|---|
| CP-01 | Cancelación con 2 horas o más | Anticipación habitual | 5 horas | true | Normal | Comprueba que se permite cancelar con suficiente anticipación. |
| CP-02 | Cancelación con 2 horas o más | Límite exacto | 2 horas | true | Límite | Detecta si se usa > en lugar de >=. |
| CP-03 | Cancelación con 2 horas o más | Debajo del límite | 1 hora | false | Límite | Comprueba que una hora no es suficiente. |
| CP-04 | Cancelación con 2 horas o más | Sin anticipación | 0 horas | false | Extremo | No permite cancelar al momento de la reserva. |
| CP-05 | NORMAL sin descuento | Precio habitual | NORMAL, 100 | 100 | Normal | Comprueba que no se aplique descuento. |
| CP-06 | VIP con 15 % de descuento | Precio habitual | VIP, 100 | 85 | Alternativo | Comprueba el porcentaje VIP. |
| CP-07 | ESTUDIANTE con 10 % de descuento | Precio habitual | ESTUDIANTE, 100 | 90 | Alternativo | Comprueba el porcentaje estudiantil. |
| CP-08 | Total base cero | Descuento VIP sobre cero | VIP, 0 | 0 | Límite | Comprueba que cero sea válido. |
| CP-09 | Total negativo inválido | Precio menor que cero | NORMAL, -1 | IllegalArgumentException | Inválido | Impide aceptar un total negativo. |
| CP-10 | Confirmación con disponibilidad | Reserva disponible | R-001, disponibilidad true | CONFIRMADA; guardar y notificar una vez | Normal | Evita confirmar sin persistir o notificar. |
| CP-11 | Confirmación sin disponibilidad | Horario no disponible | R-002, disponibilidad false | IllegalStateException; estado PENDIENTE; sin guardar ni notificar | Alternativo / Excepción | Evita modificar o guardar una reserva sin disponibilidad. |
| CP-12 | Reserva obligatoria | Reserva nula | null | IllegalArgumentException; ninguna dependencia consultada | Inválido / Excepción | Detiene el flujo antes de realizar acciones externas. |
| CP-13 | Cancelación de reserva | Reserva confirmada | Reserva en CONFIRMADA | Estado CANCELADA | Normal | Comprueba el cambio de estado al cancelar. |
| CP-14 | Identificador obligatorio | Identificador nulo | id null, tipo NORMAL | IllegalArgumentException: Id obligatorio | Inválido / Excepción | Impide crear reservas sin identificación. |
| CP-15 | Identificador obligatorio | Identificador en blanco | id "   ", tipo NORMAL | IllegalArgumentException: Id obligatorio | Inválido / Excepción | Impide aceptar espacios como identificación. |
| CP-16 | Tipo predeterminado | Tipo nulo | id R-004, tipo null | Tipo NORMAL; estado PENDIENTE; id R-004 | Alternativo | Comprueba los valores iniciales y el tipo predeterminado. |