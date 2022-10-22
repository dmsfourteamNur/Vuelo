import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class WebApiTest {

	SharedKernel sharedKernel = Mockito.mock(SharedKernel.class);

	@Test
	public void constructor() {
		Assert.assertNotNull(new Application());
	}

	// @Test
	public void webTest() {
		new WebApi();
		WebApi.AddControllers();
		// WebApi.openApi();
	}
}
