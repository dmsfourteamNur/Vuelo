package Factories;

import java.util.UUID;

import Model.Tripulacion.Tripulacion;

public interface ITripulacionFactory {
	public Tripulacion Create(UUID key, String descripcion, String estado);
}
