package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

import processadorDeContas.entities.Conta;

public abstract class Pagamento {
  protected double valorPago;
  protected LocalDate data;

  public Pagamento(Conta conta, LocalDate data) {
    this.data = data;
    setValorPago(conta);
  }

  protected void setValorPago(Conta conta) {
    this.valorPago = conta.getValorPago();
  }

  public double getValorPago() {
    return valorPago;
  }

  public void setValorPago(double valorPago) {
    this.valorPago = valorPago;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public boolean isValidoParaInclusao(LocalDate dataConta, LocalDate dataFatura) {
    return dataConta.isEqual(dataFatura) || dataConta.isBefore(dataFatura);
  }
}
