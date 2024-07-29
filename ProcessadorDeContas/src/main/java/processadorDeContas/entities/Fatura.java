package processadorDeContas.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura {
  private LocalDate data;
  private double valorTotal;
  private String nomeCliente;
  private StatusFatura status;
  private ArrayList<Conta> contas;

  public Fatura(LocalDate data, double valorTotal, String nomeCliente) {
    this.data = data;
    this.valorTotal = valorTotal;
    this.nomeCliente = nomeCliente;
    this.status = StatusFatura.PENDENTE;
  }

  public ArrayList<Conta> getContas() {
    return this.contas;
  }

  public void adicionaConta(Conta conta) {
    this.contas.add(conta);
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public void setStatus(StatusFatura status) {
    this.status = status;
  }

  public StatusFatura getStatus() {
    return status;
  }

}
