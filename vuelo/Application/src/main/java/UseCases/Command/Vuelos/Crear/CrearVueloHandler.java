package UseCases.Command.Vuelos.Crear;

import java.util.ArrayList;
import java.util.List;

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

public class CrearVueloHandler
		implements RequestHandler<CrearVueloCommand, Vuelo> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IAeronaveRepository iAeronaveRepository;
	private ITripulacionRepository iTripulacionRepository;
	private IUnitOfWork unitOfWor;

	public CrearVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IAeronaveRepository iAeronaveRepository,
			ITripulacionRepository iTripulacionRepository,
			IUnitOfWork unitOfWork) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.iAeronaveRepository = iAeronaveRepository;
		this.iTripulacionRepository = iTripulacionRepository;
		this.unitOfWor = unitOfWork;
	}

	@Override
	public Vuelo handle(CrearVueloCommand request) throws Exception {

		// ✅ verifico nro aeronave si existe en la BD
		Vuelo nroVuelo = iVueloRepository.findNroVuelo(request.data.nroVuelo);
		if (nroVuelo != null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "el numero de vuelo existe,otro ingresar");

		// ✅ verifico aeronave
		Aeronave aeronave = iAeronaveRepository.FindByKey(request.data.keyAeronave);
		if (aeronave == null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "no existe la aeronave");
		// ⚠️ verifico si la tripulacion, ya esta en vuelo
		if (aeronave.estado.equals("2"))
			throw new HttpException(HttpStatus.BAD_REQUEST, "aeronave esta en vuelo, usar otra");

		// ✅ verifico aeropuerto el origen y destino
		if (request.data.origen.equals(request.data.destino))
			if (request.data.origen == request.data.destino)
				throw new HttpException(HttpStatus.BAD_REQUEST, "son iguales origen y destino, ingresar otro ");

		// ✅ verifico la fecha de salida del aeronave si existe en la BD
		Vuelo fechaSalida = iVueloRepository.findFechaSalida(request.data.fechaSalida);
		if (fechaSalida != null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "la fecha de salida del vuelo ya existe.");
		// ✅ validar la fecha distinto
		if (request.data.fechaArribe.before(request.data.fechaSalida))
			throw new HttpException(HttpStatus.BAD_REQUEST, "debe ingresar otra hora");

		// ✅ verifico tripulacion si existe en la BD
		Tripulacion tripulacion = iTripulacionRepository.FindByKey(request.data.keyTripulacion);
		if (tripulacion == null)
			throw new HttpException(HttpStatus.BAD_REQUEST, "no existe la tripulacion");
		// ⚠️ verifico si la tripulacion, ya esta en vuelo
		if (tripulacion.estado.equals("2"))
			throw new HttpException(HttpStatus.BAD_REQUEST, "la tripulacion esta en vuelo, usar otra");

		List<Asiento> asientos = new ArrayList<>();
		for (Asiento asientoDto : aeronave.asientos) {
			asientos.add(new Asiento(asientoDto.key, asientoDto.keyAeronave, asientoDto.numero, asientoDto.clase,
					200.00, 0));
		}

		List<Tripulante> tripulantes = new ArrayList<>();
		for (Tripulante tripulante : tripulacion.tripulantes) {
			tripulantes.add(
					new Tripulante(tripulante.key, tripulante.keyTripulacion, tripulante.nombre, tripulante.apellido,
							tripulante.cargo, tripulante.estado));
		}

		Vuelo vuelo = iVueloFactory.Create(request.data.nroVuelo, request.data.keyAeronave, request.data.origen,
				request.data.destino, request.data.fechaSalida, request.data.fechaArribe, request.data.keyTripulacion,
				"en horario", "1", asientos,
				tripulantes);

		tripulacion.setEstado("2");
		iTripulacionRepository.Update(tripulacion);
		aeronave.setEstado("2");
		iAeronaveRepository.Update(aeronave);

		vuelo.eventCreado();
		iVueloRepository.Create(vuelo);
		unitOfWor.commit();
		return vuelo;
	}
}