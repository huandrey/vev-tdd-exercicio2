package processadorDeContas.entities;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {
  @Test
  public void testContaCreation() {
    Conta conta = new Conta("001", LocalDate.now(), 500.00);
    assertEquals("001", conta.getCodigoConta());
    assertEquals(500.00, conta.getValorPago());
  }
}
