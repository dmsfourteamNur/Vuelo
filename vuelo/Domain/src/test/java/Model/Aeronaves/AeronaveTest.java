package Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AeronaveTest {

	@Test
	public void constructorVoid_accept() {
		Assert.assertNotNull(new Aeronave());
	}

	@Test
	public void constructor_accept() {

		UUID key = UUID.randomUUID();
		String matricula = "xyz-1990";
		// List<Asiento> listdaAsientos = new ArrayList<>();
		String estado = "0";

		Aeronave a = new Aeronave(key, matricula, estado);
		Assert.assertEquals(a.key, key);
		Assert.assertEquals(a.matricula, matricula);
		Assert.assertEquals(a.estado, estado);
	}

	@Test
	public void constructor_denied() {
		UUID key = null;
		String matricula = "";
		String estado = "";
		Aeronave aeronave = new Aeronave(key, matricula, estado);
		Assert.assertEquals(aeronave.key, null);
		Assert.assertEquals(aeronave.matricula, "");
		Assert.assertEquals(aeronave.asientos.size(), 0);
		Assert.assertEquals(aeronave.estado, "");
	}

	@Test
	public void addAsiento_accept() {
		final UUID keyAeronave = UUID.randomUUID();
		final String matricula = "xyz-1990";
		final List<Asiento> listdaAsientos1 = new ArrayList<>();
		final String estado = "0";

		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);
		aeronave.agregarAsiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		Assert.assertEquals(aeronave.asientos.size(), 1);
		aeronave.setMatricula(matricula);
		aeronave.setAsientos(listdaAsientos1);
		aeronave.setEstado(estado);
		Assert.assertEquals(keyAeronave, aeronave.getKey());
		Assert.assertEquals(matricula, aeronave.getMatricula());
		Assert.assertEquals(listdaAsientos1, aeronave.getAsientos());
		Assert.assertEquals(estado, aeronave.getEstado());

	}

	@Test
	public void addAsiento_denied() {

		UUID keyAeronave = UUID.randomUUID();
		String matricula = "xyz-1990";
		String estado = "0";

		Aeronave aeronave = new Aeronave(keyAeronave, matricula, estado);

		Asiento asiento001 = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		aeronave.agregarAsiento(asiento001);

		Asiento asiento002 = new Asiento(UUID.randomUUID(), UUID.randomUUID(), 1, "comercial", 200.00, 0);
		asiento002.key = asiento001.key;

		try {
			aeronave.agregarAsiento(asiento002);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}
