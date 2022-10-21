package UseCases.Queries.Vuelos.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllVueloQueryTest {

	@Test
	public void dataValid() {
		GetAllVueloQuery command = new GetAllVueloQuery();
		Assert.assertNotNull(command);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(GetAllVueloQuery.class.getConstructors()[0].canAccess(null));
	}
}
