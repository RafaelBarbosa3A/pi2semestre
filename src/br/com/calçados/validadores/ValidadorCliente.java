package br.com.calçados.validadores;

import br.com.calçados.exception.ClienteException;
import br.com.calçados.cliente.Cliente;

public class ValidadorCliente {

    public static void validar(Cliente cliente) throws ClienteException {
        if (cliente == null) {
            throw new ClienteException("Nenhuma informação encontrada "
                    + "sobre o cliente");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("Nome não digitado/Encontrado");
        }
        if (cliente.getSobrenome() == null || "".equals(cliente.getSobrenome())) {
            throw new ClienteException("Sobrenome não digitado/Encontrado");
        }
        if (cliente.getCPF() == 0) {
            throw new ClienteException("CPF não digitado/Invalido");
        }
        if (cliente.getSexo() == null || "".equals(cliente.getSexo())
                || (!cliente.getSexo().equals("Masculino"))
                && !cliente.getSexo().equals("Feminino")) {
            throw new ClienteException("Sexo não selecionado");
        }
    }
}
