package UseCases.Command.Vuelos.Eliminar;

import org.junit.Before;
import org.mockito.Mockito;

import Factories.IVueloFactory;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EliminarVueloHandlerTest {

	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);

	// IAeronaveRepository iAeronaveRepository =
	// Mockito.mock(IAeronaveRepository.class);
	// ITripulacionRepository iTripulacionRepository =
	// Mockito.mock(ITripulacionRepository.class);

	@Before
	public void setUp() {
	}

}
