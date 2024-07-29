package processadorDeContas.entities.pagamento;

import java.time.LocalDate;

public class PagamentoCartaoDeCredito extends Pagamento {
  public PagamentoCartaoDeCredito(double valorPago, LocalDate data) {
    super(valorPago, data);
  }

  @Override
  public boolean isValidoParaInclusao(LocalDate dataConta, LocalDate dataFatura) {
    LocalDate dataFaturaMinus15Days = dataFatura.minusDays(15);
    return dataConta.isEqual(dataFaturaMinus15Days) || dataConta.isBefore(dataFaturaMinus15Days);
  }
}