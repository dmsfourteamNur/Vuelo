package Model.Tripulacion;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import core.Entity;

public class TripulanteTest extends Entity<UUID> {
	@Test
	public void CheckConstructor() {
		UUID keyTripulacion = UUID.randomUUID();
		UUID keyTripulante = UUID.randomUUID();
		String nombre = "manuel";
		String apellido = "soliz marin";
		String cargo = "Piloto";
		String estado = "0";

		final Tripulante tripulante = new Tripulante(keyTripulante, keyTripulacion, nombre, apellido, cargo, estado);

		Assert.assertEquals(keyTripulacion, tripulante.getKeyTripulacion());
		Assert.assertEquals(nombre, tripulante.getNombre());
		Assert.assertEquals(apellido, tripulante.getApellido());
		Assert.assertEquals(cargo, tripulante.getCargo());
		Assert.assertEquals(estado, tripulante.getEstado());

		tripulante.setKeyTripulacion(keyTripulacion);
		tripulante.setNombre(nombre);
		tripulante.setApellido(apellido);
		tripulante.setCargo(cargo);
		tripulante.setEstado(estado);

		Assert.assertEquals(keyTripulacion, tripulante.getKeyTripulacion());
		Assert.assertEquals(nombre, tripulante.getNombre());
		Assert.assertEquals(apellido, tripulante.getApellido());
		Assert.assertEquals(cargo, tripulante.getCargo());
		Assert.assertEquals(estado, tripulante.getEstado());
	}
}
