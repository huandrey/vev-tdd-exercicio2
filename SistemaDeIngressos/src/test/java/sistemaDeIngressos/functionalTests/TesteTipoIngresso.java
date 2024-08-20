package sistemaDeIngressos.functionalTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteTipoIngresso {

    @Test
    void testeTipoIngressoValido() {
        String tipoIngresso = "VIP";
        assertTrue(verificaTipoIngressoValido(tipoIngresso));

        tipoIngresso = "NORMAL";
        assertTrue(verificaTipoIngressoValido(tipoIngresso));

        tipoIngresso = "MEIA_ENTRADA";
        assertTrue(verificaTipoIngressoValido(tipoIngresso));
    }

    @Test
    void testeTipoIngressoInvalido() {
        String tipoIngresso = "PROMOCIONAL";
        assertFalse(verificaTipoIngressoValido(tipoIngresso));
    }

    private boolean verificaTipoIngressoValido(String tipoIngresso) {
        return tipoIngresso.equals("VIP") || tipoIngresso.equals("NORMAL") || tipoIngresso.equals("MEIA_ENTRADA");
    }
}
