package UseCases.DomainEventHandler.Vuelo;

import java.util.ArrayList;
import java.util.List;

import Event.VueloCreado;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.NotificationHandler;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import core.ConfirmedDomainEvent;

public class PublishIntegrationEventWhenVueloCreadoHandler
		implements NotificationHandler<ConfirmedDomainEvent<VueloCreado>> {

	private IPublishEndpoint publishEndpoint;
	private IAeronaveRepository iAeronaveRepository;

	public PublishIntegrationEventWhenVueloCreadoHandler(IPublishEndpoint publishEndpoint,
			IAeronaveRepository iAeronaveRepository) {
		this.publishEndpoint = publishEndpoint;
		this.iAeronaveRepository = iAeronaveRepository;
	}

	@Override
	public void handle(ConfirmedDomainEvent<VueloCreado> event) {

		VueloCreado vuelo = (VueloCreado) event.DomainEvent;

		try {
			Aeronave aeronave = iAeronaveRepository.FindByKey(vuelo.keyAeronave);
			IntegrationEvents.VueloCreado evento = new IntegrationEvents.VueloCreado();

			evento.setKey(vuelo.getKey());
			evento.setNroVuelo(vuelo.getNroVuelo());
			evento.setFechaSalida(vuelo.getFechaSalida());
			evento.setFechaArribe(vuelo.getFechaArribe());
			evento.setKeyAeronave(vuelo.getKeyAeronave());
			evento.setOrigen(vuelo.getOrigen());
			evento.setDestino(vuelo.getDestino());
			evento.setKeyTripulacion(vuelo.getKeyTripulacion());
			evento.setObservacion(vuelo.getObservacion());
			evento.setEstado(vuelo.getEstado());

			List<IntegrationEvents.dto.AsientoDto> arr = new ArrayList<>();
			aeronave.asientos.iterator().forEachRemaining(asiento -> {
				IntegrationEvents.dto.AsientoDto asientoDto = new IntegrationEvents.dto.AsientoDto();
				asientoDto.key = asiento.key;
				asientoDto.keyAeronave = asiento.keyAeronave;
				asientoDto.numero = asiento.numero;
				asientoDto.clase = asiento.clase;
				asientoDto.precio = asiento.precio;
				asientoDto.disponibilidad = asiento.disponibilidad;
				arr.add(asientoDto);
			});

			evento.setListaAsientos(arr);

			this.publishEndpoint.Publish(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}