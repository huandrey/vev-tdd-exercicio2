package processadorDeContas.pagamento;

import java.time.LocalDate;

public class PagamentoTransferenciaBancaria extends Pagamento {
  public PagamentoTransferenciaBancaria(double valorPago, LocalDate data) {
    super(valorPago, data);
  }
}