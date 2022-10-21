package Model.Tripulacion;

import java.util.UUID;

import core.Entity;

public class Tripulante extends Entity<UUID> {

	public UUID keyTripulacion;
	public String nombre;
	public String apellido;
	public String cargo;
	public String estado;

	public Tripulante(UUID key, UUID keyTripulacion, String nombre, String apellido, String cargo, String estado) {
		this.key = key;
		this.keyTripulacion = keyTripulacion;
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