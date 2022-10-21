package UseCases.Command.Vuelos.Eliminar;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class EliminarVueloCommandTest {
	@Test
	public void dataValid() {

		final UUID key = UUID.randomUUID();
		// final String nroVuelo = "scz-cba-513184";
		// final UUID keyAeronave = UUID.randomUUID();
		// final String origen = "Scz-ViruViru";
		// final String destino = "CBA-CBA";
		// final Date fechaSalida = new Date();
		// final Date fechaArribe = new Date();
		// final UUID keyTripulacion = UUID.randomUUID();

		final VueloDto vueloDto = new VueloDto();

		vueloDto.setKey(key);
		// vueloDto.setNroVuelo(nroVuelo);
		// vueloDto.setKeyAeronave(keyAeronave);
		// vueloDto.setOrigen(origen);
		// vueloDto.setDestino(destino);
		// vueloDto.setFechaSalida(fechaSalida);
		// vueloDto.setFechaArribe(fechaArribe);
		// vueloDto.setKeyTripulacion(keyTripulacion);

		EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.getKey());
		Assert.assertEquals(key, command.vueloDto.getKey());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				EliminarVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
