package sistemaDeIngressos;

import org.junit.jupiter.api.BeforeEach;

import sistemaDeIngressos.models.LoteIngresso;

public class LoteIngressoTest {
  private LoteIngresso loteIngresso;

  @BeforeEach
  void setup() {
    loteIngresso = new LoteIngresso(1, 500, 10.00, 10.00, 20);
  }
}
