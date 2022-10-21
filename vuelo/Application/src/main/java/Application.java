import Factories.AeronaveFactory;
import Factories.IAeronaveFactory;
import Factories.ITripulacionFactory;
import Factories.IVueloFactory;
import Factories.TripulacionFactory;
import Factories.VueloFactory;
import Fourteam.extensions.IServiceCollection;
import Fourteam.mediator.IMediator;
import UseCases.Command.Vuelos.Arribar.ArribarVueloHandler;
import UseCases.Command.Vuelos.Cancelar.CancelarVueloHandler;
import UseCases.Command.Vuelos.Crear.CrearVueloHandler;
import UseCases.Command.Vuelos.Editar.EditarVueloHandler;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloHandler;
import UseCases.DomainEventHandler.Vuelo.PublishIntegrationEventWhenVueloCreadoHandler;
import UseCases.Queries.Aeronave.GetAll.GetAllAeronaveHandler;
import UseCases.Queries.Tripulacion.GetAll.GetAllTripulacionHandler;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloHandler;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyHandler;

public class Application {

	public static void AddApplication() {
		// USE CASE: VUELO
		IMediator.registerHandler(GetAllVueloHandler.class);
		IMediator.registerHandler(GetVueloByKeyHandler.class);

		IMediator.registerHandler(CrearVueloHandler.class);
		IMediator.registerHandler(EditarVueloHandler.class);
		IMediator.registerHandler(EliminarVueloHandler.class);
		IMediator.registerHandler(CancelarVueloHandler.class);
		IMediator.registerHandler(ArribarVueloHandler.class);
		// IMediator.registerHandler(EliminarVueloHandler.class);

		// Aeronave - Tripulacion GETALL
		IMediator.registerHandler(GetAllAeronaveHandler.class);
		IMediator.registerHandler(GetAllTripulacionHandler.class);

		// publish
		IMediator.registerHandler(PublishIntegrationEventWhenVueloCreadoHandler.class);
		// Transient
		IServiceCollection.AddTransient(IVueloFactory.class, VueloFactory.class);
		IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
		IServiceCollection.AddTransient(ITripulacionFactory.class, TripulacionFactory.class);
		Domain.addDomain();
	}
}
