package UseCases.Command.Vuelos.Eliminar;

import java.util.UUID;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class EliminarVueloCommand implements Request<VueloDto> {

	public VueloDto vueloDto;

	public EliminarVueloCommand(UUID key) {
		this.vueloDto = new VueloDto();
		this.vueloDto.setKey(key);
	}
}
