package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaDeIngressos.models.Ingresso;
import sistemaDeIngressos.models.StatusIngresso;
import sistemaDeIngressos.models.TipoIngresso;

public class IngressoTest {
  private Ingresso ingresso;

  @BeforeEach
  void setup() {
    ingresso = new Ingresso(1, TipoIngresso.NORMAL, StatusIngresso.NA0_VENDIDO);
  }

  @Test
  void vendeIngresso() {
    ingresso.vendeIngresso();
    assertEquals(StatusIngresso.VENDIDO, ingresso.getStatus(), "O ingresso não deveria estar na status NA0_VENDIDO.");
  }
}
