package Controllers;

import java.util.List;

import Dto.VueloDto;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.DeleteMapping;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.PostMapping;
import Fourteam.http.annotation.PutMapping;
import Fourteam.http.annotation.RequestBody;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Vuelos.Vuelo;
import UseCases.Command.Vuelos.Arribar.ArribarVueloCommand;
import UseCases.Command.Vuelos.Cancelar.CancelarVueloCommand;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

	private Mediator _mediator;

	public VueloController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<VueloDto> getAll() throws HttpException {
		try {
			Response<List<VueloDto>> lista = _mediator.send(new GetAllVueloQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(HttpStatus.BAD_REQUEST, "Error " + e.getMessage());
		}
	}

	@PostMapping("/registro")
	public Vuelo register(@RequestBody CrearVueloCommand vuelo)
			throws Exception {
		return (Vuelo) _mediator.send(vuelo).data;
	}

	@GetMapping("/{key}")
	public Response<VueloDto> getByKey(@PathVariable GetVueloByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/{key}")
	public VueloDto edit(
			@RequestBody Vuelo vuelo,
			@PathVariable EditarVueloCommand request) throws HttpException {
		request.vueloDto.setNroVuelo(vuelo.getNroVuelo());
		request.vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
		request.vueloDto.setOrigen(vuelo.getOrigen());
		request.vueloDto.setDestino(vuelo.getDestino());
		request.vueloDto.setFechaSalida(vuelo.getFechaSalida());
		request.vueloDto.setFechaArribe(vuelo.getFechaArribe());
		request.vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());
		request.vueloDto.setObservacion(vuelo.getObservacion());
		request.vueloDto.setEstado(vuelo.getEstado());
		try {
			return (VueloDto) _mediator.send(request).data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}

	@PutMapping("/cancel/{key}")
	public Response<VueloDto> cancel(@PathVariable CancelarVueloCommand request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping("/arrive/{key}")
	public Response<VueloDto> arrive(@PathVariable ArribarVueloCommand request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/{key}")
	public Response<VueloDto> delete(@PathVariable EliminarVueloCommand request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}