package UseCases.Queries.Vuelos.GetByKey;

import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;

public class GetVueloByKeyHandler implements RequestHandler<GetVueloByKeyQuery, Vuelo> {

	private IVueloRepository iVueloRepository;

	public GetVueloByKeyHandler(IVueloRepository iVueloRepository) {
		this.iVueloRepository = iVueloRepository;
	}

	@Override
	public Vuelo handle(GetVueloByKeyQuery request) throws Exception {

		Vuelo vuelo = iVueloRepository.FindByKey(request.Key);
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "vuelo no encontrada");
		}

		return vuelo;
		// VueloDto vueloDto = new VueloDto(vuelo);
		// return vueloDto;

	}
}