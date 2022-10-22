package UseCases.Command.Vuelos.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
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

		Aeronave aeronave = new Aeronave(keyAeronave, observacion, estado);
		when(iAeronaveRepository.FindByKey(any(UUID.class))).thenReturn(aeronave);

		// when(aeronave.estado.equals("2")).thenAnswer(null);

		// if (aeronave.estado.equals("2"))
		// throw new HttpException(HttpStatus.BAD_REQUEST, "aeronave esta en vuelo, usar
		// otra");

		// if (origen.equals(destino))
		// throw new HttpException(HttpStatus.BAD_REQUEST, "son iguales origen y
		// destino, ingresar otro ");

		Tripulacion tripulacion = new Tripulacion(keyTripulacion, observacion, estado);
		when(iTripulacionRepository.FindByKey(any(UUID.class))).thenReturn(tripulacion);

		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);

		when(iVueloFactory.Create(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes)).thenReturn(vuelo);

		when(iVueloRepository.findFechaSalida(fechaSalida)).thenReturn(vuelo);

		Asiento asiento = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 0, "comercial", 20.00, 1);
		List<Asiento> listAsiento = new ArrayList<Asiento>();
		listAsiento.add(asiento);

		Tripulante tripulante = new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "carlos", "marcos", "piloto", "1");
		List<Tripulante> listTripulante = new ArrayList<Tripulante>();
		listTripulante.add(tripulante);

		CrearVueloHandler handler = new CrearVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();
		vueloDto.key = UUID.randomUUID();
		vueloDto.nroVuelo = "2";
		vueloDto.keyAeronave = UUID.randomUUID();
		vueloDto.origen = "scz";
		vueloDto.destino = "cbba";
		vueloDto.fechaSalida = new Date();
		vueloDto.fechaArribe = new Date();
		vueloDto.keyTripulacion = UUID.randomUUID();
		vueloDto.observacion = "En horario";
		vueloDto.estado = "1";
		// vuelo.setAsientos(asientos);
		// vuelo.setTripulantes(tripuslantes);
		// vueloDto.asientos = new ArrayList<>();
		// vueloDto.tripulantes = new ArrayList<>();
		CrearVueloCommand command = new CrearVueloCommand(vueloDto);

		// command.data.key = UUID.randomUUID();
		// command.data.nroVuelo = "2";
		// command.data.keyAeronave = UUID.randomUUID();
		// command.data.origen = "scz";
		// command.data.destino = "cbba";
		// command.data.fechaSalida = new Date();
		// command.data.fechaArribe = new Date();
		// command.data.keyTripulacion = UUID.randomUUID();
		// command.data.observacion = "En horario";
		// command.data.estado = "1";
		// command.data.asientos = new ArrayList<>();
		// command.data.tripulantes = new ArrayList<>();

		// Vuelo resp = handler.handle(command);
		// verify(iUnitOfWork).commit();
		// Assert.assertNotNull(resp);

	}
}