package sistemaDeIngressos.models;

public class LoteIngresso {
  private int id;
  private int quantidadeTotalIngressos;
  private double precoNormalIngresso;
  private double descontoAplicavel;
  private double porcentagemVip;

  public LoteIngresso(int id, int quantidadeTotalIngressos, double precoNormalIngresso, double descontoAplicavel, double porcentagemVip) {
    if (descontoAplicavel > 25) {
      throw new IllegalArgumentException("Desconto não pode ser maior que 25%.");
    }
    if (porcentagemVip < 20 || porcentagemVip > 30) {
      throw new IllegalArgumentException("A porcentagem de ingressos VIP deve estar entre 20% e 30%.");
  }

    this.id = id;
    this.quantidadeTotalIngressos = quantidadeTotalIngressos;
    this.precoNormalIngresso = precoNormalIngresso;
    this.descontoAplicavel = descontoAplicavel;
    this.porcentagemVip = porcentagemVip;
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
}
