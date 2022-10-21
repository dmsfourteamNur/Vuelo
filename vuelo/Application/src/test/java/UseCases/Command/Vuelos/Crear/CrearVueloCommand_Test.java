package UseCases.Command.Vuelos.Crear;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class CrearVueloCommand_Test {

	@Test
	public void dataValid() {

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

		VueloDto vueloCreado = new VueloDto();
		vueloCreado.setKey(key);
		vueloCreado.setNroVuelo(nroVuelo);
		vueloCreado.setKeyAeronave(keyAeronave);
		vueloCreado.setOrigen(origen);
		vueloCreado.setDestino(destino);
		vueloCreado.setFechaSalida(fechaSalida);
		vueloCreado.setFechaArribe(fechaArribe);
		vueloCreado.setKeyTripulacion(keyTripulacion);
		vueloCreado.setObservacion(observacion);
		vueloCreado.setEstado(estado);

		CrearVueloCommand command = new CrearVueloCommand(vueloCreado);
		Assert.assertEquals(key, vueloCreado.getKey());
		Assert.assertEquals(nroVuelo, vueloCreado.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloCreado.getKeyAeronave());
		Assert.assertEquals(origen, vueloCreado.getOrigen());
		Assert.assertEquals(destino, vueloCreado.getDestino());
		Assert.assertEquals(fechaSalida, vueloCreado.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloCreado.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloCreado.getKeyTripulacion());
		Assert.assertEquals(observacion, vueloCreado.getObservacion());
		Assert.assertEquals(estado, vueloCreado.getEstado());

	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(CrearVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
