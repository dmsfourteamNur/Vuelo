package UseCases.Queries.Aeronave.GetAll;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;

public class GetAllAeronaveHandlerTest {

	IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);

	@Test
	public void HandleCorrectly() throws Exception {

		Asiento asiento = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 0, "comercial", 20.00, 1);
		List<Asiento> listAsiento = new ArrayList<Asiento>();
		listAsiento.add(asiento);

		Aeronave a = new Aeronave(UUID.randomUUID(), "hercules", "1");
		a.setAsientos(listAsiento);

		List<Aeronave> list = new ArrayList<Aeronave>();
		list.add(a);
		when(aeronaveRepository.GetAll()).thenReturn(list);

		GetAllAeronaveHandler handler = new GetAllAeronaveHandler(aeronaveRepository);
		GetAllAeronaveQuery query = new GetAllAeronaveQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		// Assert.assertEquals(listAsiento.size(), handler.handle(query).size());
		verify(aeronaveRepository).GetAll();
	}
}
