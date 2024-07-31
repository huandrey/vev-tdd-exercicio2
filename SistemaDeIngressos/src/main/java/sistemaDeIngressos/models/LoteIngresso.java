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

  public void criaIngresso(TipoIngresso tipo, int quantidade) {
    for (int i = 0; i < quantidade; i++) {
        ingressos.add(new Ingresso(i, tipo, StatusIngresso.NA0_VENDIDO));
    }
}

  private double calculaPreco(Ingresso ingresso) {
    switch (ingresso.getTipo()) {
      case VIP:
        return this.precoNormalIngresso * 2; // VIP custa o dobro do NORMAL
      case MEIA_ENTRADA:
        return this.precoNormalIngresso / 2; // MEIA_ENTRADA custa metade do NORMAL
      default:
        return this.precoNormalIngresso; // NORMAL
    }
  }

  public double calculaPrecoComDesconto(Ingresso ingresso) {
    if (ingresso.getTipo() == TipoIngresso.VIP || ingresso.getTipo() == TipoIngresso.NORMAL) {
      return calculaPreco(ingresso) * (1 - this.descontoAplicavel);
    }
    return calculaPreco(ingresso);
  }
}
