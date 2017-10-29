package br.com.calçados.service;

import br.com.calçados.cliente.Cliente;
import br.com.calçados.db.dao.DaoCliente;
import br.com.calçados.exception.ClienteException;
import br.com.calçados.exception.DataSourceException;
import br.com.calçados.exception.EnderecoException;
import br.com.calçados.validadores.ValidadorCliente;
import br.com.calçados.validadores.ValidadorEndereco;
import java.util.List;

public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente)
            throws ClienteException,
            DataSourceException,
            EnderecoException {

        ValidadorCliente.validar(cliente);
        ValidadorEndereco.validar(cliente);

        try {
            DaoCliente.inserir(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void atualizarCliente(Cliente cliente)
            throws ClienteException, DataSourceException, EnderecoException {

        ValidadorCliente.validar(cliente);
        ValidadorEndereco.validar(cliente);

        try {
            DaoCliente.atualizar(cliente);
            return;
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static Cliente obterCliente(int id)
            throws ClienteException, DataSourceException, EnderecoException {
        try {
            return DaoCliente.obter(id);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static Cliente obterClientePorCPF(String cpf)
            throws ClienteException, DataSourceException, EnderecoException {
        try {
            return DaoCliente.obterPorCPF(cpf);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void excluirCliente(Integer id)
            throws ClienteException, DataSourceException, EnderecoException {
        try {

            DaoCliente.excluir(id);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static List<Cliente> procurarCliente(String cpf)
            throws ClienteException, DataSourceException, EnderecoException {
        try {
            if (cpf != null && !"".equals(cpf)) {
                return DaoCliente.procurar(cpf);
            } else {
                return DaoCliente.listar();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
