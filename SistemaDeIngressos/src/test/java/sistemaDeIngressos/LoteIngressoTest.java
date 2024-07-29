package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoteIngressoTest {
  private LoteIngresso loteIngresso;

  @BeforeEach
  void setup() {
    loteIngresso = new LoteIngresso(1, 500, 10.00, 10.00, 20);
  }
}
