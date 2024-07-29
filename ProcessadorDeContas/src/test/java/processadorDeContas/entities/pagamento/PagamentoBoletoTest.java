package processadorDeContas.entities.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import processadorDeContas.entities.Conta;

public class PagamentoBoletoTest {
  Conta conta = new Conta("001", LocalDate.now(), 1000);

  @Test
  public void testValorPagoValido() {
    PagamentoBoleto pagamento = new PagamentoBoleto(conta, conta.getData());
    assertEquals(1000.00, pagamento.getValorPago());
  }

  @Test
  public void testValorPagoInvalido() {
    assertThrows(IllegalArgumentException.class, () -> {
      Conta contaAbaixoDoLimiteBoleto = new Conta("001", LocalDate.now(), 0.00);
      new PagamentoBoleto(contaAbaixoDoLimiteBoleto, contaAbaixoDoLimiteBoleto.getData());
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Conta contaAcimaDoLimiteBoleto = new Conta("002", LocalDate.now(), 5000.01);

      new PagamentoBoleto(contaAcimaDoLimiteBoleto, contaAcimaDoLimiteBoleto.getData());
    });
  }

  @Test
  public void testValorPagoLimiteInferior() {
    Conta contaLimiteInferiorBoleto = new Conta("001", LocalDate.now(), 0.01);
    PagamentoBoleto pagamento = new PagamentoBoleto(contaLimiteInferiorBoleto, contaLimiteInferiorBoleto.getData());
    assertEquals(0.01, pagamento.getValorPago());
  }

  @Test
  public void testValorPagoLimiteSuperior() {
    Conta contaLimiteSuperiorBoleto = new Conta("001", LocalDate.now(), 5000.00);
    PagamentoBoleto pagamento = new PagamentoBoleto(contaLimiteSuperiorBoleto, contaLimiteSuperiorBoleto.getData());
    assertEquals(5000.00, pagamento.getValorPago());
  }

  @Test
  public void testCalculoValorComAtraso() {
    PagamentoBoleto pagamento = new PagamentoBoleto(conta, conta.getData().plusDays(1));
    assertEquals(1100.00, pagamento.getValorPago());
  }

  @Test
  public void testInclusaoValida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(conta, conta.getData());
    assertTrue(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(conta, conta.getData());
    assertFalse(pagamento.isValidoParaInclusao(conta.getData(), conta.getData().minusDays(1)));
  }
}
