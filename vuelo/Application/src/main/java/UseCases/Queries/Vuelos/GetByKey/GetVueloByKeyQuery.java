package UseCases.Queries.Vuelos.GetByKey;

import Dto.VueloDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetVueloByKeyQuery implements Request<VueloDto> {

  public UUID Key;

  public GetVueloByKeyQuery(UUID Key) {
    this.Key = Key;
  }
}
