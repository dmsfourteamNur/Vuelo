package Factories;

import java.util.UUID;

import Model.Aeronaves.Aeronave;

public class AeronaveFactory implements IAeronaveFactory {

	public AeronaveFactory() {
	}

	@Override
	public Aeronave Create(UUID key, String matricula, String estado) {
		return new Aeronave(key, matricula, estado);
	}

}
