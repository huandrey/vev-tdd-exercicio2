package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

import processadorDeContas.entities.Conta;

public class PagamentoCartaoDeCredito extends Pagamento {
  public PagamentoCartaoDeCredito(Conta conta) {
    super(conta);
  }

  public PagamentoCartaoDeCredito(Conta conta, LocalDate data) {
    super(conta, data);
  }

  @Override
  public boolean isValidoParaInclusao(LocalDate dataConta, LocalDate dataFatura) {
    LocalDate dataFaturaMinus15Days = dataFatura.minusDays(15);
    return dataConta.isEqual(dataFaturaMinus15Days) || dataConta.isBefore(dataFaturaMinus15Days);
  }
}