package Controllers;

import java.util.List;

import Dto.TripulacionDto;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import UseCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

	private Mediator _mediator;

	public TripulacionController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<TripulacionDto> getAll() throws HttpException {
		try {
			Response<List<TripulacionDto>> lista = _mediator.send(new GetAllTripulacionQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(HttpStatus.BAD_REQUEST, "Error " + e.getMessage());
		}
	}
}