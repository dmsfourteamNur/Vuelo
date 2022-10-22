import Controllers.AeronaveController;
import Controllers.TripulacionController;
import Controllers.VueloController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class WebApi {

	public static void AddControllers() {
		Rest.addController(VueloController.class);
		Rest.addController(TripulacionController.class);
		Rest.addController(AeronaveController.class);
		Rest.start(Integer.parseInt(Config.getProperty("http.port")));
		Rest.createSwagger();
	}
}