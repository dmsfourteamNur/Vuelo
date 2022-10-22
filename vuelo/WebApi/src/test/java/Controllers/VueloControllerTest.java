package Controllers;

import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mockito;

import Factories.IVueloFactory;
import Fourteam.mediator.Mediator;
import Repositories.IVueloRepository;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;

public class VueloControllerTest {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	GetAllVueloQuery getAllVueloQuery = Mockito.mock(GetAllVueloQuery.class);
	Mediator mediator = Mockito.mock(Mediator.class);

	// @Test
	public void HandleTripulanteController_Ok() throws Exception {
		// creando tripulante

		// Cargo cargoTest = new Cargo("asistente");

		VueloController vueloController = new VueloController(any(Mediator.class));
		mediator.send(new GetAllVueloQuery());
		vueloController.getAll();
		vueloController.getByKey(any());
		vueloController.delete(any());
		vueloController.getAll();

	}

	// @Test
	public void testDelete() {

	}

	// @Test
	public void testEdit() {

	}

	// @Test
	public void testGetAll() {

	}

	// @Test
	public void testGetByKey() {

	}

	// @Test
	public void testRegister() {

	}
}
