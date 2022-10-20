package Repository;

import java.util.List;
import java.util.UUID;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;

public class AeronaveRepository implements IAeronaveRepository {

	private DbSet<Aeronave> _aeronave;

	public AeronaveRepository(IWriteDbContext database) {
		_aeronave = database.Aeronave;
	}

	@Override
	public void Create(Aeronave objAeronave) throws Exception {
		_aeronave.Add(objAeronave);
	}

	@Override
	public Aeronave FindByKey(UUID key) throws Exception {
		return _aeronave.Single(obj -> obj.key.equals(key));
	}

	@Override
	public List<Aeronave> GetAll() throws Exception {
		return _aeronave.All();
	}

	@Override
	public Aeronave Delete(Aeronave objAeronave) throws Exception {
		_aeronave.Delete((it -> it.key.equals(objAeronave.key)));
		return objAeronave;
	}

	@Override
	public Aeronave Update(Aeronave objAeronave) throws Exception {
		_aeronave.Update(objAeronave, (it -> it.key.equals(objAeronave.key)));
		return objAeronave;
	}
}