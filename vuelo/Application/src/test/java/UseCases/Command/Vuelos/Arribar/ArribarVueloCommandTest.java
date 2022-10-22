package UseCases.Command.Vuelos.Arribar;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.VueloDto;

public class ArribarVueloCommandTest {
	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);
		ArribarVueloCommand command = new ArribarVueloCommand(vueloDto.key);
		Assert.assertEquals(key, command.vueloDto.getKey());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(ArribarVueloCommand.class.getConstructors()[0].canAccess(null));
	}
}
