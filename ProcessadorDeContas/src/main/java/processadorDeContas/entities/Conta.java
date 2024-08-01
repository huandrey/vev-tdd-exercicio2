package processadorDeContas.entities;

import java.time.LocalDate;

import processadorDeContas.entities.pagamento.Pagamento;

public class Conta {
  private String codigoConta;
  private LocalDate data;
  private double valorPago;
  private Pagamento pagamento;

  public Conta(String codigoConta, LocalDate data, double valorPago) {
    this.codigoConta = codigoConta;
    this.data = data;
    this.valorPago = valorPago;
  }

  public Conta(String codigoConta, LocalDate data, double valorPago, Pagamento pagamento) {
    this.codigoConta = codigoConta;
    this.data = data;
    this.valorPago = valorPago;
    this.pagamento = pagamento;
  }

  public String getCodigoConta() {
    return codigoConta;
  }

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public void setCodigoConta(String codigoConta) {
    this.codigoConta = codigoConta;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public double getValorPago() {
    return valorPago;
  }

  public void setValorPago(double valorPago) {
    this.valorPago = valorPago;
  }
}
