package edu.uees.testing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReservaTest {

    @Test
    void identificadorNuloImpideCrearReserva() {
        // Arrange
        String id = null;

        // Act
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class,
            () -> new Reserva(id, "NORMAL")
        );

        // Assert
        assertEquals("Id obligatorio", error.getMessage());
    }

    @Test
    void identificadorEnBlancoImpideCrearReserva() {
        // Arrange
        String id = "   ";

        // Act
        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class,
            () -> new Reserva(id, "NORMAL")
        );

        // Assert
        assertEquals("Id obligatorio", error.getMessage());
    }

    @Test
    void tipoNuloAsignaNormalYEstadoPendiente() {
        // Arrange
        String id = "R-004";
        String tipo = null;

        // Act
        Reserva reserva = new Reserva(id, tipo);

        // Assert
        assertEquals("R-004", reserva.getId());
        assertEquals("NORMAL", reserva.getTipo());
        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
    }
}