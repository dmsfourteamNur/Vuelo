package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Model.Vuelos.Vuelo;

public class VueloDto_Test {
	@Test
	public void CheckPropertiesValid() {

		UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "En horario";
		String estado = "1";
		List<AsientoDto> asientos = getListAsiento();
		List<TripulanteDto> tripulantes = getListdaTripulantes();

		VueloDto vueloDto = new VueloDto();

		Assert.assertEquals(null, vueloDto.getKey());
		Assert.assertNull(null, vueloDto.getNroVuelo());
		Assert.assertNull(null, vueloDto.getKeyAeronave());
		Assert.assertEquals(0, asientos.size());
		Assert.assertNull(null, vueloDto.getOrigen());
		Assert.assertNull(null, vueloDto.getDestino());
		Assert.assertNull(null, vueloDto.getFechaSalida());
		Assert.assertNull(null, vueloDto.getFechaArribe());
		Assert.assertNull(null, vueloDto.getKeyTripulacion());
		Assert.assertEquals(0, tripulantes.size());
		Assert.assertNull(null, vueloDto.getObservacion());
		Assert.assertNull(null, vueloDto.getEstado());
		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setAsientos(asientos);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		vueloDto.setTripulantes(tripulantes);
		vueloDto.setObservacion(observacion);
		vueloDto.setEstado(estado);

		Vuelo vuelo = new Vuelo();

		Assert.assertEquals(key, vueloDto.getKey());
		Assert.assertEquals(nroVuelo, vueloDto.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloDto.getKeyAeronave());
		Assert.assertEquals(asientos, vueloDto.getAsientos());
		Assert.assertEquals(origen, vueloDto.getOrigen());
		Assert.assertEquals(destino, vueloDto.getDestino());
		Assert.assertEquals(fechaSalida, vueloDto.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloDto.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloDto.getKeyTripulacion());
		Assert.assertEquals(tripulantes, vueloDto.getTripulantes());
		Assert.assertEquals(observacion, vueloDto.getObservacion());
		Assert.assertEquals(estado, vueloDto.getEstado());

	}

	public List<AsientoDto> getListAsiento() {
		return new ArrayList<>();
	}

	public List<TripulanteDto> getListdaTripulantes() {
		return new ArrayList<>();
	}
}
