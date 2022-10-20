package Factories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;

public interface IVueloFactory {
	public Vuelo Create(
			String nroVuelo,
			UUID keyAeronave,
			String origen,
			String destino,
			Date fecha_salida,
			Date fecha_arribe,
			UUID keyTripulacion,
			String observacion,
			String estado,
			List<Asiento> asientos,
			List<Tripulante> tripulantes);
}
