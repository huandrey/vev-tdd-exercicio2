package sistemaDeIngressos.models;

import java.util.ArrayList;
import java.util.List;

public class Show {
  private boolean isDataEspecial;
  private String artista;
  private double cache;
  private double totalDespesasInfraestrutura;
  private List<LoteIngresso> loteIngressos;

  public Show(boolean isDataEspecial, String artista, double cache, double totalDespesasInfraestrutura) {
    this.isDataEspecial = isDataEspecial;
    this.artista = artista;
    this.cache = cache;
    this.totalDespesasInfraestrutura = totalDespesasInfraestrutura;
    this.loteIngressos = new ArrayList<>();
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

  public void criaLoteIngresso(int idLote, int quantidadeIngressos, double precoNormalIngresso, double descontoAplicavel, double porcentagemVip) {
    LoteIngresso loteIngresso = new LoteIngresso(idLote, quantidadeIngressos, precoNormalIngresso, descontoAplicavel, porcentagemVip);
    loteIngressos.add(loteIngresso);
  }

  public LoteIngresso getLoteIngresso(int numeroLote) {
    return loteIngressos.get(numeroLote);
  }
}
