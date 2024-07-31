package sistemaDeIngressos.models;

import java.util.ArrayList;
import java.util.List;

public class Show {
  private boolean isDataEspecial;
  private String artista;
  private double cache;
  private double totalDespesasInfraestrutura;
  private List<LoteIngresso> loteIngressos;
  private double receitaLiquida;
  private StatusFinanceiro statusFinanceiro;

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

  public LoteIngresso criaLoteIngresso(int idLote, int quantidadeIngressos, double precoNormalIngresso,
      double descontoAplicavel, double porcentagemVip) {
    LoteIngresso loteIngresso = new LoteIngresso(idLote, quantidadeIngressos, precoNormalIngresso, descontoAplicavel,
        porcentagemVip);
    loteIngressos.add(loteIngresso);

    return loteIngresso;
  }

  public LoteIngresso getLoteIngresso(int numeroLote) {
    return loteIngressos.get(numeroLote);
  }

  private double calcularReceitaLiquida() {
    double totalReceita = 0;
    for (LoteIngresso lote : loteIngressos) {
      for (Ingresso ingresso : lote.getIngressos()) {
        if (ingresso.getStatus() == StatusIngresso.VENDIDO) {
          totalReceita += lote.calculaPrecoComDesconto(ingresso);
        }
      }
    }

    double custos = calcularCustos();
    return totalReceita - custos;
  }

  private double calcularCustos() {
    double custos = cache + totalDespesasInfraestrutura;
    if (isDataEspecial) {
      custos += totalDespesasInfraestrutura * 0.15;
    }
    return custos;
  }

  private StatusFinanceiro determinarStatusFinanceiro() {
    if (receitaLiquida > 0) {
      return StatusFinanceiro.LUCRO;
    } else if (receitaLiquida == 0) {
      return StatusFinanceiro.ESTAVEL;
    } else {
      return StatusFinanceiro.PREJUIZO;
    }
  }

  public String gerarRelatorio() {
    receitaLiquida = calcularReceitaLiquida();
    statusFinanceiro = determinarStatusFinanceiro();

    int totalVip = 0;
    int totalMeiaEntrada = 0;
    int totalNormal = 0;

    for (LoteIngresso lote : this.loteIngressos) {
      for (Ingresso ingresso : lote.getIngressos()) {
        if (ingresso.getStatus() == StatusIngresso.VENDIDO) {
          switch (ingresso.getTipo()) {
            case VIP:
              totalVip++;
              break;
            case MEIA_ENTRADA:
              totalMeiaEntrada++;
              break;
            case NORMAL:
              totalNormal++;
              break;
          }
        }
      }
    }

    StringBuilder relatorio = new StringBuilder();
    relatorio.append("Relatório do Show: ").append(artista).append("\n");
    relatorio.append("Ingressos Vendidos (VIP): ").append(totalVip).append("\n");
    relatorio.append("Ingressos Vendidos (Meia Entrada): ").append(totalMeiaEntrada).append("\n");
    relatorio.append("Ingressos Vendidos (Normal): ").append(totalNormal).append("\n");
    relatorio.append("Receita Líquida: R$ ").append(receitaLiquida).append("\n");
    relatorio.append("Status Financeiro: ").append(statusFinanceiro).append("\n");

    return relatorio.toString();
  }
}
