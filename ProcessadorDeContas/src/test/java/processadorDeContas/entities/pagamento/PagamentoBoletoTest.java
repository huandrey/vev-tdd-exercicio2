package processadorDeContas.entities.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PagamentoBoletoTest {
  @Test
  public void testValorPagoValido() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, LocalDate.now());
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
    PagamentoBoleto pagamento = new PagamentoBoleto(0.01, LocalDate.now());
    assertEquals(0.01, pagamento.getValorPago());
  }

  @Test
  public void testValorPagoLimiteSuperior() {
    PagamentoBoleto pagamento = new PagamentoBoleto(5000.00, LocalDate.now());
    assertEquals(5000.00, pagamento.getValorPago());
  }

  @Test
  public void testCalculoValorComAtraso() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, LocalDate.now().plusDays(1));
    assertEquals(1100.00, pagamento.calcularValorComAtraso(LocalDate.now()));
  }

  @Test
  public void testInclusaoValida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, LocalDate.now());
    assertTrue(pagamento.isValidoParaInclusao(LocalDate.now()));
  }

  @Test
  public void testInclusaoInvalida() {
    PagamentoBoleto pagamento = new PagamentoBoleto(1000.00, LocalDate.now().plusDays(1));
    assertFalse(pagamento.isValidoParaInclusao(LocalDate.now()));
  }
}
