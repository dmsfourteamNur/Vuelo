package UseCases.Queries.Aeronave.GetAll;

import java.util.ArrayList;
import java.util.List;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Repositories.IAeronaveRepository;

public class GetAllAeronaveHandler implements RequestHandler<GetAllAeronaveQuery, List<AeronaveDto>> {

	private IAeronaveRepository iAeronaveRepository;

	public GetAllAeronaveHandler(IAeronaveRepository iAeronaveRepository) {
		this.iAeronaveRepository = iAeronaveRepository;
	}

	// todo a ricky que cuando getbykey aeroanve, vuelo, etc quitar el staatus
	@Override
	public List<AeronaveDto> handle(GetAllAeronaveQuery request) throws Exception {

		List<Aeronave> lista = iAeronaveRepository.GetAll();
		List<AeronaveDto> resp = new ArrayList<>();
		for (Aeronave aeronave : lista) {
			AeronaveDto aeronave_dto = new AeronaveDto();
			aeronave_dto.setKeyAeronave(aeronave.getKey());
			aeronave_dto.setMatricula(aeronave.matricula);
			aeronave_dto.setEstado(aeronave.estado);

			resp.add(aeronave_dto);
			List<AsientoDto> asientosDtos = new ArrayList<>();

			for (Asiento asiento : aeronave.asientos) {
				asientosDtos
						.add(new AsientoDto(asiento.key, asiento.keyAeronave, asiento.numero, asiento.clase, asiento.precio));
			}
			aeronave_dto.setListaAsientos(asientosDtos);
		}
		return resp;
	}
}
