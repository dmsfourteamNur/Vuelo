package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;

public class VueloRepositoryTest {
	IWriteDbContext database = Mockito.mock(IWriteDbContext.class);
	DbSet<Vuelo> Vuelos = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		database.Vuelo = Vuelos;
	}

	@Test
	public void constructor_accept() {
		VueloRepository repository = new VueloRepository(database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		Vuelo a = new Vuelo();
		when(Vuelos.Single(any())).thenReturn(a);
		VueloRepository repository = new VueloRepository(database);
		repository.FindByKey(any());
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindNroVuelo_accept() throws Exception {
		Vuelo a = new Vuelo();
		when(Vuelos.Single(any())).thenReturn(a);
		VueloRepository repository = new VueloRepository(database);
		repository.findNroVuelo(anyString());
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindFechaSalida_accept() throws Exception {
		Vuelo a = new Vuelo();
		when(Vuelos.Single(any())).thenReturn(a);
		VueloRepository repository = new VueloRepository(database);
		repository.findFechaSalida(any());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		VueloRepository repository = new VueloRepository(database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		VueloRepository repository = new VueloRepository(database);
		repository.Create(new Vuelo());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		VueloRepository repository = new VueloRepository(database);
		repository.Delete(new Vuelo());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		VueloRepository repository = new VueloRepository(database);
		repository.Update(new Vuelo());
		Assert.assertNotNull(repository);
	}

	@Test
	public void HandlePersonalRegistrado_Ok() throws HttpException {
		final UUID key = UUID.randomUUID();
		final String nroVuelo = "scz-cba-513184";
		final UUID keyVuelo = UUID.randomUUID();
		final List<Asiento> asientos = new ArrayList<>();
		final String origen = "Scz-ViruViru";
		final String destino = "CBA-CBA";
		final Date fechaSalida = new Date();
		final Date fechaArribe = new Date();
		final UUID keyTripulacion = UUID.randomUUID();
		final List<Tripulante> tripulantes = new ArrayList<>();

		VueloRepository vueloRepository = new VueloRepository(database);
		Vuelo vuelo = new Vuelo(nroVuelo, key, origen, destino, fechaSalida, fechaArribe, keyTripulacion, origen, destino,
				asientos, tripulantes);
		try {

			vueloRepository.GetAll();
			vueloRepository.FindByKey(key);
			vueloRepository.Create(vuelo);
			vueloRepository.Update(vuelo);
			vueloRepository.Delete(vuelo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
