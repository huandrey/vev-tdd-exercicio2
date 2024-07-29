
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import processadorDeContas.entities.Conta;
import processadorDeContas.entities.Fatura;
import processadorDeContas.entities.pagamento.PagamentoBoleto;
import processadorDeContas.entities.pagamento.PagamentoCartaoDeCredito;
import processadorDeContas.entities.pagamento.PagamentoTransferenciaBancaria;

public class ProcessadorDeContasTest {
    LocalDate faturaDate = LocalDate.of(2023, 2, 20);
    LocalDate contaDate = LocalDate.of(2023, 2, 01);

    @Test
    public void testFaturaPaga() {
        LocalDate faturaDate =;

        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        fatura.adicionaConta(new Conta("001", contaDate, 500.00, new PagamentoBoleto(500, faturaDate)));

        fatura.adicionaConta(new Conta("002", contaDate, 400.00, new PagamentoBoleto(400, faturaDate)));

        fatura.adicionaConta(new Conta("003", contaDate, 600.00, new PagamentoBoleto(600, faturaDate)));

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void testFaturaPendente() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        fatura.adicionaConta(
                new Conta("001", contaDate, 500.00, new PagamentoCartaoDeCredito(700, LocalDate.of(2023, 2, 5))));

        fatura.adicionaConta(new Conta("002", contaDate, 400.00,
                new PagamentoTransferenciaBancaria(400, LocalDate.of(2023, 2, 17))));

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void testFaturaPendentePorCartaoCredito() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        fatura.adicionaConta(
                new Conta("001", contaDate, 700, new PagamentoCartaoDeCredito(700, LocalDate.of(2023, 2, 6))));

        fatura.adicionaConta(new Conta("002", contaDate, 400.00,
                new PagamentoTransferenciaBancaria(400, LocalDate.of(2023, 2, 17))));

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PENDENTE", fatura.getStatus());
    }
}
