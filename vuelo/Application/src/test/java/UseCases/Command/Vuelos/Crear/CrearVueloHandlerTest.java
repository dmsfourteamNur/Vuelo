package UseCases.Command.Vuelos.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
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

	// @Test
	public void HandleCorrectly() throws Exception {

		CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

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

		Aeronave aeronave = iAeronaveRepository.FindByKey(keyAeronave);
		when(iAeronaveRepository.FindByKey(keyAeronave)).thenReturn(aeronave);
		if (aeronave != null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Ya existe una aeronave con esta matricula.");
		}

		if (origen.equals(destino))
			throw new HttpException(HttpStatus.BAD_REQUEST, "son iguales origen y destino, ingresar otro ");

		// Vuelo fecha = iVueloRepository.findFechaSalida(any());
		// if (fecha != null)
		// throw new HttpException(HttpStatus.BAD_REQUEST, "la fecha de salida del vuelo
		// ya existe.");

		Tripulacion tripulacion = iTripulacionRepository.FindByKey(keyTripulacion);
		when(iTripulacionRepository.FindByKey(any())).thenReturn(tripulacion);
		if (tripulacion != null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Ya existe la tripulacion.");
		}

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, getListAsiento(), getListdaTripulantes());

		when(iVueloFactory.Create(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, getListAsiento(), getListdaTripulantes())).thenReturn(vuelo);

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

		CrearVueloCommand command = new CrearVueloCommand(vueloDto);
		try {
			Vuelo resp = handler.handle(command);

			verify(iUnitOfWork).commit();
			Assert.assertNotNull(resp);

			// if (resp != null) {
			// throw new HttpException(HttpStatus.BAD_REQUEST, "Ya existe la tripulacion.");
			// }

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<Asiento> getListAsiento() {
		return new ArrayList<>();
	}

	public List<Tripulante> getListdaTripulantes() {
		return new ArrayList<>();
	}
}