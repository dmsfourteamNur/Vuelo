package Dto;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class TripulanteDto_Test {

	@Test
	public void CheckPropertiesValid() {

		UUID keyTripulacion = UUID.randomUUID();
		UUID keyTripulante = UUID.randomUUID();
		String nombre = "manuel";
		String apellido = "soliz marin";
		String cargo = "Piloto";
		String estado = "0";
		TripulanteDto tripulanteDto = new TripulanteDto();

		Assert.assertEquals(null, tripulanteDto.getKeyTripulacion());
		Assert.assertEquals(null, tripulanteDto.getKeyTripulante());
		Assert.assertEquals(null, tripulanteDto.getNombre());
		Assert.assertEquals(null, tripulanteDto.getApellido());
		Assert.assertEquals(null, tripulanteDto.getCargo());
		Assert.assertEquals(null, tripulanteDto.getEstado());
		tripulanteDto.setKeyTripulacion(keyTripulacion);
		tripulanteDto.setKeyTripulante(keyTripulante);
		tripulanteDto.setNombre(nombre);
		tripulanteDto.setApellido(apellido);
		tripulanteDto.setCargo(cargo);
		tripulanteDto.setEstado(estado);
		Assert.assertEquals(keyTripulacion, tripulanteDto.getKeyTripulacion());
		Assert.assertEquals(keyTripulante, tripulanteDto.getKeyTripulante());
		Assert.assertEquals(nombre, tripulanteDto.getNombre());
		Assert.assertEquals(apellido, tripulanteDto.getApellido());
		Assert.assertEquals(cargo, tripulanteDto.getCargo());
		Assert.assertEquals(estado, tripulanteDto.getEstado());
	}

	@Test
	public void CheckConstructor() {
		UUID keyTripulacion = UUID.randomUUID();
		UUID keyTripulante = UUID.randomUUID();
		String nombre = "manuel";
		String apellido = "soliz marin";
		String cargo = "Piloto";
		String estado = "0";
		TripulanteDto tripulanteDto = new TripulanteDto(keyTripulacion, keyTripulante, nombre, apellido, cargo,
				estado);

		Assert.assertEquals(keyTripulacion, tripulanteDto.getKeyTripulacion());
		Assert.assertEquals(keyTripulante, tripulanteDto.getKeyTripulante());
		Assert.assertEquals(nombre, tripulanteDto.getNombre());
		Assert.assertEquals(apellido, tripulanteDto.getApellido());
		Assert.assertEquals(cargo, tripulanteDto.getCargo());
		Assert.assertEquals(estado, tripulanteDto.getEstado());
	}

}
