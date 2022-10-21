package Controllers;

import java.util.List;

import Dto.AeronaveDto;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import UseCases.Queries.Aeronave.GetAll.GetAllAeronaveQuery;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

	private Mediator _mediator;

	public AeronaveController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<AeronaveDto> getAll() throws HttpException {
		try {
			Response<List<AeronaveDto>> lista = _mediator.send(new GetAllAeronaveQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(HttpStatus.BAD_REQUEST, "Error " + e.getMessage());
		}
	}
}