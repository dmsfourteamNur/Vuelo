package UseCases.Command.Vuelos.Editar;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class EditarVueloCommandTest {
	@Test
	public void dataValid() {

		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();

		final VueloDto vueloDto = new VueloDto();

		vueloDto.setKey(key);
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);

		EditarVueloCommand command = new EditarVueloCommand(vueloDto.getKey());
		command.vueloDto.setKey(key);
		command.vueloDto.setNroVuelo(nroVuelo);
		command.vueloDto.setKeyAeronave(keyAeronave);
		command.vueloDto.setOrigen(origen);
		command.vueloDto.setDestino(destino);
		command.vueloDto.setFechaSalida(fechaSalida);
		command.vueloDto.setFechaArribe(fechaArribe);
		command.vueloDto.setKeyTripulacion(keyTripulacion);

		Assert.assertEquals(key, command.vueloDto.getKey());
		Assert.assertEquals(nroVuelo, command.vueloDto.nroVuelo);
		Assert.assertEquals(keyAeronave, command.vueloDto.keyAeronave);
		Assert.assertEquals(origen, command.vueloDto.origen);
		Assert.assertEquals(destino, command.vueloDto.destino);
		Assert.assertEquals(fechaSalida, command.vueloDto.fechaSalida);
		Assert.assertEquals(fechaArribe, command.vueloDto.fechaArribe);
		Assert.assertEquals(keyTripulacion, command.vueloDto.keyTripulacion);

	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
				EditarVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
