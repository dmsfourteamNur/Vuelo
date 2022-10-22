package UseCases.Queries.Aeronave.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllAeronaveQueryTest {
	@Test
	public void dataValid() {
		GetAllAeronaveQuery command = new GetAllAeronaveQuery();
		Assert.assertNotNull(command);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(GetAllAeronaveQuery.class.getConstructors()[0].canAccess(null));
	}
}
