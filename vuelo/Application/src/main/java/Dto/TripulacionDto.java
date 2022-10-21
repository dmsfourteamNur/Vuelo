package Dto;

import java.util.List;
import java.util.UUID;

public class TripulacionDto {

	public UUID keyTripulacion;
	public String descripcion;
	public String estado;

	public List<TripulanteDto> tripulantes;

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<TripulanteDto> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<TripulanteDto> tripulantes) {
		this.tripulantes = tripulantes;
	}
}