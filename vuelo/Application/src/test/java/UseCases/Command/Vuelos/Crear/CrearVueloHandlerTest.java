package UseCases.Command.Vuelos.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Factories.IVueloFactory;
import Model.Aeronaves.Aeronave;
import Model.Tripulacion.Tripulacion;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class CrearVueloHandlerTest {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);
	ITripulacionRepository iTripulacionRepository = Mockito.mock(ITripulacionRepository.class);

	@Before
	public void setUp() {
	}

	//@Test
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
		List<AsientoDto> asientos = new ArrayList<>();
		List<TripulanteDto> tripulantes = new ArrayList<>();

		String matricula = "ASD";
		String keyModelo = UUID.randomUUID().toString();

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, anyList(), anyList());
		when(iVueloFactory.Create(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, anyList(), anyList()));

		Tripulacion tripulacion = iTripulacionRepository.FindByKey(keyTripulacion);
		when(iTripulacionRepository.FindByKey(any())).thenReturn(tripulacion);

		Aeronave aeronave = iAeronaveRepository.FindByKey(keyAeronave);
		when(iAeronaveRepository.FindByKey(any())).thenReturn(aeronave);

		CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();

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

	}
}