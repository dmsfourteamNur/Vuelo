# Defensa final

<br>

# Postman api testing

### GET DEL
```

const jsonData = pm.response.json();
pm.test("Verificación - Campos vacios", () => {
  pm.expect(jsonData.data.nroVuelo).not.empty;
  pm.expect(jsonData.data.keyAeronave).not.empty;
  pm.expect(jsonData.data.origen).not.empty;
  pm.expect(jsonData.data.destino).not.empty;
  pm.expect(jsonData.data.fechaSalida).not.empty;
  pm.expect(jsonData.data.fechaArribe).not.empty;
  pm.expect(jsonData.data.keyTripulacion).not.empty;
  pm.expect(jsonData.data.observacion).not.empty;
  pm.expect(jsonData.data.destino).not.empty;
});

pm.test("Status code is 200", () => {
  pm.response.to.have.status(200);
});

pm.test("El tiempo de respuesta es inferior a 400ms", function () {
  pm.expect(pm.response.responseTime).to.be.below(400);
});

pm.test("Verificación de codigo 400", function () {
  pm.expect(pm.response.code).to.be.oneOf([400]);
  console.log("Mala solicitud");
});
pm.test("Verificación de codigo 404", function () {
  pm.expect(pm.response.code).to.be.oneOf([404]);
  console.log("No encontrado");
});

pm.test("Verificación de codigo 502", function () {
  pm.expect(pm.response.code).to.be.oneOf([502]);
  console.log("Puerta de enlace incorrecta");
});
```

# Postman api testing

### POST PUT

```

pm.test("Validacioón: Campos vacios", function () {
  pm.response.to.have.status(200);
  let responseJSON = pm.response.json();

  pm.test("campo nroVuelo", function () {
    pm.expect(responseJSON).to.have.property("nroVuelo");
  });

  pm.test("campo keyAeronave", function () {
    pm.expect(responseJSON).to.have.property("keyAeronave");
  });

  pm.test("campo origen", function () {
    pm.expect(responseJSON).to.have.property("origen");
  });
  pm.test("campo destino", function () {
    pm.expect(responseJSON).to.have.property("destino");
  });

  pm.test("campo fechaSalida", function () {
    pm.expect(responseJSON).to.have.property("fechaSalida");
  });

  pm.test("campo fechaArribe", function () {
    pm.expect(responseJSON).to.have.property("fechaArribe");
  });

  pm.test("campo keyTripulacion", function () {
    pm.expect(responseJSON).to.have.property("keyTripulacion");
  });
  pm.test("campo observacion", function () {
    pm.expect(responseJSON).to.have.property("observacion");
  });

  pm.test("campo estado", function () {
    pm.expect(responseJSON).to.have.property("estado");
  });
});

pm.test("Status code is 200", () => {
  pm.response.to.have.status(200);
});

pm.test("El tiempo de respuesta es inferior a 400ms", function () {
  pm.expect(pm.response.responseTime).to.be.below(400);
});

pm.test("Verificación de codigo 400", function () {
  pm.expect(pm.response.code).to.be.oneOf([400]);
  console.log("Mala solicitud");
});
pm.test("Verificación de codigo 404", function () {
  pm.expect(pm.response.code).to.be.oneOf([404]);
  console.log("No encontrado");
});

pm.test("Verificación de codigo 502", function () {
  pm.expect(pm.response.code).to.be.oneOf([502]);
  console.log("Puerta de enlace incorrecta");
});
```
