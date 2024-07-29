package processadorDeContas;

import processadorDeContas.entities.Conta;
import processadorDeContas.entities.Fatura;
import processadorDeContas.entities.pagamento.Pagamento;

public class ProcessadorDeContas {
  public ProcessadorDeContas() {
  }

  public void processar(Fatura fatura) {

    double totalPago = 0;
    for (Conta conta : fatura.getContas()) {
      Pagamento pagamento = conta.getPagamento();

      if (pagamento != null) {
        if (pagamento.isValidoParaInclusao(conta.getData(), fatura.getData())) {
          totalPago += pagamento.getValorPago();
        }
        ;
      }
    }
  }

}
