package Model.Vuelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;

public class VueloTest {

	@Test
	public void constructorVoid_accept() {
		Assert.assertNotNull(new Vuelo());
	}

	@Test
	public void constructor_accept() {
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		List<Asiento> asientos = new ArrayList<>();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		List<Tripulante> tripulantes = new ArrayList<>();
		String observacion = "En horario";
		String estado = "1";

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);

		Assert.assertEquals(nroVuelo, vuelo.getNroVuelo());
		Assert.assertEquals(keyAeronave, vuelo.getKeyAeronave());
		Assert.assertEquals(asientos, vuelo.getAsientos());
		Assert.assertEquals(origen, vuelo.getOrigen());
		Assert.assertEquals(destino, vuelo.getDestino());
		Assert.assertEquals(fechaSalida, vuelo.getFechaSalida());
		Assert.assertEquals(fechaArribe, vuelo.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vuelo.getKeyTripulacion());
		Assert.assertEquals(tripulantes, vuelo.getTripulantes());
		Assert.assertEquals(observacion, vuelo.getObservacion());
		Assert.assertEquals(estado, vuelo.getEstado());

		vuelo.setNroVuelo(nroVuelo);
		vuelo.setKeyAeronave(keyAeronave);
		vuelo.setAsientos(asientos);
		vuelo.setOrigen(origen);
		vuelo.setDestino(destino);
		vuelo.setFechaSalida(fechaSalida);
		vuelo.setFechaArribe(fechaArribe);
		vuelo.setKeyTripulacion(keyTripulacion);
		vuelo.setTripulantes(tripulantes);
		vuelo.setObservacion(observacion);
		vuelo.setEstado(estado);
		vuelo.eventCreado();
	}

	@Test
	public void constructor_denied() {
		String nroVuelo = "";
		UUID keyAeronave = null;
		List<Asiento> asientos = null;
		String origen = "";
		String destino = "";
		Date fechaSalida = null;
		Date fechaArribe = null;
		UUID keyTripulacion = null;
		List<Tripulante> tripulantes = null;
		String observacion = "";
		String estado = "";
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
	}

	@Test
	public void addDomainEvent_accept() {

		// final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();
		final String observacion = "En horario";
		final String estado = "1";
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida,
				fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		vuelo.eventCreado();
		Assert.assertEquals(vuelo.domainEvents.size(), 1);
	}

}
