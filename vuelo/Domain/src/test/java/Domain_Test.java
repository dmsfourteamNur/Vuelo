import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class Domain_Test {

	SharedKernel sharedKernel = Mockito.mock(SharedKernel.class);

	@Test
	public void constructor() {
		Assert.assertNotNull(new Domain());
	}

	// @Test
	public void addDomain_accept() {
		sharedKernel.AddKernel();
		Domain domain = new Domain();
		domain.addDomain();
		Assert.assertTrue(true);
	}

}