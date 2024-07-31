package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaDeIngressos.models.Ingresso;
import sistemaDeIngressos.models.LoteIngresso;
import sistemaDeIngressos.models.StatusIngresso;
import sistemaDeIngressos.models.TipoIngresso;

public class LoteIngressoTest {
  private LoteIngresso loteIngresso;

  @BeforeEach
  void setup() {
    loteIngresso = new LoteIngresso(1, 500, 10.00, 10.00, 20);
  }

  @Test
  void recuperaInformacoesDoLote () {
    assertNotNull(loteIngresso, "O objeto loteIngresso não deveria ser nulo.");
    assertEquals(1, loteIngresso.getId(), "O id do lote de ingressos deve ser 1.");
    assertEquals(500, loteIngresso.getTotalIngressos(), "A quantidade de ingressos deve ser 500.");
    assertEquals(10.00, loteIngresso.getPrecoNormalIngresso(), "O preço normal dos ingressos deve ser 10.00.");
    assertEquals(0.1, loteIngresso.getDescontoAplicavel(), "O desconto aplicável dos ingressos deve ser 10.00.");
  }

  @Test
  void criaLoteIngressoComDescontoMaiorQue25() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new LoteIngresso(1, 500, 10.0, 25.1, 20); // Desconto de 25.1%
    }, "Esperava IllegalArgumentException para desconto acima de 25%.");
    assertEquals("Desconto não pode ser maior que 25%.", exception.getMessage());
  }

  @Test
  void criaLoteIngressoComPorcentagemVipMaiorQue30() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new LoteIngresso(1, 500, 10.0, 25, 30.1); // Desconto de 25.1%
    }, "Esperava IllegalArgumentException para porcentagem VIP acima de 30%.");
    assertEquals("A porcentagem de ingressos VIP deve estar entre 20% e 30%.", exception.getMessage());
  }

  @Test
  void criaLoteIngressoComPorcentagemVipMenorQue20() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new LoteIngresso(1, 500, 10.0, 25, 19.9); // Desconto de 25.1%
    }, "Esperava IllegalArgumentException para porcentagem VIP abaixo de 20%.");
    assertEquals("A porcentagem de ingressos VIP deve estar entre 20% e 30%.", exception.getMessage());
  }

  @Test
  void testaSeIngressosForamCriadosComSucessoDentroDoLote() {
    int quantidadeIngressosCriados = loteIngresso.getIngressos().size();
    assertEquals(500, quantidadeIngressosCriados, "A quantidade de ingressos criados não está correta.");
  }

  @Test
  void verificaValorIngressoNormal() {
    Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL, StatusIngresso.NA0_VENDIDO);
    assertEquals(9.00, loteIngresso.calculaPrecoComDesconto(ingresso), "O preço do ingresso normal não está correto.");
  }

  @Test
  void verificaValorIngressoVip() {
    Ingresso ingresso = new Ingresso(1, TipoIngresso.VIP, StatusIngresso.NA0_VENDIDO);
    assertEquals(18.00, loteIngresso.calculaPrecoComDesconto(ingresso), "O preço do ingresso normal não está correto.");
  }

  @Test
  void verificaValorIngressoMeia() {
    Ingresso ingresso = new Ingresso(1, TipoIngresso.MEIA_ENTRADA, StatusIngresso.NA0_VENDIDO);

    assertEquals(5.00, loteIngresso.calculaPrecoComDesconto(ingresso), "O preço do ingresso normal não está correto.");
  }
}
