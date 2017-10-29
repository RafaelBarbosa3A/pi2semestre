package br.com.calçados.validadores;

import br.com.calçados.exception.EnderecoException;
import br.com.calçados.cliente.Cliente;

public class ValidadorEndereco {

    public static void validar(Cliente cliente) throws EnderecoException {
        if (cliente == null) {
            throw new EnderecoException("Nenhuma informação encontrada "
                    + "sobre o cliente");
        }
        if (cliente.getEndereço() == null || "".equals(cliente.getEndereço())) {
            throw new EnderecoException("Endereço não digitado/Invalido");
        }
        if (cliente.getNumero() == 0 || cliente.getNumero()<0) {
            throw new EnderecoException("Numero não digitado/Invalido");
        }
    }
}
