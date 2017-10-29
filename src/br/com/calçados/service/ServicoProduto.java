package br.com.calçados.service;

import br.com.calçados.db.dao.DaoProduto;
import br.com.calçados.exception.DataSourceException;
import br.com.calçados.exception.ProdutoException;
import br.com.calçados.produto.Produto;
import br.com.calçados.validadores.ValidadorProduto;
import java.util.List;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto)
            throws ProdutoException, DataSourceException {

        ValidadorProduto.validar(produto);

        try {
            DaoProduto.inserir(produto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }

    }

    public static void atualizarProduto(Produto produto)
            throws ProdutoException, DataSourceException {

        ValidadorProduto.validar(produto);

        try {
            DaoProduto.atualizar(produto);
            return;
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static Produto obterProduto(Integer codigo)//
            throws ProdutoException, DataSourceException {
        try {

            return DaoProduto.obter(codigo);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void excluirProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {

            DaoProduto.excluir(id);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static List<Produto> procurarProduto(int id)
            throws ProdutoException, DataSourceException {
        try {
            if (id == 0 || "".equals(id)) {
                return DaoProduto.listar();
            } else {
                return DaoProduto.procurar(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    public static int Codigo()
            throws ProdutoException, DataSourceException{
        try {
            return DaoProduto.Codigo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
