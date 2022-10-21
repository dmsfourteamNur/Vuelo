
import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;
import Repository.AeronaveRepository;
import Repository.TripulacionRepository;
import Repository.VueloRepository;
import UseCases.Consumers.AeronaveChangeConsumer;
import UseCases.Consumers.TripulacionChangeConsumer;

public class Infraestructure {

	public static void AddInfraestructure() {
		IServiceCollection.AddMediator();
		IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
		IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
		IServiceCollection.AddScoped(IVueloRepository.class, VueloRepository.class);
		IServiceCollection.AddScoped(ITripulacionRepository.class, TripulacionRepository.class);
		IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);

		Application.AddApplication();
		AddRabbitMq();
	}

	private static void AddRabbitMq() {
		IServiceCollection.AddMassTransit(config -> {
			config.AddConsumer(AeronaveChangeConsumer.class);
			config.AddConsumer(TripulacionChangeConsumer.class);
			config.UsingRabbitMq((context, cfg) -> {
				cfg.Host = Config.getProperty("rabit.host");
				cfg.User = Config.getProperty("rabit.user");
				cfg.Password = Config.getProperty("rabit.pass");
			});
		});
	}

}
