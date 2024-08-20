package sistemaDeIngressos.functionalTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteDescontoIngressos {

    @Test
    void testeDescontoValido_1() {
        int desconto = 0;
        assertTrue(verificaDescontoValido(desconto));
    }

    @Test
    void testeDescontoValido_2() {
        int desconto = 25;
        assertTrue(verificaDescontoValido(desconto));
    }

    @Test
    void testeDescontoValido_3() {
        int desconto = 25;
        String tipoIngresso = "NORMAL";
        assertTrue(verificaDescontoValido(desconto, tipoIngresso));
    }

    @Test
    void testeErroDesconto_3() {
        int desconto = 26;
        assertFalse(verificaDescontoValido(desconto));
    }

    private boolean verificaDescontoValido(int desconto) {
        return desconto >= 0 && desconto <= 25;
    }

    private boolean verificaDescontoValido(int desconto, String tipoIngresso) {
      if (desconto < 0 || desconto > 25) {
          return false;
      }
      if (tipoIngresso.equals("VIP") || tipoIngresso.equals("NORMAL")) {
          return desconto <= 25;
      }
      return desconto == 0; // Meia Entrada não deve ter desconto
  }
}
