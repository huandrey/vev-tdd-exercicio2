
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import processadorDeContas.ProcessadorDeContas;
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

        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        Conta conta01 = new Conta("001", contaDate, 500.00);
        conta01.setPagamento(new PagamentoBoleto(conta01, contaDate));
        fatura.adicionaConta(conta01);

        Conta conta02 = new Conta("002", contaDate, 400.00);
        conta02.setPagamento(new PagamentoBoleto(conta02, faturaDate));
        fatura.adicionaConta(conta02);

        Conta conta03 = new Conta("003", contaDate, 600.00);
        conta03.setPagamento(new PagamentoBoleto(conta03, faturaDate));
        fatura.adicionaConta(conta03);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void testFaturaPendente() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        Conta conta01 = new Conta("001", contaDate, 800.00);
        conta01.setPagamento(new PagamentoCartaoDeCredito(conta01, LocalDate.of(2023, 2, 5)));

        fatura.adicionaConta(conta01);

        Conta conta02 = new Conta("002", contaDate, 700.00);
        conta02.setPagamento(new PagamentoTransferenciaBancaria(conta02, LocalDate.of(2023, 2, 17)));
        fatura.adicionaConta(conta02);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void testFaturaPendentePorCartaoCredito() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        Conta conta01 = new Conta("001", contaDate, 800.00);
        conta01.setPagamento(new PagamentoCartaoDeCredito(conta01, LocalDate.of(2023, 2, 6)));

        fatura.adicionaConta(conta01);

        Conta conta02 = new Conta("002", contaDate, 700.00);
        conta02.setPagamento(new PagamentoTransferenciaBancaria(conta02, LocalDate.of(2023, 2, 17)));
        fatura.adicionaConta(conta02);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals("PENDENTE", fatura.getStatus());
    }
}
