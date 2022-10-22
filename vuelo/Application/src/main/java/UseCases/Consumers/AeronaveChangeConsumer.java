package UseCases.Consumers;

import Factories.IAeronaveFactory;
import Fourteam.massTransit.IConsumer;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;

public class AeronaveChangeConsumer extends IConsumer<IntegrationEvents.AeronaveChange> {

	// private static String QueueName = "[Vuelo]-aeronave-change";
	private IAeronaveRepository iAeronaveRepository;
	private IAeronaveFactory iAeronaveFactory;
	private IUnitOfWork iUnitOfWork;

	public AeronaveChangeConsumer(IAeronaveRepository _iAeronaveRepository, IAeronaveFactory iAeronaveFactory,
			IUnitOfWork _iUnitOfWork) {
		this.iAeronaveRepository = _iAeronaveRepository;
		this.iAeronaveFactory = iAeronaveFactory;
		this.iUnitOfWork = _iUnitOfWork;
	}

	@Override
	public void Consume(IntegrationEvents.AeronaveChange object) {
		try {
			boolean isNuevo = false;
			Aeronave aeronave = iAeronaveRepository.FindByKey(object.Key);
			if (aeronave == null)
				isNuevo = true;
			aeronave = iAeronaveFactory.Create(object.Key, object.matricula, "1");

			for (var item : object.getAsientos()) {
				aeronave.agregarAsiento(item.key, item.keyAeronave, item.numero, item.clase, 200.00, 0);
			}
			if (isNuevo) {
				iAeronaveRepository.Create(aeronave);
			} else {
				iAeronaveRepository.Update(aeronave);
			}
			iUnitOfWork.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}