package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

import processadorDeContas.entities.Conta;

public class PagamentoBoleto extends Pagamento {
  public PagamentoBoleto(Conta conta, LocalDate data) {
    super(conta, data);
    verificaValorBoleto();
    setValorPago(conta);
  }

  @Override
  protected void setValorPago(Conta conta) {
    if (data.isAfter(conta.getData())) {
      super.valorPago = conta.getValorPago() * 1.10;
    } else {
      super.valorPago = conta.getValorPago();
    }
  }

  private void verificaValorBoleto() {
    if (valorPago < 0.01 || valorPago > 5000.00) {
      throw new IllegalArgumentException("Valor do boleto inválido");
    }
  }
}