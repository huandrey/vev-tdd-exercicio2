package processadorDeContas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import processadorDeContas.entities.Fatura;
import processadorDeContas.entities.StatusFatura;

public class FaturaTest {
  @Test
  public void testFaturaCreation() {
    Fatura fatura = new Fatura(LocalDate.now(), 1500.00, "Cliente A");
    assertEquals(1500.00, fatura.getValorTotal());
    assertEquals("Cliente A", fatura.getNomeCliente());
    assertEquals(StatusFatura.PENDENTE, fatura.getStatus());
  }
}
