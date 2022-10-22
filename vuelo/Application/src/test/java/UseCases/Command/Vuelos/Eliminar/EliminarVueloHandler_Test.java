package UseCases.Command.Vuelos.Eliminar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EliminarVueloHandler_Test {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {
	}

	@Test
	public void HandleCorrectly() throws Exception {
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
		List<Asiento> asientos = new ArrayList<>();
		List<Tripulante> tripulantes = new ArrayList<>();
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		vuelo.key = key;
		when(iVueloRepository.FindByKey(any(UUID.class))).thenReturn(vuelo);
		when(iVueloRepository.Delete(any(Vuelo.class))).thenReturn(vuelo);

		EliminarVueloHandler handler = new EliminarVueloHandler(iVueloFactory,
				iVueloRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();
		Assert.assertEquals(null, vueloDto.getKey());
		Assert.assertNull(null, vueloDto.getNroVuelo());
		Assert.assertNull(null, vueloDto.getKeyAeronave());
		Assert.assertNull(null, vueloDto.getOrigen());
		Assert.assertNull(null, vueloDto.getDestino());
		Assert.assertNull(null, vueloDto.getFechaSalida());
		Assert.assertNull(null, vueloDto.getFechaArribe());
		Assert.assertNull(null, vueloDto.getKeyTripulacion());
		// Assert.assertEquals(0, asientos.size());
		// Assert.assertEquals(0, tripulantes.size());
		Assert.assertNull(null, vueloDto.getObservacion());
		Assert.assertNull(null, vueloDto.getEstado());
		vueloDto.key = key;
		vueloDto.nroVuelo = nroVuelo;
		vueloDto.keyAeronave = keyAeronave;
		vueloDto.origen = origen;
		vueloDto.destino = destino;
		vueloDto.fechaSalida = fechaSalida;
		vueloDto.fechaArribe = fechaArribe;
		vueloDto.keyTripulacion = keyAeronave;
		vueloDto.observacion = observacion;
		vueloDto.estado = estado;
		vueloDto.setNroVuelo(nroVuelo);
		vueloDto.setKeyAeronave(keyAeronave);
		vueloDto.setOrigen(origen);
		vueloDto.setDestino(destino);
		vueloDto.setFechaSalida(fechaSalida);
		vueloDto.setFechaArribe(fechaArribe);
		vueloDto.setKeyTripulacion(keyTripulacion);
		vueloDto.setObservacion(observacion);
		vueloDto.setEstado(estado);

		EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.key);
		UUID resp = handler.handle(command);
		Assert.assertEquals(vuelo.key, resp);
	}

	// // @Test
	// public void HandleFailed() throws Exception {
	// when(iVueloRepository.FindByKey(any())).thenReturn(null);
	// EliminarVueloHandler handler = new EliminarVueloHandler(iVueloFactory,
	// iVueloRepository, iUnitOfWork);

	// VueloDto vueloDto = new VueloDto();
	// UUID key = UUID.randomUUID();
	// String nroVuelo = "scz-cba-513184";
	// UUID keyAeronave = UUID.randomUUID();
	// String origen = "Scz-ViruViru";
	// String destino = "CBA-CBA";
	// Date fechaSalida = new Date();
	// Date fechaArribe = new Date();
	// UUID keyTripulacion = UUID.randomUUID();
	// String observacion = "En horario";
	// String estado = "1";
	// List<Asiento> asientos = getListAsiento();
	// List<Tripulante> tripulantes = getListdaTripulantes();

	// vueloDto.setKey(key);
	// vueloDto.setNroVuelo(nroVuelo);
	// vueloDto.setKeyAeronave(keyAeronave);
	// // vueloDto.setAsientos(asientos);
	// vueloDto.setOrigen(origen);
	// vueloDto.setDestino(destino);
	// vueloDto.setFechaSalida(fechaSalida);
	// vueloDto.setFechaArribe(fechaArribe);
	// vueloDto.setKeyTripulacion(keyTripulacion);
	// // vueloDto.setTripulantes(tripulantes);
	// vueloDto.setObservacion(observacion);
	// vueloDto.setEstado(estado);

	// // EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.key);
	// // try {
	// // UUID resp = handler.handle(command);
	// // } catch (HttpException e) {
	// // Assert.assertEquals(400, e.getCode());
	// // }
	// }

	// public List<Asiento> getListAsiento() {
	// return new ArrayList<>();
	// }

	// public List<Tripulante> getListdaTripulantes() {
	// return new ArrayList<>();
	// }
}
