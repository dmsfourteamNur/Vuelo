package Factories;

import java.util.UUID;

import Model.Aeronaves.Aeronave;

public interface IAeronaveFactory {
	public Aeronave Create(UUID key, String matricula, String estado);
}
