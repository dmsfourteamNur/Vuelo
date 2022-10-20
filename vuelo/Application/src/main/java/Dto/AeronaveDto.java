package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AeronaveDto {

	public UUID keyAeronave;
	public String matricula;
	public List<AsientoDto> listaAsientos;
	public String estado;

	public AeronaveDto() {
		listaAsientos = new ArrayList<>();
	}

	public UUID getKeyAeronave() {
		return keyAeronave;
	}

	public void setKeyAeronave(UUID keyAeronave) {
		this.keyAeronave = keyAeronave;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<AsientoDto> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<AsientoDto> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}