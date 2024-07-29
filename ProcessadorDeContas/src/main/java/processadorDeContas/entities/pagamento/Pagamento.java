package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

public abstract class Pagamento {
  protected double valorPago;
  protected LocalDate data;

  public Pagamento(double valorPago, LocalDate data) {
    this.valorPago = valorPago;
    this.data = data;
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
