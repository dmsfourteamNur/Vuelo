package Dto;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AsientoDto_Test {

	@Test
	public void CheckPropertiesValid() {

		UUID keyAeronave = UUID.randomUUID();
		UUID key = UUID.randomUUID();
		int numero = 1;
		String clase = "comercial";
		Double precio = 20.20;
		int disponibilidad = 1;
		AsientoDto asientoDto = new AsientoDto();

		Assert.assertEquals(null, asientoDto.getKeyAeronave());
		Assert.assertEquals(null, asientoDto.getKey());
		Assert.assertEquals(0, asientoDto.getNumero());
		Assert.assertEquals(null, asientoDto.getClase());
		Assert.assertEquals(null, asientoDto.getPrecio());
		Assert.assertEquals(0, asientoDto.getDisponibilidad());
		asientoDto.key = key;
		asientoDto.setKeyAeronave(keyAeronave);
		asientoDto.setKey(key);
		asientoDto.setNumero(numero);
		asientoDto.setClase(clase);
		asientoDto.setPrecio(precio);
		asientoDto.setDisponibilidad(disponibilidad);
		Assert.assertEquals(keyAeronave, asientoDto.getKeyAeronave());
		Assert.assertEquals(numero, asientoDto.getNumero());
		Assert.assertEquals(clase, asientoDto.getClase());
		Assert.assertEquals(precio, asientoDto.getPrecio());
		Assert.assertEquals(disponibilidad, asientoDto.getDisponibilidad());

	}

	@Test
	public void CheckConstructor() {

		UUID keyAeronave = UUID.randomUUID();
		UUID key = UUID.randomUUID();
		int numero = 1;
		String clase = "comercial";
		Double precio = 20.20;
		int disponibilidad = 1;
		AsientoDto asientoDto = new AsientoDto(key, keyAeronave, numero, clase, precio);
		asientoDto.key = key;
		Assert.assertEquals(keyAeronave, asientoDto.getKeyAeronave());
		Assert.assertEquals(numero, asientoDto.getNumero());
		Assert.assertEquals(clase, asientoDto.getClase());
		Assert.assertEquals(precio, asientoDto.getPrecio());
	}

	@Test
	public void ConstructorVoid_accept() {
		Assert.assertNotNull(new AsientoDto());
	}

}
