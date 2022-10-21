package UseCases.Queries.Vuelos.GetByKey;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class GetVueloByKeyQueryTest {
	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		GetVueloByKeyQuery command = new GetVueloByKeyQuery(key);
		Assert.assertNotNull(command);
	}
}
