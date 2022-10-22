package UseCases.Queries.Vuelos.GetAll;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;

public class GetAllVueloHandlerTest {
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);

	@Test
	public void HandleCorrectly() throws Exception {

		Asiento asiento = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 0, "comercial", 20.00, 1);
		List<Asiento> listAsiento = new ArrayList<Asiento>();
		listAsiento.add(asiento);

		Tripulante tripulante = new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "carlos", "marcos", "piloto", "1");
		List<Tripulante> listTripulante = new ArrayList<Tripulante>();
		listTripulante.add(tripulante);

		Vuelo a = new Vuelo("1", UUID.randomUUID(), "sc", "cbba", new Date(), new Date(), UUID.randomUUID(),
				"en horario", "1", new ArrayList<>(), new ArrayList<>());

		a.setAsientos(listAsiento);
		a.setTripulantes(listTripulante);

		List<Vuelo> list = new ArrayList<Vuelo>();
		list.add(a);
		when(iVueloRepository.GetAll()).thenReturn(list);

		GetAllVueloHandler handler = new GetAllVueloHandler(iVueloRepository);
		GetAllVueloQuery query = new GetAllVueloQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		verify(iVueloRepository).GetAll();
	}
}
