package UseCases.Command.Vuelos.Crear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;

public class CrearVueloCommand_Test {

	@Test
	public void dataValid() {

		// UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "En horario";
		String estado = "1";
		List<AsientoDto> asientos = new ArrayList<>();
		List<TripulanteDto> tripulantes = new ArrayList<>();

		VueloDto vueloDto = new VueloDto();
		// vueloDto.setKey(key);
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

		CrearVueloCommand command = new CrearVueloCommand(vueloDto);
		// Assert.assertEquals(key, command.vueloDto.getKey());

	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(CrearVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
