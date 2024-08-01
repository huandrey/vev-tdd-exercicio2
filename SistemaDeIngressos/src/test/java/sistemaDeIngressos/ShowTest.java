package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaDeIngressos.models.LoteIngresso;
import sistemaDeIngressos.models.Show;

public class ShowTest {
  private Show show;

  @BeforeEach
  void setup() {
    show = new Show(true, "Kendrick Lamar", 1000.00, 2000.00);
  }

  @Test
  void criaLoteIngressoPorMeioDoShow() {
    show.criaLoteIngresso(1, 500, 10.0, 15, 20);
    LoteIngresso loteIngresso = show.getLoteIngresso(0);

    assertNotNull(loteIngresso, "O objeto loteIngresso não deveria ser nulo.");
    assertEquals(500, loteIngresso.getTotalIngressos(), "O número total de ingressos deve ser 500.");
  }

  @Test
  void gerarRelatorioComLucro() {
    LoteIngresso lote = show.criaLoteIngresso(1, 500, 10.00, 15.00, 20);
    lote.venderTodosIngressos();
    String relatorio = show.gerarRelatorio();
    assertEquals("Relatório do Show: Kendrick Lamar\n" +
        "Ingressos Vendidos (VIP): 100\n" +
        "Ingressos Vendidos (Meia Entrada): 50\n" +
        "Ingressos Vendidos (Normal): 350\n" +
        "Receita Líquida: R$ 1625.0\n" +
        "Status Financeiro: LUCRO\n", relatorio);
  }
}
