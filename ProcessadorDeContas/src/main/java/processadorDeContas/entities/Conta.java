package processadorDeContas.entities;

import java.time.LocalDate;

public class Conta {
  private String codigoConta;
  private LocalDate data;
  private double valorPago;

  public Conta(String codigoConta, LocalDate data, double valorPago) {
    this.codigoConta = codigoConta;
    this.data = data;
    this.valorPago = valorPago;
  }

  public String getCodigoConta() {
    return codigoConta;
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
