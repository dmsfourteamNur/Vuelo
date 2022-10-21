package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Tripulacion.Tripulacion;

public class TripulacionRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);
	DbSet<Tripulacion> Tripulacions = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		database.Tripulacion = Tripulacions;
	}

	@Test
	public void constructor_accept() {
		TripulacionRepository repository = new TripulacionRepository(database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		Tripulacion a = new Tripulacion();
		when(Tripulacions.Single(any())).thenReturn(a);
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindEstado_accept() throws Exception {
		Tripulacion a = new Tripulacion();
		when(Tripulacions.Single(any())).thenReturn(a);
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.findEstado("1");
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Create(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_cancel() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Create(any());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Delete(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(database);
		repository.Update(new Tripulacion());
		Assert.assertNotNull(repository);
	}
}
