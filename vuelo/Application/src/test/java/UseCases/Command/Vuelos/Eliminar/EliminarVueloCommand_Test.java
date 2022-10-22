package UseCases.Command.Vuelos.Eliminar;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class EliminarVueloCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);
		EliminarVueloCommand command = new EliminarVueloCommand(vueloDto.key);
		Assert.assertEquals(key, command.vueloDto.getKey());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(EliminarVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
