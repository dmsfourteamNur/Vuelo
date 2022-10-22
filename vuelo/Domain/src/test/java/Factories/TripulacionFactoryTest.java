package Factories;

import java.util.UUID;

import org.junit.Test;

import Model.Tripulacion.Tripulacion;

public class TripulacionFactoryTest {
	@Test
	public void dataValid() {
		TripulacionFactory tripulanteFactory = new TripulacionFactory();
		Tripulacion tripulacion = tripulanteFactory.Create(UUID.randomUUID(), "Grupo A", "1");
		System.out.println(tripulacion);
	}
}