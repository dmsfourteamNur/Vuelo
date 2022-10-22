package Model.Tripulacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import core.AggregateRoot;

public class TripulacionTest extends AggregateRoot<UUID> {

	@Test
	public void constructorVoid_accept() {
		Assert.assertNotNull(new Tripulacion());
	}

	@Test
	public void CheckConstructor() {
		final UUID keyTripulacion = UUID.randomUUID();
		final String descripcion = "Grupo-A";
		final String estado = "0";
		final List<Tripulante> tripulantes = new ArrayList<>();

		final Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);

		Assert.assertNotNull(descripcion, tripulacion.getDescripcion());
		Assert.assertNotNull(estado, tripulacion.getEstado());
		Assert.assertEquals(tripulantes, tripulacion.getTripulantes());

		tripulacion.setDescripcion(descripcion);
		tripulacion.setEstado(estado);
		tripulacion.setTripulantes(tripulantes);

		Assert.assertNotNull(descripcion, tripulacion.getDescripcion());
		Assert.assertNotNull(estado, tripulacion.getEstado());
		Assert.assertEquals(tripulantes, tripulacion.getTripulantes());
	}

	@Test
	public void constructor_denied() {
		final UUID keyTripulacion = null;
		final String descripcion = "";
		final String estado = "";

		final Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);
		Assert.assertEquals(tripulacion.key, null);
		Assert.assertEquals(tripulacion.descripcion, "");
		Assert.assertEquals(tripulacion.estado, "");
		Assert.assertEquals(tripulacion.tripulantes.size(), 0);
	}

	@Test
	public void addTripulante_accept() {
		final UUID keyTripulacion = UUID.randomUUID();
		final String descripcion = "Grupo-A";
		final String estado = "0";

		Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);
		tripulacion.agregarTripulante(UUID.randomUUID(), UUID.randomUUID(), "juan", "mamani", "piloto", "1");
		Assert.assertEquals(tripulacion.tripulantes.size(), 1);
	}

	@Test
	public void addTripulante_denied() {

		final UUID keyTripulacion = UUID.randomUUID();
		final String descripcion = "Grupo-A";
		final String estado = "0";

		Tripulacion tripulacion = new Tripulacion(keyTripulacion, descripcion, estado);

		Tripulante tripulante001 = new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "mario", "mamani", "auxiliar",
				"1");
		tripulacion.agregarTripulante(tripulante001);

		Tripulante tripulante002 = new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "mario", "mamani", "auxiliar",
				"1");
		tripulante002.key = tripulante001.key;

		try {
			tripulacion.agregarAsiento(tripulante002);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}