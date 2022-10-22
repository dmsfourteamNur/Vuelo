package UseCases.Queries.Vuelos.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;

public class GetVueloByKeyHandlerTest {

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

		when(iVueloRepository.FindByKey(any())).thenReturn(a);
		GetVueloByKeyHandler handler = new GetVueloByKeyHandler(iVueloRepository);
		GetVueloByKeyQuery query = new GetVueloByKeyQuery(a.key);
		try {
			Assert.assertEquals(a.key, handler.handle(query).key);
		} catch (Exception e) {
			Assert.fail();
		}
		verify(iVueloRepository).FindByKey(a.key);
	}

	@Test
	public void HandleFail() throws Exception {

		Vuelo a = new Vuelo("1", UUID.randomUUID(), "sc", "cbba", new Date(), new Date(), UUID.randomUUID(),
				"en horario", "1", new ArrayList<>(), new ArrayList<>());

		when(iVueloRepository.FindByKey(any())).thenReturn(null);
		GetVueloByKeyHandler handler = new GetVueloByKeyHandler(iVueloRepository);
		GetVueloByKeyQuery query = new GetVueloByKeyQuery(a.key);

		Assert.assertThrows(HttpException.class, () -> {
			handler.handle(query);
		});
	}
}
