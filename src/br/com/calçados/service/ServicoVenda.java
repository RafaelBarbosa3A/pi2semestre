package br.com.calçados.service;

import br.com.calçados.Venda.Venda;
import br.com.calçados.db.dao.DaoVenda;
import br.com.calçados.exception.DataSourceException;
import br.com.calçados.exception.VendaException;
import br.com.calçados.produto.ItemVenda;
import br.com.calçados.validadores.ValidadorItem;
import br.com.calçados.validadores.ValidadorVenda;
import java.util.Date;
import java.util.List;

public class ServicoVenda {

    public static void cadastrarVenda(Venda venda, List<ItemVenda> item)
            throws VendaException,
            DataSourceException {

        ValidadorVenda.validar(venda);
        ValidadorItem.validar(item);

        try {
            DaoVenda.inserir(venda);
            DaoVenda.Codigo(item);
            DaoVenda.inserirItem(item);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static List<Venda> criarRelatorio(Date dataInicial, Date dataFinal)
            throws VendaException, DataSourceException {
        try {
            if (dataInicial != null && dataFinal != null) {
                return DaoVenda.relatorio(dataInicial, dataFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
        return null;
    }

    public static List<String> obterProdutos(Venda venda)
            throws VendaException, DataSourceException {
        try {
            return DaoVenda.produtos(venda.getID());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
