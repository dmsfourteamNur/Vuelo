package Model.Tripulacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import core.AggregateRoot;

public class Tripulacion extends AggregateRoot<UUID> {

	public String descripcion;
	public List<Tripulante> tripulantes;
	public String estado;

	public Tripulacion() {
	}

	public Tripulacion(UUID key, String descripcion, String estado) {
		this.key = key;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tripulantes = new ArrayList<Tripulante>();
	}

	// para la tripulacion consumer
	public void agregarTripulante(UUID key, UUID keyTripulacion, String nombre, String apellido, String cargo,
			String estado) {
		Tripulante tripulante = new Tripulante(key, keyTripulacion, nombre, apellido, cargo, estado);
		tripulantes.add(tripulante);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void agregarTripulante(Tripulante tripulante001) {
	}

	public void agregarAsiento(Tripulante tripulante002) {
	}

}