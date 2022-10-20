package UseCases.Consumers;

import Factories.ITripulacionFactory;
import Fourteam.massTransit.IConsumer;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;

public class TripulacionChangeConsumer extends IConsumer<IntegrationEvents.TripulacionChange> {

	// private static String QueueName = "[Vuelo]-tripulacion-change";
	private ITripulacionRepository iTripulacionRepository;
	private ITripulacionFactory iTripulacionFactory;
	private IUnitOfWork iUnitOfWork;

	public TripulacionChangeConsumer(ITripulacionRepository _iTripulacionRepository,
			ITripulacionFactory _iTripulacionFactory, IUnitOfWork _iUnitOfWork) {
		this.iTripulacionRepository = _iTripulacionRepository;
		this.iTripulacionFactory = _iTripulacionFactory;
		this.iUnitOfWork = _iUnitOfWork;
	}

	@Override
	public void Consume(IntegrationEvents.TripulacionChange object) {
		try {
			boolean isNuevo = false;

			Tripulacion tripulacion = iTripulacionRepository.FindByKey(object.keyTripulacion);
			if (tripulacion == null)
				isNuevo = true;
			tripulacion = iTripulacionFactory.Create(object.keyTripulacion, object.descripcion, object.estado);

			for (var item : object.getTripulantes()) {
				tripulacion.agregarTripulante(item.key, item.keyTripulacion, item.nombre, item.apellido, item.cargo,
						item.estado);
			}
			if (isNuevo) {
				iTripulacionRepository.Create(tripulacion);
			} else {
				iTripulacionRepository.Update(tripulacion);
			}
			iUnitOfWork.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}