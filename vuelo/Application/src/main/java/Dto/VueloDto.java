package Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Model.Vuelos.Vuelo;

public class VueloDto {

	public UUID key;
	public String nroVuelo;
	public UUID keyAeronave;
	public String origen;
	public String destino;
	public Date fechaSalida;
	public Date fechaArribe;
	public UUID keyTripulacion;
	public String observacion;
	public String estado;
	public List<AsientoDto> asientos;
	public List<TripulanteDto> tripulantes;

	public VueloDto() {
	}

	public VueloDto(String nroVuelo, UUID keyAeronave, String origen, String destino, Date fechaSalida,
			Date fechaArribe, UUID keyTripulacion, String observacion, String estado, List<AsientoDto> asientos,
			List<TripulanteDto> tripulantes) {
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

	public VueloDto(Vuelo vuelo) {
		this.nroVuelo = vuelo.getNroVuelo();
		this.keyAeronave = vuelo.getKeyAeronave();
		this.origen = vuelo.getOrigen();
		this.destino = vuelo.getDestino();
		this.fechaSalida = vuelo.getFechaSalida();
		this.fechaArribe = vuelo.getFechaArribe();
		this.keyTripulacion = vuelo.getKeyTripulacion();
		this.observacion = vuelo.getObservacion();
		this.estado = vuelo.getEstado();
	}

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
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

	public List<AsientoDto> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<AsientoDto> asientos) {
		this.asientos = asientos;
	}

	public List<TripulanteDto> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<TripulanteDto> tripulantes) {
		this.tripulantes = tripulantes;
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