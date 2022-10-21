package UseCases.Command.Vuelos.Editar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;

public class EditarVueloCommand_Test {
	@Test
	public void dataValid() {

		UUID key = UUID.randomUUID();
		VueloDto vueloDto = new VueloDto();
		vueloDto.setKey(key);
		EditarVueloCommand command = new EditarVueloCommand(vueloDto.key);
		Assert.assertEquals(key, command.vueloDto.getKey());

	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(EditarVueloCommand.class.getConstructors()[0].canAccess(null));
	}

	public List<AsientoDto> getListAsiento() {
		return new ArrayList<>();
	}

	public List<TripulanteDto> getListdaTripulantes() {
		return new ArrayList<>();
	}
}
