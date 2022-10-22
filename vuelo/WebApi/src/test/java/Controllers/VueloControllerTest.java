package Controllers;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.mediator.Mediator;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;

public class VueloControllerTest {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	GetAllVueloQuery getAllVueloQuery = Mockito.mock(GetAllVueloQuery.class);
	Mediator mediator = Mockito.mock(Mediator.class);

	@Before
	public void setup() {

	}

	// @Test
	public void Handler_ok() throws Exception {

		final String nroVuelo = "scz-cba-513184";
		final UUID keyAeronave = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();
		final String observacion = "En horario";
		final String estado = "1";
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida,
				fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		VueloDto vueloDto = new VueloDto(nroVuelo, keyAeronave, origen, destino,
				fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, null, null);

		VueloController vueloController = new VueloController(any(Mediator.class));
		mediator.send(new GetAllVueloQuery());
		GetAllVueloQuery getAllVueloQuery = new GetAllVueloQuery();
		// vueloController.getAll();

		CrearVueloCommand crearVueloCommand = new CrearVueloCommand(vueloDto);
		// vueloController.register(crearVueloCommand);

		EditarVueloCommand EditarVueloCommand = new EditarVueloCommand(vuelo.key);
		// vueloController.edit(vuelo, EditarVueloCommand);

		EliminarVueloCommand eliminarVueloCommand = new EliminarVueloCommand(vuelo.key);
		// vueloController.delete(eliminarVueloCommand);

		GetVueloByKeyQuery getVueloByKeyQuery = new GetVueloByKeyQuery(vuelo.key);
		// vueloController.getByKey(getVueloByKeyQuery);
	}

}
