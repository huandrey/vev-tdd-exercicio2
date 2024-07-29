package sistemaDeIngressos;

import org.junit.jupiter.api.BeforeEach;

import sistemaDeIngressos.models.Ingresso;
import sistemaDeIngressos.models.StatusIngresso;
import sistemaDeIngressos.models.TipoIngresso;

public class IngressoTest {
  private Ingresso ingresso;

  @BeforeEach
  void setup() {
    ingresso = new Ingresso(1, TipoIngresso.NORMAL, StatusIngresso.NA0_VENDIDO);
  }
}
