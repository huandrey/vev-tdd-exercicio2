package sistemaDeIngressos.models;

public class LoteIngresso {
  private int id;
  private int quantidadeIngresso;
  private double precoNormalIngresso;
  private double descontoAplicavel;
  private double porcentagemVip;

  public LoteIngresso(int id, int quantidadeIngresso, double precoNormalIngresso, double descontoAplicavel, double porcentagemVip) {
    this.id = id;
    this.quantidadeIngresso = quantidadeIngresso;
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

  public int getQuantidadeIngresso() {
    return quantidadeIngresso;
  }

  public void setQuantidadeIngresso(int quantidadeIngresso) {
    this.quantidadeIngresso = quantidadeIngresso;
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
