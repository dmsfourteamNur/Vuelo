package Factories;

import java.util.UUID;

import org.junit.Test;

import Model.Aeronaves.Aeronave;

public class AeronaveFactoryTest {
	@Test
	public void dataValid() {
		AeronaveFactory aeronaveFactory = new AeronaveFactory();
		Aeronave aeronave = aeronaveFactory.Create(UUID.randomUUID(), "Hercules 1993", "0");
		System.out.println(aeronave);
	}
}
