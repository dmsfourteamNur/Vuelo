package UseCases.Command.Vuelos.Crear;

import Dto.VueloDto;
import Fourteam.mediator.Request;

public class CrearVueloCommand implements Request<VueloDto> {

	public VueloDto data;

	public CrearVueloCommand(VueloDto vueloDto) {
		this.data = vueloDto;
	}
}
