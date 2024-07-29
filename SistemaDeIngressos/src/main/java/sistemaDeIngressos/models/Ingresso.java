package sistemaDeIngressos.models;


public class Ingresso {
  private int id;
  private TipoIngresso tipo;
  private StatusIngresso status;

  public Ingresso(int id, TipoIngresso tipoIngresso, StatusIngresso statusIngresso) {
    this.id = id;
    this.tipo = tipoIngresso;
    this.status = statusIngresso;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public TipoIngresso getTipo() {
    return tipo;
  }

  public void setTipo(TipoIngresso tipo) {
    this.tipo = tipo;
  }

  public StatusIngresso getStatus() {
    return status;
  }

  public void setStatus(StatusIngresso status) {
    this.status = status;
  }
}
