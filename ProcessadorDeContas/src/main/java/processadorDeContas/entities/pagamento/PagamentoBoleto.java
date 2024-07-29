package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

public class PagamentoBoleto extends Pagamento {
  public PagamentoBoleto(double valorPago, LocalDate data) {
    super(valorPago, data);
    verificaValorBoleto();
  }

  public double getValorPago(LocalDate dataConta) {
    if (data.isAfter(dataConta)) {
      return valorPago * 1.10;
    }
    return valorPago;
  }

  private void verificaValorBoleto() {
    if (valorPago < 0.01 || valorPago > 5000.00) {
      throw new IllegalArgumentException("Valor do boleto inválido");
    }
  }
}