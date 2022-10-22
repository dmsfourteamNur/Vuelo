package Event;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class VueloCreadoTest {

	@Test
	public void test1() {
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

		VueloCreado vueloCreado = new VueloCreado();

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

		Assert.assertEquals(key, vueloCreado.getKey());
		Assert.assertEquals(nroVuelo, vueloCreado.getNroVuelo());
		Assert.assertEquals(keyAeronave, vueloCreado.getKeyAeronave());
		Assert.assertEquals(origen, vueloCreado.getOrigen());
		Assert.assertEquals(destino, vueloCreado.getDestino());
		Assert.assertEquals("la fecha es diferente", fechaSalida, vueloCreado.getFechaSalida());
		Assert.assertEquals(fechaArribe, vueloCreado.getFechaArribe());
		Assert.assertEquals(keyTripulacion, vueloCreado.getKeyTripulacion());
		Assert.assertEquals(observacion, vueloCreado.getObservacion());
		Assert.assertEquals(estado, vueloCreado.getEstado());

	}

}
