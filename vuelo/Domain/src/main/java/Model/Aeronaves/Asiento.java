package Model.Aeronaves;

import java.util.UUID;

import core.Entity;

public class Asiento extends Entity<UUID> {

	public UUID keyAeronave;
	public int numero;
	public String clase;
	public Double precio;
	public int disponibilidad;

	public Asiento(UUID key, UUID keyAeronave, int numero, String clase, Double precio, int disponibilidad) {
		this.key = key;
		this.keyAeronave = keyAeronave;
		this.numero = numero;
		this.clase = clase;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
	}

	public UUID getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(UUID keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}