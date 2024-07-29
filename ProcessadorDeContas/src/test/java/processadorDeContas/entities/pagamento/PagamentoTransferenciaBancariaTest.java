package processadorDeContas.entities.pagamento;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PagamentoTransferenciaBancariaTest {
  @Test
  public void testInclusaoValida() {
    PagamentoTransferenciaBancaria pagamento = new PagamentoTransferenciaBancaria(1000.00, LocalDate.now());
    assertTrue(pagamento.isValidoParaInclusao(LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoTransferenciaBancaria pagamento = new PagamentoTransferenciaBancaria(1000.00,
        LocalDate.now().minusDays(1));
    assertFalse(pagamento.isValidoParaInclusao(LocalDate.now().minusDays(2)));
  }
}
