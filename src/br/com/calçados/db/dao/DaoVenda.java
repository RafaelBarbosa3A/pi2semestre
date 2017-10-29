package br.com.calçados.db.dao;

import br.com.calçados.Venda.Venda;
import br.com.calçados.db.utils.ConnectionUtils;
import br.com.calçados.produto.ItemVenda;
import br.com.calçados.produto.Produto;
import br.com.calçados.service.ServicoProduto;
import br.com.calçados.service.ServicoVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoVenda {

    public static void inserir(Venda venda)
            throws SQLException, Exception {
        String sql = "INSERT INTO venda (data_venda, total_venda, cliente_ID) "
                + "VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Timestamp t = new Timestamp(venda.getData().getTime());
            preparedStatement.setTimestamp(1, t);
            preparedStatement.setDouble(2, venda.getTotal());
            preparedStatement.setLong(3, venda.getClienteID());

            preparedStatement.execute();

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void inserirItem(List<ItemVenda> itemVenda)
            throws SQLException, Exception {
        String sql = "INSERT INTO itemVenda (venda_id, calcado_id, quantidade, total_produto)"
                + "VALUES (?, ?, ?, ?)";
        for (ItemVenda item : itemVenda) {
            int a = item.getVenda();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = ConnectionUtils.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, item.getVenda());
                preparedStatement.setInt(2, item.getProduto());
                preparedStatement.setInt(3, item.getQuant());
                preparedStatement.setDouble(4, item.getTotal());

                preparedStatement.execute();
            } finally {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
        }
    }

    public static List<Venda> relatorio(Date dataInicio, Date dataFim)
            throws SQLException, Exception {
        String sql = "SELECT * FROM venda WHERE data_venda BETWEEN ? AND ? ";
        List<Venda> relatorio = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Timestamp t1 = new Timestamp(dataInicio.getTime());
            preparedStatement.setTimestamp(1, t1);
            Timestamp t2 = new Timestamp(dataFim.getTime());
            preparedStatement.setTimestamp(2, t2);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (relatorio == null) {
                    relatorio = new ArrayList<Venda>();
                }
                Venda venda = new Venda();
                venda.setID(result.getInt("venda_id"));
                Date d = new Date(result.getTimestamp("data_venda").getTime());
                venda.setData(d);
                venda.setTotal(result.getDouble("total_venda"));
                venda.setClienteID(result.getInt("cliente_id"));
                relatorio.add(venda);
            }

        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return relatorio;
    }

    public static void Codigo(List<ItemVenda> itemVenda)
            throws SQLException, Exception {
        String sql = "SELECT venda_id FROM venda ORDER BY venda_id DESC FETCH FIRST ROW ONLY";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                int i = 0;
                for(ItemVenda item : itemVenda){
                    item.setVenda(result.getInt("venda_id"));
                    itemVenda.set(i, item);
                }
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return;
    }

    public static List<String> produtos(int venda)
            throws SQLException, Exception {
        String sql = "SELECT * FROM itemVenda WHERE venda_id=?";
        List<String> produtos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (produtos == null) {
                    produtos = new ArrayList<String>();
                }
                Produto p = ServicoProduto.obterProduto(result.getInt("calcado_id"));
                String produto = "Codigo: " + p.getCodigo()
                        + " || Marca: " + p.getMarca()
                        + " || Tamanho " + p.getTamanho()
                        + " || Quantidade " + result.getInt("quantidade")
                        + " || Preco: R$" + result.getDouble("total_produto")
                        + "\n";
                String pafa= produto;
                produtos.add(produto);
            }
            
            return produtos;
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
