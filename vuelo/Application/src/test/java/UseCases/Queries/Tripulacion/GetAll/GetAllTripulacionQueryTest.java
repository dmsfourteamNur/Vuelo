package UseCases.Queries.Tripulacion.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllTripulacionQueryTest {

	@Test
	public void dataValid() {
		GetAllTripulacionQuery command = new GetAllTripulacionQuery();
		Assert.assertNotNull(command);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(GetAllTripulacionQuery.class.getConstructors()[0].canAccess(null));
	}
}
