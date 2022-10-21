package Factories;

import java.util.UUID;

import Model.Tripulacion.Tripulacion;

public class TripulacionFactory implements ITripulacionFactory {

	public TripulacionFactory() {}

	@Override
	public Tripulacion Create(UUID key, String descripcion, String estado) {
		return new Tripulacion(key, descripcion, estado);

	}
}
