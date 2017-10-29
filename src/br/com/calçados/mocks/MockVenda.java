package br.com.calçados.mocks;

import br.com.calçados.Venda.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockVenda {

    private static int totalVenda = 0;
    private static List<Venda> listaVenda = new ArrayList<Venda>();

    public static void inserir(Venda venda)
            throws Exception {
        venda.setID(totalVenda++);
        listaVenda.add(venda);
    }

    public static List<Venda> relatorio(Date dataInicial, Date dataFinal)
            throws Exception {
        List<Venda> relatorio = new ArrayList<Venda>();
        if (dataInicial != null && dataFinal != null && !listaVenda.isEmpty()) {
            for (Venda venda : listaVenda) {
                if (venda != null && venda.getTotal() > 0) {
                    if (venda.getData().after(dataInicial) && venda.getData().before(dataFinal)) {
                        relatorio.add(venda);
                    } else if (venda.getData().equals(dataInicial) || venda.getData().equals(dataFinal)) {
                        relatorio.add(venda);
                    }
                }
            }
        }
        return relatorio;
    }
}
