package Repository;

import Context.IWriteDbContext;
import Repositories.ITripulacionRepository;
import Fourteam.db.DbSet;
import Model.Tripulacion.Tripulacion;

import java.util.List;
import java.util.UUID;

public class TripulacionRepository implements ITripulacionRepository {

	private DbSet<Tripulacion> _tripulacion;

	public TripulacionRepository(IWriteDbContext database) {
		_tripulacion = database.Tripulacion;//name base de datos
	}

	@Override
	public List<Tripulacion> GetAll() throws Exception {
		return _tripulacion.All();
	}

	@Override
	public Tripulacion FindByKey(UUID key) throws Exception {
		return _tripulacion.Single(obj -> obj.key.equals(key));
	}

	@Override
	public void Create(Tripulacion objTripulante) throws Exception {
		_tripulacion.Add(objTripulante);
	}

	@Override
	public Tripulacion Update(Tripulacion objTripulante) throws Exception {
		_tripulacion.Update(objTripulante, (it -> it.key.equals(objTripulante.key)));
		return objTripulante;
	}

	@Override
	public Tripulacion Delete(Tripulacion objTripulante) throws Exception {
		_tripulacion.Delete((it -> it.key.equals(objTripulante.key)));
		return objTripulante;
	}

	@Override
	public Tripulacion findEstado(String estado) throws Exception {
		return _tripulacion.Single(obj -> obj.estado.equals(estado));

	}
}
