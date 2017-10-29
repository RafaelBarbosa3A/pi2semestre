package br.com.calçados.validadores;

import br.com.calçados.Venda.Venda;
import br.com.calçados.exception.VendaException;

public class ValidadorVenda {

    public static void validar(Venda venda) throws VendaException {
        if (venda == null) {
            throw new VendaException("Nenhuma informação encontrada "
                    + "sobre o cliente");
        }
        if (venda.getClienteID() < 0) {
            throw new VendaException("Cliente não encontrado");
        }
        if (venda.getTotal() <= 0) {
            throw new VendaException("Venda sem total");
        }
        if (venda.getData() == null) {
            throw new VendaException("Data não encontrada/Invalida");
        }
    }
}
