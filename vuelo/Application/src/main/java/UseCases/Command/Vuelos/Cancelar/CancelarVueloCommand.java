package UseCases.Command.Vuelos.Cancelar;

import java.util.UUID;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class CancelarVueloCommand implements Request<VueloDto> {

	public VueloDto vueloDto;

	public CancelarVueloCommand(UUID key) {
		this.vueloDto = new VueloDto();
		this.vueloDto.setKey(key);
	}
}