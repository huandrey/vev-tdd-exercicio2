package processadorDeContas.pagamento;

import java.time.LocalDate;

public class PagamentoCartaoDeCredito extends Pagamento {
  public PagamentoCartaoDeCredito(double valorPago, LocalDate data) {
    super(valorPago, data);
  }

  @Override
  public boolean isValidoParaInclusao(LocalDate dataFatura) {
    LocalDate dataFaturaMinus15Days = dataFatura.minusDays(15);
    return data.isEqual(dataFaturaMinus15Days) || data.isBefore(dataFaturaMinus15Days);
  }
}