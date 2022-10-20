package Context;

import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Model.Aeronaves.Aeronave;
import Model.Tripulacion.Tripulacion;
import Model.Vuelos.Vuelo;

public abstract class IWriteDbContext extends DbContext {

	public IWriteDbContext(Class dbContextClass) throws DataBaseException {
		super(dbContextClass);
	}

	// name data base
	public DbSet<Vuelo> Vuelo;
	public DbSet<Tripulacion> Tripulacion;
	public DbSet<Aeronave> Aeronave;
}
