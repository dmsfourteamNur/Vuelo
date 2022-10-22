package UseCases.Command.Vuelos.Editar;

import java.util.ArrayList;
import java.util.List;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class EditarVueloHandler
		implements RequestHandler<EditarVueloCommand, VueloDto> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IUnitOfWork unitOfWor;
	private IAeronaveRepository iAeronaveRepository;
	private ITripulacionRepository iTripulacionRepository;

	public EditarVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IAeronaveRepository iAeronaveRepository,
			ITripulacionRepository iTripulacionRepository,
			IUnitOfWork unitOfWor) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.iAeronaveRepository = iAeronaveRepository;
		this.iTripulacionRepository = iTripulacionRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public VueloDto handle(EditarVueloCommand request) throws Exception {

		// ✅ verifico aeronave
		Aeronave aeronave = iAeronaveRepository.FindByKey(request.vueloDto.keyAeronave);
		if (aeronave == null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "no existe la aeronave");

		// ✅ verifico tripulacion
		Tripulacion tripulacion = iTripulacionRepository.FindByKey(request.vueloDto.keyTripulacion);
		if (tripulacion == null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "no existe la tripulacion");

		// ✅ verifico vuelo
		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.key);
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrado");
		}

		vuelo.setNroVuelo(request.vueloDto.getNroVuelo());
		vuelo.setKeyAeronave(request.vueloDto.getKeyAeronave());
		vuelo.setOrigen(request.vueloDto.getOrigen());
		vuelo.setDestino(request.vueloDto.getDestino());
		vuelo.setFechaSalida(request.vueloDto.getFechaSalida());
		vuelo.setFechaArribe(request.vueloDto.getFechaArribe());
		vuelo.setKeyTripulacion(request.vueloDto.getKeyTripulacion());
		vuelo.setObservacion(request.vueloDto.getObservacion());
		vuelo.setEstado(request.vueloDto.getEstado());
		List<Asiento> listaAsientos = new ArrayList<>();
		for (Asiento asiento : aeronave.asientos) {
			listaAsientos.add(new Asiento(asiento.key, asiento.keyAeronave, asiento.numero, asiento.clase, asiento.precio,
					asiento.disponibilidad));
		}
		vuelo.setAsientos(listaAsientos);
		List<Tripulante> listaTripulantes = new ArrayList<>();
		for (Tripulante tripulante : tripulacion.tripulantes) {
			listaTripulantes.add(
					new Tripulante(tripulante.key, tripulante.keyTripulacion, tripulante.nombre, tripulante.apellido,
							tripulante.cargo, tripulante.estado));
		}
		vuelo.setTripulantes(listaTripulantes);

		iVueloRepository.Update(vuelo);

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
		return vueloDto;
	}
}