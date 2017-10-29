package br.com.calçados.db.dao;

import br.com.calçados.db.utils.ConnectionUtils;
import br.com.calçados.produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

    public static void inserir(Produto produto)
            throws SQLException, Exception {
        String sql = "INSERT INTO produto (codigo_barra, modelo, marca, tamanho, cor, disponibilidade, preco_unitario, enabled)"
                + "VALUES ((NEXT VALUE FOR codigo_barra), ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setString(2, produto.getMarca());
            preparedStatement.setInt(3, produto.getTamanho());
            preparedStatement.setString(4, produto.getCor());
            preparedStatement.setInt(5, produto.getSaldo());
            preparedStatement.setDouble(6, produto.getPreco());
            preparedStatement.setBoolean(7, true);

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

    public static void atualizar(Produto produto)
            throws SQLException, Exception {
        String sql = "UPDATE produto SET codigo_barra=?, modelo=?, marca=?, tamanho=?, cor=?, disponibilidade=?, preco_unitario=?"
                + "WHERE (calcado_id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getModelo());
            preparedStatement.setString(3, produto.getMarca());
            preparedStatement.setInt(4, produto.getTamanho());
            preparedStatement.setString(5, produto.getCor());
            preparedStatement.setInt(6, produto.getSaldo());
            preparedStatement.setDouble(7, produto.getPreco());
            preparedStatement.setInt(8, produto.getId());

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

    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE produto SET enabled=? WHERE (calcado_id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

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

    public static List<Produto> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM produto WHERE enabled=?";
        List<Produto> listaProdutos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("calcado_id"));
                produto.setCodigo(result.getInt("codigo_barra"));
                produto.setModelo(result.getString("modelo"));
                produto.setMarca(result.getString("marca"));
                produto.setTamanho(result.getInt("tamanho"));
                produto.setCor(result.getString("cor"));
                produto.setSaldo(result.getInt("disponibilidade"));
                produto.setPreco(result.getDouble("preco_unitario"));
                listaProdutos.add(produto);
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
        return listaProdutos;
    }

    public static List<Produto> procurar(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE (codigo_barra=? AND enabled=?)";

        List<Produto> listaProdutos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("calcado_id"));
                produto.setCodigo(result.getInt("codigo_barra"));
                produto.setModelo(result.getString("modelo"));
                produto.setMarca(result.getString("marca"));
                produto.setTamanho(result.getInt("tamanho"));
                produto.setCor(result.getString("cor"));
                produto.setSaldo(result.getInt("disponibilidade"));
                produto.setPreco(result.getDouble("preco_unitario"));
                listaProdutos.add(produto);
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
        return listaProdutos;
    }

    public static Produto obter(Integer id)
            throws SQLException, Exception {
        String sql = "SELECT * FROM produto WHERE calcado_id=? AND enabled=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("calcado_id"));
                produto.setCodigo(result.getInt("codigo_barra"));
                produto.setModelo(result.getString("modelo"));
                produto.setMarca(result.getString("marca"));
                produto.setTamanho(result.getInt("tamanho"));
                produto.setCor(result.getString("cor"));
                produto.setSaldo(result.getInt("disponibilidade"));
                produto.setPreco(result.getDouble("preco_unitario"));

                return produto;
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

        return null;
    }
    
    public static int Codigo()
            throws SQLException, Exception{
        String sql = "SELECT COUNT(codigo_barra)AS contador FROM produto";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();
            
            if (result.next()) {
                return result.getInt("contador");
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
        return 0;
    }
}
