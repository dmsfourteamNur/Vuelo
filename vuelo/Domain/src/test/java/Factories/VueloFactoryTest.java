package Factories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;

public class VueloFactoryTest {
	@Test
	public void dataValid() {

		final List<Asiento> asientos = new ArrayList<>();
		final List<Tripulante> tripulantes = new ArrayList<>();
		VueloFactory vueloFactory = new VueloFactory();
		vueloFactory.Create("134", UUID.randomUUID(), "SCR-VIruViru", "CBBA", new Date(), new Date(), UUID.randomUUID(),
				"cerrado", "1", asientos, tripulantes);

	}
}
