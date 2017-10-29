package br.com.calçados.validadores;

import br.com.calçados.exception.VendaException;
import br.com.calçados.produto.ItemVenda;
import java.util.List;

public class ValidadorItem {

    public static void validar(List<ItemVenda> venda) throws VendaException {
        for (ItemVenda item : venda) {
            if (item == null) {
                throw new VendaException("Nenhuma informação encontrada "
                        + "sobre produtos");
            }
            if (item.getProduto() <= 0) {
                throw new VendaException("Produto não encontrado");
            }
            if (item.getVenda() !=0) {
                throw new VendaException("Nenhuma venda");
            }

            if (item.getQuant() <= 0) {
                throw new VendaException("Nenhuma Quantidade");
            }
            if (item.getTotal() <= 0) {
                throw new VendaException("Item sem total");
            }
        }
    }
}
