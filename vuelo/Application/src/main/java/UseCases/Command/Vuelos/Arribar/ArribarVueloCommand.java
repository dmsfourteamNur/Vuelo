package UseCases.Command.Vuelos.Arribar;

import java.util.UUID;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class ArribarVueloCommand implements Request<VueloDto> {

	public VueloDto vueloDto;

	public ArribarVueloCommand(UUID key) {
		this.vueloDto = new VueloDto();
		this.vueloDto.setKey(key);
	}
}