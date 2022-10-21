package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class TripulacionDtoTest {

	@Test
	public void CheckPropertiesValid() {
		UUID keyTripulacion = UUID.randomUUID();
		String descripcion = "Grupo-A";
		String estado = "0";
		List<TripulanteDto> tripulantes = getListdaTripulantes();
		TripulacionDto tripulacionDto = new TripulacionDto();

		Assert.assertEquals(null, tripulacionDto.getKeyTripulacion());
		Assert.assertNull(null, tripulacionDto.getDescripcion());
		Assert.assertNull(null, tripulacionDto.getEstado());
		Assert.assertEquals(0, tripulantes.size());
		tripulacionDto.setKeyTripulacion(keyTripulacion);
		tripulacionDto.setDescripcion(descripcion);
		tripulacionDto.setEstado(estado);
		tripulacionDto.setTripulantes(tripulantes);
		Assert.assertEquals(keyTripulacion, tripulacionDto.getKeyTripulacion());
		Assert.assertNotNull(descripcion, tripulacionDto.getDescripcion());
		Assert.assertNotNull(estado, tripulacionDto.getEstado());
		Assert.assertEquals(tripulantes, tripulacionDto.getTripulantes());
	}

	public List<TripulanteDto> getListdaTripulantes() {
		return new ArrayList<>();
	}

}
