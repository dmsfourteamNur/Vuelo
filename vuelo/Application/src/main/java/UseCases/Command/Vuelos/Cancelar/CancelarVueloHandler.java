package UseCases.Command.Vuelos.Cancelar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

public class CancelarVueloHandler
		implements RequestHandler<CancelarVueloCommand, UUID> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IUnitOfWork unitOfWor;
	private IAeronaveRepository iAeronaveRepository;
	private ITripulacionRepository iTripulacionRepository;

	public CancelarVueloHandler(
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
	public UUID handle(CancelarVueloCommand request) throws Exception {

		// ✅ verifico vuelo
		Vuelo vuelo = iVueloRepository.FindByKey(request.vueloDto.getKey());
		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "Vuelo no encontrado");
		}

		Vuelo vueloAux = iVueloRepository.FindByKey(request.vueloDto.getKey());
		vueloAux.setNroVuelo(vuelo.getNroVuelo());
		vueloAux.setKeyAeronave(vuelo.getKeyAeronave());
		vueloAux.setOrigen(vuelo.getOrigen());
		vueloAux.setDestino(vuelo.getDestino());
		vueloAux.setFechaSalida(vuelo.getFechaSalida());
		vueloAux.setFechaArribe(vuelo.getFechaArribe());
		vueloAux.setKeyTripulacion(vuelo.getKeyTripulacion());
		vueloAux.setObservacion(vuelo.getObservacion());
		vueloAux.setEstado("0");

		Tripulacion tripulacion = iTripulacionRepository.FindByKey(vuelo.getKeyTripulacion());
		Aeronave aeronave = iAeronaveRepository.FindByKey(vuelo.getKeyAeronave());

		List<Asiento> listaAsientos = new ArrayList<>();
		for (Asiento asiento : aeronave.asientos) {
			listaAsientos.add(new Asiento(asiento.key, asiento.keyAeronave, asiento.numero, asiento.clase, asiento.precio,
					asiento.disponibilidad));
		}
		vueloAux.setAsientos(listaAsientos);

		List<Tripulante> listaTripulantes = new ArrayList<>();
		for (Tripulante tripulante : tripulacion.tripulantes) {
			listaTripulantes.add(
					new Tripulante(tripulante.key, tripulante.keyTripulacion, tripulante.nombre, tripulante.apellido,
							tripulante.cargo, tripulante.estado));
		}
		vueloAux.setTripulantes(listaTripulantes);

		tripulacion.setEstado("1");
		iTripulacionRepository.Update(tripulacion);
		aeronave.setEstado("1");
		iAeronaveRepository.Update(aeronave);

		iVueloRepository.Update(vueloAux);
		return vueloAux.getKey();
	}
}