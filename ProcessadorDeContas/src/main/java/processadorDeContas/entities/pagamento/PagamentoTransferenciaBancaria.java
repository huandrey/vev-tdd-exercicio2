package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

import processadorDeContas.entities.Conta;

public class PagamentoTransferenciaBancaria extends Pagamento {
  public PagamentoTransferenciaBancaria(Conta conta) {
    super(conta);
  }

  public PagamentoTransferenciaBancaria(Conta conta, LocalDate data) {
    super(conta, data);
  }
}