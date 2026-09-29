package edu.uees.testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.uees.testing.availability.DisponibilidadClient;
import edu.uees.testing.domain.EstadoReserva;
import edu.uees.testing.domain.Reserva;
import edu.uees.testing.notification.Notificador;
import edu.uees.testing.repository.ReservaRepository;
import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Punto de partida.
 * El estudiante debe ampliar esta suite durante las actividades.
 */
class ReservaServiceTest {

    @Test
    void entornoJUnitFunciona() {
        assertTrue(true);
    }

    @Test
    void dosHorasEsElLimitePermitido() {
        // Arrange
        ReservaService servicio = new ReservaService(null, null, null);
        int horas = 2;

    // Act
    boolean resultado = servicio.puedeCancelar(horas);

    // Assert
    assertTrue(resultado);
}

@Test
void cincoHorasPermitenCancelar() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    int horas = 5;

    // Act
    boolean resultado = servicio.puedeCancelar(horas);

    // Assert
    assertTrue(resultado);
}

@Test
void unaHoraNoPermiteCancelar() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    int horas = 1;

    // Act
    boolean resultado = servicio.puedeCancelar(horas);

    // Assert
    assertFalse(resultado);
}

@Test
void ceroHorasNoPermitenCancelar() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    int horas = 0;

    // Act
    boolean resultado = servicio.puedeCancelar(horas);

    // Assert
    assertFalse(resultado);
}
    @Test
void normalNoRecibeDescuento() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    double totalBase = 100;

    // Act
    double resultado = servicio.calcularTotal("NORMAL", totalBase);

    // Assert
    assertEquals(100.0, resultado, 0.001);
}

@Test
void vipRecibeQuincePorCiento() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    double totalBase = 100;

    // Act
    double resultado = servicio.calcularTotal("VIP", totalBase);

    // Assert
    assertEquals(85.0, resultado, 0.001);
}

@Test
void estudianteRecibeDiezPorCiento() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    double totalBase = 100;

    // Act
    double resultado = servicio.calcularTotal("ESTUDIANTE", totalBase);

    // Assert
    assertEquals(90.0, resultado, 0.001);
}
    @Test
void totalCeroPermaneceEnCero() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    double totalBase = 0;

    // Act
    double resultado = servicio.calcularTotal("VIP", totalBase);

    // Assert
    assertEquals(0.0, resultado, 0.001);
}

@Test
void totalNegativoEsInvalido() {
    // Arrange
    ReservaService servicio = new ReservaService(null, null, null);
    double totalBase = -1;

    // Act
    IllegalArgumentException error = assertThrows(
        IllegalArgumentException.class,
        () -> servicio.calcularTotal("NORMAL", totalBase)
    );

    // Assert
    assertEquals("Total base inválido", error.getMessage());
}
    //
@Test
void reservaDisponibleSeConfirmaGuardaYNotifica() {
    // Arrange
    DisponibilidadClient disponibilidad = mock(DisponibilidadClient.class);
    ReservaRepository repository = mock(ReservaRepository.class);
    Notificador notificador = mock(Notificador.class);
    when(disponibilidad.estaDisponible(any())).thenReturn(true);

    ReservaService servicio =
        new ReservaService(disponibilidad, repository, notificador);
    Reserva reserva = new Reserva("R-001", "NORMAL");

    // Act
    servicio.confirmar(reserva);

    // Assert
    assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    verify(repository).guardar(reserva);
    verify(notificador).enviarConfirmacion(reserva);
}
    @Test
void reservaNoDisponibleNoSeGuardaNiNotifica() {
    // Arrange
    DisponibilidadClient disponibilidad = mock(DisponibilidadClient.class);
    ReservaRepository repository = mock(ReservaRepository.class);
    Notificador notificador = mock(Notificador.class);
    when(disponibilidad.estaDisponible(any())).thenReturn(false);

    ReservaService servicio =
        new ReservaService(disponibilidad, repository, notificador);
    Reserva reserva = new Reserva("R-002", "NORMAL");

    // Act
    IllegalStateException error = assertThrows(
        IllegalStateException.class,
        () -> servicio.confirmar(reserva)
    );

    // Assert
    assertEquals("Horario no disponible", error.getMessage());
    assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
    verify(repository, never()).guardar(any());
    verify(notificador, never()).enviarConfirmacion(any());
}
@Test
void reservaNulaNoConsultaDependencias() {
    // Arrange
    DisponibilidadClient disponibilidad = mock(DisponibilidadClient.class);
    ReservaRepository repository = mock(ReservaRepository.class);
    Notificador notificador = mock(Notificador.class);

    ReservaService servicio =
        new ReservaService(disponibilidad, repository, notificador);

    // Act
    IllegalArgumentException error = assertThrows(
        IllegalArgumentException.class,
        () -> servicio.confirmar(null)
    );

    // Assert
    assertEquals("Reserva obligatoria", error.getMessage());
    verify(disponibilidad, never()).estaDisponible(any());
    verify(repository, never()).guardar(any());
    verify(notificador, never()).enviarConfirmacion(any());
}
    @Test
void cancelarReservaConfirmadaCambiaEstadoACancelada() {
    // Arrange
    Reserva reserva = new Reserva("R-003", "NORMAL");
    reserva.confirmar();
    assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());

    // Act
    reserva.cancelar();

    // Assert
    assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());


}
}


    


