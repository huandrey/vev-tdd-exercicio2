package processadorDeContas.entities.pagamento;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import processadorDeContas.entities.Conta;

public class PagamentoTransferenciaBancariaTest {
  Conta conta = new Conta("001", LocalDate.now(), 1000);

  @Test
  public void testInclusaoValida() {
    PagamentoTransferenciaBancaria pagamento = new PagamentoTransferenciaBancaria(1000.00, conta.getData());
    assertTrue(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoTransferenciaBancaria pagamento = new PagamentoTransferenciaBancaria(1000.00,
        conta.getData());
    assertFalse(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now().minusDays(1)));
  }
}
