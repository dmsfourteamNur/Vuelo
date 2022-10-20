package Dto;

import java.util.UUID;

public class TripulanteDto {

	public UUID keyTripulacion;
	public UUID keyTripulante;
	public String nombre;
	public String apellido;
	public String cargo;
	public String estado;

	public TripulanteDto() {
	}

	public TripulanteDto(UUID keyTripulacion, UUID keyTripulante, String nombre, String apellido, String cargo,
			String estado) {
		this.keyTripulacion = keyTripulacion;
		this.keyTripulante = keyTripulante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.estado = estado;
	}

	public UUID getKeyTripulacion() {
		return keyTripulacion;
	}

	public void setKeyTripulacion(UUID keyTripulacion) {
		this.keyTripulacion = keyTripulacion;
	}

	public UUID getKeyTripulante() {
		return keyTripulante;
	}

	public void setKeyTripulante(UUID keyTripulante) {
		this.keyTripulante = keyTripulante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}