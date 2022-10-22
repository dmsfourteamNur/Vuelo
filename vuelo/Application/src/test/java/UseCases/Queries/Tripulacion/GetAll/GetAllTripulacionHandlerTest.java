package UseCases.Queries.Tripulacion.GetAll;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
import Repositories.ITripulacionRepository;

public class GetAllTripulacionHandlerTest {
	ITripulacionRepository iTripulacionRepository = Mockito.mock(ITripulacionRepository.class);

	@Test
	public void HandleCorrectly() throws Exception {

		Tripulante tripulante = new Tripulante(UUID.randomUUID(), UUID.randomUUID(), "carlos", "marcos", "piloto", "1");

		List<Tripulante> listTripulante = new ArrayList<Tripulante>();
		listTripulante.add(tripulante);

		Tripulacion a = new Tripulacion(UUID.randomUUID(), "grupo a", "1");
		a.setTripulantes(listTripulante);

		List<Tripulacion> list = new ArrayList<Tripulacion>();
		list.add(a);
		when(iTripulacionRepository.GetAll()).thenReturn(list);

		GetAllTripulacionHandler handler = new GetAllTripulacionHandler(iTripulacionRepository);
		GetAllTripulacionQuery query = new GetAllTripulacionQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		verify(iTripulacionRepository).GetAll();
	}
}
