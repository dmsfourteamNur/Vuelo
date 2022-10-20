package Repositories;

import core.IRepository;
import java.util.List;
import java.util.UUID;

import Model.Tripulacion.Tripulacion;

public interface ITripulacionRepository extends IRepository<Tripulacion, UUID> {
	public List<Tripulacion> GetAll() throws Exception;

	public Tripulacion Delete(Tripulacion tripulante) throws Exception;

	public Tripulacion Update(Tripulacion tripulante) throws Exception;

	public Tripulacion findEstado(String estado) throws Exception;
}