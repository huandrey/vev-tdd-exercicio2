package processadorDeContas.entities.pagamento;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import processadorDeContas.entities.Conta;

public class PagamentoCartaoDeCreditoTest {
  Conta conta = new Conta("001", LocalDate.now().minusDays(15), 1000);

  @Test
  public void testInclusaoValida() {
    PagamentoCartaoDeCredito pagamento = new PagamentoCartaoDeCredito(conta, conta.getData());
    assertTrue(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoCartaoDeCredito pagamento = new PagamentoCartaoDeCredito(conta, conta.getData());
    assertFalse(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now().minusDays(14)));
  }
}
