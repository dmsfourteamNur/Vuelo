package UseCases.Queries.Vuelos.GetAll;

import java.util.ArrayList;
import java.util.List;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;

public class GetAllVueloHandler implements RequestHandler<GetAllVueloQuery, List<VueloDto>> {

	private IVueloRepository iVueloRepository;

	public GetAllVueloHandler(IVueloRepository iVueloRepository) {
		this.iVueloRepository = iVueloRepository;
	}

	// todo cancelar vuelo, venta y ticke tienen que tener estado. porsi se cambio
	@Override
	public List<VueloDto> handle(GetAllVueloQuery request) throws Exception {

		List<Vuelo> lista = iVueloRepository.GetAll();
		List<VueloDto> resp = new ArrayList<>();

		for (Vuelo vuelo : lista) {
			VueloDto vueloDto = new VueloDto();
			vueloDto.setKey(vuelo.getKey());
			vueloDto.setNroVuelo(vuelo.getNroVuelo());
			vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
			vueloDto.setOrigen(vuelo.getOrigen());
			vueloDto.setDestino(vuelo.getDestino());
			vueloDto.setFechaSalida(vuelo.getFechaSalida());
			vueloDto.setFechaArribe(vuelo.getFechaArribe());
			vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());
			vueloDto.setObservacion(vuelo.getObservacion());
			vueloDto.setEstado(vuelo.getEstado());

			resp.add(vueloDto);

			List<AsientoDto> asientosDtos = new ArrayList<>();
			for (Asiento asiento : vuelo.getAsientos()) {
				asientosDtos
						.add(new AsientoDto(asiento.key, asiento.keyAeronave, asiento.numero, asiento.clase, asiento.precio));
			}
			vueloDto.setAsientos(asientosDtos);

			List<TripulanteDto> tripulanteDtos = new ArrayList<>();
			for (Tripulante tripulante : vuelo.getTripulantes()) {
				tripulanteDtos.add(new TripulanteDto(tripulante.keyTripulacion, tripulante.key, tripulante.nombre,
						tripulante.apellido, tripulante.cargo, tripulante.estado));
			}
			vueloDto.setTripulantes(tripulanteDtos);
		}

		return resp;
	}
}