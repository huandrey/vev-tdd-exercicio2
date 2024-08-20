package sistemaDeIngressos.functionalTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteDistribuicaoIngressos {

    @Test
    void testeDistribuicaoCorreta_1() {
        int vip = 20;
        int meiaEntrada = 10;
        int normal = 70;
        assertTrue(verificaDistribuicaoCorreta(vip, meiaEntrada, normal));
    }

    @Test
    void testeDistribuicaoCorreta_2() {
        int vip = 30;
        int meiaEntrada = 10;
        int normal = 60;
        assertTrue(verificaDistribuicaoCorreta(vip, meiaEntrada, normal));
    }

    @Test
    void testeErroDistribuicao_3() {
        int vip = 19;
        int meiaEntrada = 10;
        int normal = 71;
        assertFalse(verificaDistribuicaoCorreta(vip, meiaEntrada, normal));
    }

    @Test
    void testeErroDistribuicao_4() {
        int vip = 31;
        int meiaEntrada = 10;
        int normal = 59;
        assertFalse(verificaDistribuicaoCorreta(vip, meiaEntrada, normal));
    }

    @Test
    void testeErroDistribuicao_5() {
        int vip = 25;
        int meiaEntrada = 0;
        int normal = 75;
        assertFalse(verificaDistribuicaoCorreta(vip, meiaEntrada, normal));
    }

    private boolean verificaDistribuicaoCorreta(int vip, int meiaEntrada, int normal) {
      return (vip + meiaEntrada + normal) == 100 
      && (vip >= 20 && vip <= 30) 
      && meiaEntrada == 10;
    }
}
