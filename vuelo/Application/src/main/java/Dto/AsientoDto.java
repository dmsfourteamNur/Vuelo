package Dto;

import java.util.UUID;

public class AsientoDto {

	public UUID keyAeronave;
	public UUID key;
	public int numero;
	public String clase;
	public Double precio;
	public int disponibilidad;

	public AsientoDto() {
	}

	public AsientoDto(UUID key, UUID keyAeronave, int numero, String clase, Double precio) {
		this.key = key;

		this.keyAeronave = keyAeronave;
		this.numero = numero;
		this.clase = clase;
		this.precio = precio;
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

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}
}