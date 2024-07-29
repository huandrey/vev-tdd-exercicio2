package sistemaDeIngressos.models;

public class Show {
  private boolean isDataEspecial;
  private String artista;
  private double cache;
  private double totalDespesasInfraestrutura;

  public Show(boolean isDataEspecial, String artista, double cache, double totalDespesasInfraestrutura) {
    this.isDataEspecial = isDataEspecial;
    this.artista = artista;
    this.cache = cache;
    this.totalDespesasInfraestrutura = totalDespesasInfraestrutura;
  }

  public boolean isDataEspecial() {
    return isDataEspecial;
  }

  public void setDataEspecial(boolean isDataEspecial) {
    this.isDataEspecial = isDataEspecial;
  }

  public String getArtista() {
    return artista;
  }

  public void setArtista(String artista) {
    this.artista = artista;
  }

  public double getCache() {
    return cache;
  }

  public void setCache(double cache) {
    this.cache = cache;
  }

  public double getTotalDespesasInfraestrutura() {
    return totalDespesasInfraestrutura;
  }

  public void setTotalDespesasInfraestrutura(double totalDespesasInfraestrutura) {
    this.totalDespesasInfraestrutura = totalDespesasInfraestrutura;
  }
}
