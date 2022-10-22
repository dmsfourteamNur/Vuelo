package UseCases.Command.Vuelos.Arribar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.VueloDto;
import Factories.IVueloFactory;
import Fourteam.http.Exception.HttpException;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class ArribarVueloHandlerTest {
	IVueloFactory iVueloFactory = Mockito.mock(IVueloFactory.class);
	IVueloRepository iVueloRepository = Mockito.mock(IVueloRepository.class);
	IUnitOfWork iUnitOfWork = Mockito.mock(IUnitOfWork.class);
	IAeronaveRepository iAeronaveRepository = Mockito.mock(IAeronaveRepository.class);
	ITripulacionRepository iTripulacionRepository = Mockito.mock(ITripulacionRepository.class);

	@Before
	public void setUp() {
	}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String nroVuelo = "scz-cba-513184";
		UUID keyAeronave = UUID.randomUUID();
		String origen = "Scz-ViruViru";
		String destino = "CBA-CBA";
		Date fechaSalida = new Date();
		Date fechaArribe = new Date();
		UUID keyTripulacion = UUID.randomUUID();
		String observacion = "En horario";
		String estado = "1";
		List<Asiento> asientos = new ArrayList<>();
		List<Tripulante> tripulantes = new ArrayList<>();
		Vuelo vuelo = new Vuelo(nroVuelo, keyAeronave, origen, destino, fechaSalida, fechaArribe, keyTripulacion,
				observacion, estado, asientos, tripulantes);
		vuelo.key = key;
		when(iVueloRepository.FindByKey(any(UUID.class))).thenReturn(vuelo);
		// when(iVueloRepository.Delete(any(Vuelo.class))).thenReturn(vuelo);

		ArribarVueloHandler handler = new ArribarVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository,
				iTripulacionRepository, iUnitOfWork);

		VueloDto vueloDto = new VueloDto();

		vueloDto.key = key;
		vueloDto.nroVuelo = nroVuelo;
		vueloDto.keyAeronave = keyAeronave;
		vueloDto.origen = origen;
		vueloDto.destino = destino;
		vueloDto.fechaSalida = fechaSalida;
		vueloDto.fechaArribe = fechaArribe;
		vueloDto.keyTripulacion = keyAeronave;
		vueloDto.observacion = observacion;
		vueloDto.estado = estado;
		ArribarVueloCommand command = new ArribarVueloCommand(vueloDto.key);
		// try {
		// UUID resp = handler.handle(command);
		// } catch (HttpException e) {
		// Assert.assertEquals(400, e.getCode());
		// }
	}

	@Test
  public void HandleFailed() throws Exception {
    when(iVueloRepository.FindByKey(any())).thenReturn(null);
		ArribarVueloHandler handler = new ArribarVueloHandler(iVueloFactory, iVueloRepository, iAeronaveRepository, iTripulacionRepository, iUnitOfWork);
		VueloDto vueloDto = new VueloDto();
		vueloDto.key = UUID.randomUUID();
		vueloDto.nroVuelo = "2";
		vueloDto.keyAeronave =UUID.randomUUID();
		vueloDto.origen = "scz";
		vueloDto.destino = "cbba";
		vueloDto.fechaSalida = new Date();
		vueloDto.fechaArribe = new Date();
		vueloDto.keyTripulacion =UUID.randomUUID();
		vueloDto.observacion = "En horario";
		vueloDto.estado = "1";
		ArribarVueloCommand command = new ArribarVueloCommand(vueloDto.key);
     try {
      UUID resp = handler.handle(command);
    } catch (HttpException e) {
      Assert.assertEquals(400, e.getCode());
    }
  }

}
