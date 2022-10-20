package UseCases.Command.Vuelos.Editar;

import java.util.UUID;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class EditarVueloCommand implements Request<VueloDto> {

	public VueloDto vueloDto;

	public EditarVueloCommand(UUID key) {
		this.vueloDto = new VueloDto();
		this.vueloDto.setKey(key);
	}
}