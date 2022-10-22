package UseCases.Command.Vuelos.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
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

public class EditarVueloHandler_Test {
	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);
	ITripulacionRepository iTripulacionRepository = Mockito.mock(ITripulacionRepository.class);

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
		// List<Asiento> asientos = new ArrayList<>();
		// List<Tripulante> tripulantes = new ArrayList<>();

		Aeronave aeronave = new Aeronave(keyAeronave, observacion, estado);
		// Assert.assertNotNull(aeronave);

		when(iAeronaveRepository.FindByKey(any(UUID.class))).thenReturn(aeronave);

		Tripulacion tripulacion = new Tripulacion(keyTripulacion, observacion, estado);
		when(iTripulacionRepository.FindByKey(any(UUID.class))).thenReturn(tripulacion);

		List<Asiento> listAsiento = new ArrayList<Asiento>();
		Asiento asiento = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 0, "comercial", 20.00, 1);
		listAsiento.add(asiento);
		aeronave.setAsientos(listAsiento);

		List<Tripulante> listTripulante = new ArrayList<Tripulante>();
		listTripulante.add(new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "carlos", "marcos", "piloto", "1"));
		tripulacion.setTripulantes(listTripulante);

		// Tripulante tripulante = new Tripulante(UUID.randomUUID(), UUID.randomUUID(),
		// "carlos", "marcos", "piloto", "1");
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, new ArrayList<>(), listTripulante);

		vuelo.setAsientos(listAsiento);
		vuelo.setTripulantes(listTripulante);

		when(iVueloFactory.Create(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, listAsiento, listTripulante)).thenReturn(vuelo);
		when(iVueloRepository.FindByKey(any(UUID.class))).thenReturn(vuelo);

		// when(iVueloRepository.findFechaSalida(fechaSalida)).thenReturn(vuelo);

		EditarVueloHandler handler = new EditarVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();
		EditarVueloCommand command = new EditarVueloCommand(vueloDto.key);

		command.vueloDto.key = UUID.randomUUID();
		command.vueloDto.nroVuelo = "2";
		command.vueloDto.keyAeronave = UUID.randomUUID();
		command.vueloDto.origen = "scz";
		command.vueloDto.destino = "cbba";
		command.vueloDto.fechaSalida = new Date();
		command.vueloDto.fechaArribe = new Date();
		command.vueloDto.keyTripulacion = UUID.randomUUID();
		command.vueloDto.observacion = "En horario";
		command.vueloDto.estado = "1";

		VueloDto resp = handler.handle(command);
		Assert.assertNotNull(resp);
	}

}