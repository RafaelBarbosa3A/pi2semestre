package br.com.calçados.db.dao;

import br.com.calçados.cliente.Cliente;
import br.com.calçados.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {

    public static void inserir(Cliente cliente)
            throws SQLException, Exception {
        String sql = "INSERT INTO cliente (nome, sobrenome, rg, cpf, sexo, "
                + "telefone, email, endereco, numero, complemento, cep, bairro, cidade, estado, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setInt(3, cliente.getRG());
            preparedStatement.setDouble(4, cliente.getCPF());
            preparedStatement.setString(5, cliente.getSexo());
            preparedStatement.setInt(6, cliente.getTelefone());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getEndereço());
            preparedStatement.setInt(9, cliente.getNumero());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setInt(11, cliente.getCEP());
            preparedStatement.setString(12, cliente.getBairro());
            preparedStatement.setString(13, cliente.getCidade());
            preparedStatement.setString(14, cliente.getEstado());
            preparedStatement.setBoolean(15, true);

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

    public static void atualizar(Cliente cliente)
            throws SQLException, Exception {
        String sql = "UPDATE cliente SET nome=?, sobrenome=?, rg=?, cpf=?, sexo=?, "
                + "telefone=?, email=?, endereco=?, numero=?, complemento=?, cep=?, bairro=?, cidade=?, estado=?"
            + "WHERE (cliente_id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setInt(3, cliente.getRG());
            preparedStatement.setDouble(4, cliente.getCPF());
            preparedStatement.setString(5, cliente.getSexo());
            preparedStatement.setInt(6, cliente.getTelefone());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getEndereço());
            preparedStatement.setInt(9, cliente.getNumero());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setInt(11, cliente.getCEP());
            preparedStatement.setString(12, cliente.getBairro());
            preparedStatement.setString(13, cliente.getCidade());
            preparedStatement.setString(14, cliente.getEstado());
            preparedStatement.setInt(15, cliente.getID());

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

        String sql = "UPDATE cliente SET enabled=? WHERE (cliente_id=?)";
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
    
    public static List<Cliente> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM cliente WHERE (enabled=?)";        
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setID(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setRG(result.getInt("rg"));
                cliente.setCPF(result.getLong("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setTelefone(result.getInt("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setEndereço(result.getString("endereco"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setCEP(result.getInt("cep"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setEstado(result.getString("estado"));
                listaClientes.add(cliente);
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
        return listaClientes;
    }
    
    public static Cliente obter(int id)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM cliente WHERE (cliente_id=? AND enabled=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);            
            preparedStatement.setBoolean(2, true);
            
            result = preparedStatement.executeQuery();
            
            if (result.next()) {                
                Cliente cliente = new Cliente();
                cliente.setID(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setRG(result.getInt("rg"));
                cliente.setCPF(result.getLong("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setTelefone(result.getInt("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setEndereço(result.getString("endereco"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setCEP(result.getInt("cep"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setEstado(result.getString("estado"));
                
                return cliente;
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
    public static Cliente obterPorCPF(String cpf)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM cliente WHERE (cpf=? AND enabled=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(cpf));            
            preparedStatement.setBoolean(2, true);
            
            result = preparedStatement.executeQuery();
            
            if (result.next()) {                
                Cliente cliente = new Cliente();
                cliente.setID(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setRG(result.getInt("rg"));
                cliente.setCPF(result.getLong("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setTelefone(result.getInt("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setEndereço(result.getString("endereco"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setCEP(result.getInt("cep"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setEstado(result.getString("estado"));
                
                return cliente;
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
    
    
    public static List<Cliente> procurar(String cpf)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM cliente WHERE (cpf=? AND enabled=?)";
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Long c = Long.parseLong(cpf);
            preparedStatement.setLong(1, c);
            preparedStatement.setBoolean(2, true);
            
            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setID(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setRG(result.getInt("rg"));
                cliente.setCPF(result.getLong("cpf"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setTelefone(result.getInt("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setEndereço(result.getString("endereco"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setCEP(result.getInt("cep"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setEstado(result.getString("estado"));
                listaClientes.add(cliente);
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
        return listaClientes;        
    }
}
