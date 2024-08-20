package sistemaDeIngressos.functionalTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesteStatusFinanceiro {

    @Test
    void testStatusFinanceiro_Lucro() {
        double receita = 5000;
        double despesas = 3000;
        assertEquals("LUCRO", calcularStatusFinanceiro(receita, despesas));
    }

    @Test
    void testStatusFinanceiro_Estavel() {
        double receita = 3000;
        double despesas = 3000;
        assertEquals("ESTÁVEL", calcularStatusFinanceiro(receita, despesas));
    }

    @Test
    void testStatusFinanceiro_Prejuizo() {
        double receita = 2000;
        double despesas = 3000;
        assertEquals("PREJUÍZO", calcularStatusFinanceiro(receita, despesas));
    }

    private String calcularStatusFinanceiro(double receita, double despesas) {
        double receitaLiquida = receita - despesas;
        if (receitaLiquida > 0) {
            return "LUCRO";
        } else if (receitaLiquida == 0) {
            return "ESTÁVEL";
        } else {
            return "PREJUÍZO";
        }
    }
}

