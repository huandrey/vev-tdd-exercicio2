package processadorDeContas.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PagamentoTest {
  @Test
  public void testPagamentoCreation() {
    // Testar criação de um pagamento, mas sem lógica específica
    Pagamento pagamento = new Pagamento(1000.00, LocalDate.now()) {
    };
    assertEquals(1000.00, pagamento.getValorPago());
  }
}
