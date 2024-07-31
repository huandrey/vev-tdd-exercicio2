package sistemaDeIngressos.models;

import java.util.ArrayList;
import java.util.List;

public class LoteIngresso {
  private int id;
  private int quantidadeTotalIngressos;
  private double precoNormalIngresso;
  private double descontoAplicavel;
  private double porcentagemVip;
  private List<Ingresso> ingressos;

  public LoteIngresso(int id, int quantidadeTotalIngressos, double precoNormalIngresso, double descontoAplicavel,
      double porcentagemVip) {
    if (descontoAplicavel > 25) {
      throw new IllegalArgumentException("Desconto não pode ser maior que 25%.");
    }
    if (porcentagemVip < 20 || porcentagemVip > 30) {
      throw new IllegalArgumentException("A porcentagem de ingressos VIP deve estar entre 20% e 30%.");
    }

    this.id = id;
    this.quantidadeTotalIngressos = quantidadeTotalIngressos;
    this.precoNormalIngresso = precoNormalIngresso;
    this.descontoAplicavel = descontoAplicavel / 100;
    this.porcentagemVip = porcentagemVip / 100;
    this.ingressos = new ArrayList<>();

    criarIngressos(quantidadeTotalIngressos, porcentagemVip / 100);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTotalIngressos() {
    return quantidadeTotalIngressos;
  }

  public double getPrecoNormalIngresso() {
    return precoNormalIngresso;
  }

  public void setPrecoNormalIngresso(double precoNormalIngresso) {
    this.precoNormalIngresso = precoNormalIngresso;
  }

  public double getDescontoAplicavel() {
    return descontoAplicavel;
  }

  public void setDescontoAplicavel(double descontoAplicavel) {
    this.descontoAplicavel = descontoAplicavel;
  }

  public double getPorcentagemVip() {
    return porcentagemVip;
  }

  public void setPorcentagemVip(double porcentagemVip) {
    this.porcentagemVip = porcentagemVip;
  }

  public List<Ingresso> getIngressos() {
    return ingressos;
  }

  private void criarIngressos(int totalIngressos, double percentualVip) {
    int quantidadeVip = (int) Math.round(totalIngressos * percentualVip);
    int quantidadeMeiaEntrada = (int) Math.floor(totalIngressos * 0.10);
    int quantidadeNormal = totalIngressos - quantidadeVip - quantidadeMeiaEntrada;

    adicionarIngressos(TipoIngresso.VIP, quantidadeVip);
    adicionarIngressos(TipoIngresso.MEIA_ENTRADA, quantidadeMeiaEntrada);
    adicionarIngressos(TipoIngresso.NORMAL, quantidadeNormal);
  }

  public void adicionarIngressos(TipoIngresso tipo, int quantidade) {
    for (int i = 0; i < quantidade; i++) {
      ingressos.add(new Ingresso(i, tipo, StatusIngresso.NA0_VENDIDO));
    }
  }

  private double calculaPreco(Ingresso ingresso) {
    switch (ingresso.getTipo()) {
      case VIP:
        return this.precoNormalIngresso * 2;
      case MEIA_ENTRADA:
        return this.precoNormalIngresso / 2;
      default:
        return this.precoNormalIngresso;
    }
  }

  public double calculaPrecoComDesconto(Ingresso ingresso) {
    if (ingresso.getTipo() == TipoIngresso.VIP || ingresso.getTipo() == TipoIngresso.NORMAL) {
      return calculaPreco(ingresso) * (1 - this.descontoAplicavel);
    }
    return calculaPreco(ingresso);
  }

  public void venderTodosIngressos() {
    for (Ingresso ingresso : ingressos) {
      if (ingresso.getStatus() == StatusIngresso.NA0_VENDIDO) {
        ingresso.vendeIngresso();
      }
    }
  }
}
