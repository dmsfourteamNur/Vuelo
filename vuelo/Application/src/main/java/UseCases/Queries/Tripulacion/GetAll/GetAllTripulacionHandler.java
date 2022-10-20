package UseCases.Queries.Tripulacion.GetAll;

import java.util.ArrayList;
import java.util.List;

import Dto.TripulacionDto;
import Dto.TripulanteDto;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
import Repositories.ITripulacionRepository;

public class GetAllTripulacionHandler implements RequestHandler<GetAllTripulacionQuery, List<TripulacionDto>> {

	private ITripulacionRepository iTripulanteRepository;

	public GetAllTripulacionHandler(ITripulacionRepository iTripulanteRepository) {
		this.iTripulanteRepository = iTripulanteRepository;
	}

	@Override
	public List<TripulacionDto> handle(GetAllTripulacionQuery request) throws Exception {

		List<Tripulacion> lista = iTripulanteRepository.GetAll();
		List<TripulacionDto> resp = new ArrayList<>();
		for (Tripulacion tripulacion : lista) {
			TripulacionDto tripulacionDto = new TripulacionDto();
			tripulacionDto.setKeyTripulacion(tripulacion.getKey());
			tripulacionDto.setDescripcion(tripulacion.getDescripcion());
			tripulacionDto.setEstado(tripulacion.getEstado());

			resp.add(tripulacionDto);
			List<TripulanteDto> tripulanteDtos = new ArrayList<>();

			for (Tripulante tripulante : tripulacion.tripulantes) {
				tripulanteDtos.add(new TripulanteDto(tripulante.keyTripulacion, tripulante.key, tripulante.nombre,
						tripulante.apellido, tripulante.cargo, tripulante.estado));
			}
			tripulacionDto.setTripulantes(tripulanteDtos);
		}
		return resp;
	}
}