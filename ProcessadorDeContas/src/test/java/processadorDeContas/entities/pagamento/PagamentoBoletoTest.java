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
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, conta.getData());
    assertEquals(1000.00, pagamento.getValorPago());
  }

  @Test
  public void testValorPagoInvalido() {
    assertThrows(IllegalArgumentException.class, () -> {
      new PagamentoBoleto(0.00, LocalDate.now());
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new PagamentoBoleto(5000.01, LocalDate.now());
    });
  }

  @Test
  public void testValorPagoLimiteInferior() {
    PagamentoBoleto pagamento = new PagamentoBoleto(0.01, conta.getData());
    assertEquals(0.01, pagamento.getValorPago());
  }

  @Test
  public void testValorPagoLimiteSuperior() {
    PagamentoBoleto pagamento = new PagamentoBoleto(5000.00, conta.getData());
    assertEquals(5000.00, pagamento.getValorPago());
  }

  @Test
  public void testCalculoValorComAtraso() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, conta.getData().plusDays(1));
    assertEquals(1100.00, pagamento.getValorPago(LocalDate.now()));
  }

  @Test
  public void testInclusaoValida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, conta.getData());
    assertTrue(pagamento.isValidoParaInclusao(conta.getData(), LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, conta.getData());
    assertFalse(pagamento.isValidoParaInclusao(conta.getData(), conta.getData().minusDays(1)));
  }
}
