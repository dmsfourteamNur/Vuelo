package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AeronaveDto_Test {

	@Test
	public void CheckPropertiesValid() {

		UUID keyAeronave = UUID.randomUUID();
		String matricula = "xyz-1990";
		List<AsientoDto> listdaAsientos = getListdaAsientos();
		String estado = "0";
		AeronaveDto aeronaveDto = new AeronaveDto();
		Assert.assertEquals(null, aeronaveDto.getKeyAeronave());
		Assert.assertNull(aeronaveDto.getMatricula());
		Assert.assertEquals(0, listdaAsientos.size());
		Assert.assertNull(null, aeronaveDto.getEstado());
		aeronaveDto.setKeyAeronave(keyAeronave);
		aeronaveDto.setMatricula(matricula);
		aeronaveDto.setListaAsientos(listdaAsientos);
		aeronaveDto.setEstado(estado);
		Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
		Assert.assertEquals(matricula, aeronaveDto.getMatricula());
		Assert.assertEquals(listdaAsientos, aeronaveDto.getListaAsientos());
		Assert.assertEquals(estado, aeronaveDto.getEstado());
	}

	private List<AsientoDto> getListdaAsientos() {
		return new ArrayList<>();
	}
}