package Context.MongoDB;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import Fourteam.config.Config;
import Model.Aeronaves.Aeronave;
import Model.Tripulacion.Tripulacion;
import Model.Vuelos.Vuelo;

public class WriteDbContextTest {

	@Before
	public void setUp() {
		Config.load(getClass().getClassLoader().getResource("config.properties").getFile());
	}

	@Test
	public void constructor_accept() throws Exception {
		WriteDbContext context = new WriteDbContext();
		Assert.assertNotNull(context);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
		// Aeronave a = new Aeronave();
		// when(_aeronaves.Single(any())).thenReturn(a);
		WriteDbContext context = new WriteDbContext();
		ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
		ArgumentCaptor<Tripulacion> captor2 = ArgumentCaptor.forClass(Tripulacion.class);
		ArgumentCaptor<Vuelo> captor3 = ArgumentCaptor.forClass(Vuelo.class);
		Assert.assertNotNull(context);
	}

}
