package br.com.calçados.validadores;

import br.com.calçados.exception.ProdutoException;
import br.com.calçados.produto.Produto;

public class ValidadorProduto {

    public static void validar(Produto produto) throws ProdutoException {
        if ((produto.getModelo() == null) || "".equals(produto.getModelo())) {
            throw new ProdutoException("Modelo não digitado/Encontrado");
        }
        if ((produto.getCor() == null) || (produto.getCor().equals(""))) {
            throw new ProdutoException("Cor não digitado/Encontrado");
        }
        if ((produto.getMarca() == null) || (produto.getMarca().equals(""))) {
            throw new ProdutoException("Marca não digitado/Encontrado");
        }
        if ((produto.getSaldo() <= 0)) {
            throw new ProdutoException("Saldo não digitado/ Ou invalido");
        }
        if (produto.getPreco() <= 0) {
            throw new ProdutoException("Preço não digitado/ Ou invalido");
        }
        try {
            Integer.parseInt(String.valueOf(produto.getTamanho()));
        } catch (Exception e) {
            //throw new ProdutoException("Tamanho deve ser numérico");

        }
        if ((produto.getTamanho() <= 0) || (produto.getTamanho() > 100)) {
            throw new ProdutoException("Tamanho não digitado/ Ou invalido");
        }

        if (produto.getId() < 0) {
            throw new ProdutoException("ID não invalido");
        }
    }
}
