package Model.Aeronaves;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import core.Entity;

public class AsientoTest extends Entity<UUID> {
	@Test
	public void CheckConstructor() {
		UUID keyAeronave = UUID.randomUUID();
		int numero = 1;
		String clase = "comercial";
		Double precio = 20.20;
		int disponibilidad = 1;

		Asiento asiento = new Asiento(keyAeronave, keyAeronave, numero, clase, precio, disponibilidad);

		Assert.assertEquals(keyAeronave, asiento.getKeyAeronave());
		Assert.assertEquals(numero, asiento.getNumero());
		Assert.assertEquals(clase, asiento.getClase());
		Assert.assertEquals(precio, asiento.getPrecio());
		Assert.assertEquals(disponibilidad, asiento.getDisponibilidad());

		asiento.setKeyAeronave(keyAeronave);
		asiento.setNumero(numero);
		asiento.setClase(clase);
		asiento.setPrecio(precio);
		asiento.setDisponibilidad(disponibilidad);

		Assert.assertEquals(keyAeronave, asiento.getKeyAeronave());
		Assert.assertEquals(numero, asiento.getNumero());
		Assert.assertEquals(clase, asiento.getClase());
		Assert.assertEquals(precio, asiento.getPrecio());
		Assert.assertEquals(disponibilidad, asiento.getDisponibilidad());
	}
}
