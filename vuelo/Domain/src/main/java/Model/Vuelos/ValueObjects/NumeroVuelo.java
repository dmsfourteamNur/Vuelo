package Model.Vuelos.ValueObjects;

import core.BussinessRuleValidateExeption;
import core.ValueObject;
import rule.StringNotNullOrEmptyRule;

public class NumeroVuelo extends ValueObject {

  public String value;

  public NumeroVuelo(String _value) throws BussinessRuleValidateExeption {
    CheckRule(new StringNotNullOrEmptyRule(_value));
    this.value = _value;
  }

  @Override
  public String toString() {
    return value;
  }
}
