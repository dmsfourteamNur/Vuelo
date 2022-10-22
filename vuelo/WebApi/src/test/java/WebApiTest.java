import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Test;

import Fourteam.http.Rest;

public class WebApiTest {

	@Test
	public void constructor() {
		Assert.assertNotNull(new WebApi());
		Rest.addController(any());
		Rest.start();
		Rest.createSwagger();
	}

}
