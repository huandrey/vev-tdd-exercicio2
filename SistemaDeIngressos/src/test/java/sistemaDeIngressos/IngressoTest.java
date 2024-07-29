package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IngressoTest {
  private Ingresso ingresso;

  @BeforeEach
  void setup() {
    ingresso = new Ingresso(1, TipoIngresso.NORMAL, StatusIngresso.NA0_VENDIDO);
  }
}
