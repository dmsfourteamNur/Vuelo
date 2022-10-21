package Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import core.AggregateRoot;

public class Aeronave extends AggregateRoot<UUID> {

	public String matricula;
	public List<Asiento> asientos;
	public String estado;

	public Aeronave() {
	}

	public Aeronave(UUID key, String matricula, String estado) {
		this.key = key;
		this.matricula = matricula;
		this.estado = estado;
		this.asientos = new ArrayList<Asiento>();
	}

	// para el aeronave consumer
	public void agregarAsiento(UUID key, UUID keyAeronave, int numero, String clase, Double precio, int disponibilidad) {
		Asiento asiento = new Asiento(key, keyAeronave, numero, clase, precio, disponibilidad);
		asientos.add(asiento);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void agregarAsiento(Asiento asiento001) {
	}
}