package processadorDeContas.pagamento;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PagamentoCartaoDeCreditoTest {
  @Test
  public void testInclusaoValida() {
    PagamentoCartaoDeCredito pagamento = new PagamentoCartaoDeCredito(1000.00, LocalDate.now().minusDays(15));
    assertTrue(pagamento.isValidoParaInclusao(LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoCartaoDeCredito pagamento = new PagamentoCartaoDeCredito(1000.00, LocalDate.now());
    assertFalse(pagamento.isValidoParaInclusao(LocalDate.now().minusDays(14)));
  }
}
