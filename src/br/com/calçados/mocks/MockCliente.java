package br.com.calçados.mocks;

import br.com.calçados.cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public class MockCliente {

    private static int totalCliente = 0;
    private static List<Cliente> listaCliente = new ArrayList<Cliente>();

    public static void inserir(Cliente cliente)
            throws Exception {
        cliente.setID(totalCliente++);
        listaCliente.add(cliente);
    }

    public static void atualizar(Cliente clienteProcura)
            throws Exception {
        if (clienteProcura != null && clienteProcura.getID() >= 0 && !listaCliente.isEmpty()) {
            for (Cliente clienteLi : listaCliente) {
                if (clienteLi != null && clienteLi.getID() == clienteProcura.getID()) {
                    clienteLi.setRG(clienteProcura.getRG());
                    clienteLi.setCPF(clienteProcura.getCPF());
                    clienteLi.setSexo(clienteProcura.getSexo());
                    clienteLi.setTelefone(clienteProcura.getTelefone());
                    clienteLi.setEmail(clienteProcura.getEmail());
                    clienteLi.setNome(clienteProcura.getNome());
                    clienteLi.setSobrenome(clienteProcura.getSobrenome());
                    clienteLi.setEndereço(clienteProcura.getEndereço());
                    clienteLi.setNumero(clienteProcura.getNumero());
                    clienteLi.setCEP(clienteProcura.getCEP());
                    clienteLi.setBairro(clienteProcura.getBairro());
                    break;
                }
            }
        }
    }

    public static List<Cliente> listar()
            throws Exception {
        return listaCliente;
    }

    public static List<Cliente> procurar(String C)
            throws Exception {
        List<Cliente> listaResultado = new ArrayList<Cliente>();
        long cpf = 0;
        try {
            cpf = Long.parseLong(C);
        } catch (Exception e) {

        }
        if (C != null && !listaCliente.isEmpty()) {
            for (Cliente clienteLi : listaCliente) {
                if (clienteLi != null && clienteLi.getNome() != null
                        && clienteLi.getSobrenome() != null) {
                    if (clienteLi.getCPF() == cpf) {
                        listaResultado.add(clienteLi);
                    }
                }
            }
        }

        return listaResultado;
    }

    public static Cliente obter(String C)
            throws Exception {
        long cpf = 0;
        try {
            cpf = Long.parseLong(C);
        } catch (Exception e) {

        }
        if (cpf != 0 && !listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i) != null && listaCliente.get(i).getCPF() == cpf) {
                    return listaCliente.get(i);
                }
            }
        }
        return null;
    }

    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                Cliente clienteLi = listaCliente.get(i);
                if (clienteLi != null && clienteLi.getID() == id) {
                    listaCliente.remove(i);
                    break;
                }
            }
        }
    }
}
