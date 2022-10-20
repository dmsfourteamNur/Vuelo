package Model.Vuelos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Event.VueloCreado;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import core.AggregateRoot;

public class Vuelo extends AggregateRoot<UUID> {

	String nroVuelo;
	UUID keyAeronave;
	String origen;
	String destino;
	Date fechaSalida;
	Date fechaArribe;
	UUID keyTripulacion;
	String observacion;
	String estado;
	List<Asiento> asientos;
	List<Tripulante> tripulantes;

	public Vuelo() {
	}

	public Vuelo(String nroVuelo, UUID keyAeronave, String origen, String destino, Date fechaSalida, Date fechaArribe,
			UUID keyTripulacion, String observacion, String estado, List<Asiento> asientos,
			List<Tripulante> tripulantes) {
		// try {
		// this.nroVuelo = new NumeroVuelo(nroVuelo).toString();
		// } catch (BussinessRuleValidateExeption e) {
		// System.out.println("Error en el NumeroVuelo Vuelo");
		// return;
		// }
		this.key = UUID.randomUUID();
		this.nroVuelo = nroVuelo;
		this.keyAeronave = keyAeronave;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaArribe = fechaArribe;
		this.keyTripulacion = keyTripulacion;
		this.observacion = observacion;
		this.estado = estado;
		this.asientos = asientos;
		this.tripulantes = tripulantes;
	}

	public void eventCreado() {
		addDomainEvent(new VueloCreado(key, nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe,
				keyTripulacion, observacion, estado));
	}

	public String getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(String nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public UUID getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(UUID keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaArribe() {
		return fechaArribe;
	}

	public void setFechaArribe(Date fechaArribe) {
		this.fechaArribe = fechaArribe;
	}

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
