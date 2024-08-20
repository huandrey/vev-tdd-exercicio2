package processadorDeContas.functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import processadorDeContas.ProcessadorDeContas;
import processadorDeContas.entities.Conta;
import processadorDeContas.entities.Fatura;
import processadorDeContas.entities.StatusFatura;
import processadorDeContas.entities.pagamento.PagamentoBoleto;
import processadorDeContas.entities.pagamento.PagamentoCartaoDeCredito;
import processadorDeContas.entities.pagamento.PagamentoTransferenciaBancaria;

public class ProcessadorDeContasTest {
    LocalDate faturaDate = LocalDate.of(2023, 2, 20);

    @Test
    public void testFaturaPaga() {

        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        Conta conta01 = new Conta("001", faturaDate, 500.00);
        conta01.setPagamento(new PagamentoBoleto(conta01));
        fatura.adicionaConta(conta01);

        Conta conta02 = new Conta("002", faturaDate, 400.00);
        conta02.setPagamento(new PagamentoBoleto(conta02));
        fatura.adicionaConta(conta02);

        Conta conta03 = new Conta("003", faturaDate, 600.00);
        conta03.setPagamento(new PagamentoBoleto(conta03));
        fatura.adicionaConta(conta03);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals(StatusFatura.PAGA, fatura.getStatus());
    }

    @Test
    public void testFaturaPagaPorCartaoDeCredito() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        LocalDate conta01Date = LocalDate.of(2023, 2, 5);
        Conta conta01 = new Conta("001", conta01Date, 800.00);
        conta01.setPagamento(new PagamentoCartaoDeCredito(conta01));
        fatura.adicionaConta(conta01);

        LocalDate conta02Date = LocalDate.of(2023, 2, 17);
        Conta conta02 = new Conta("002", conta02Date, 700.00);
        conta02.setPagamento(new PagamentoTransferenciaBancaria(conta02));
        fatura.adicionaConta(conta02);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals(StatusFatura.PAGA, fatura.getStatus());
    }

    @Test
    public void testFaturaPendentePorCartaoCredito() {
        Fatura fatura = new Fatura(faturaDate, 1500.00, "Cliente A");

        LocalDate conta01Date = LocalDate.of(2023, 2, 6);
        Conta conta01 = new Conta("001", conta01Date, 800.00);
        conta01.setPagamento(new PagamentoCartaoDeCredito(conta01));

        fatura.adicionaConta(conta01);

        LocalDate conta02Date = LocalDate.of(2023, 2, 17);
        Conta conta02 = new Conta("002", conta02Date, 700.00);
        conta02.setPagamento(new PagamentoTransferenciaBancaria(conta02));
        fatura.adicionaConta(conta02);

        ProcessadorDeContas processador = new ProcessadorDeContas();
        processador.processar(fatura);

        assertEquals(StatusFatura.PENDENTE, fatura.getStatus());
    }
}
