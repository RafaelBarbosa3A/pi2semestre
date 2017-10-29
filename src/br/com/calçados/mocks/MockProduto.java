package br.com.calçados.mocks;

import br.com.calçados.produto.Produto;
import java.util.ArrayList;
import java.util.List;

public final class MockProduto {

    private MockProduto() {
    }
    
    public static int codigo = 1;
    public static int totalProduto = 0;
    private final static List<Produto> LISTA_PRODUTO = new ArrayList();

    public static int obterCodigo(){
        return codigo;
    }
    
    public static void inserir(Produto produto)
            throws Exception {
        produto.setId(totalProduto);
        produto.setCodigo(codigo);
        LISTA_PRODUTO.add(produto);
        totalProduto++;
        codigo++;
    }

    public static void atualizar(Produto produtoProcura) {

        if ((produtoProcura != null) && (produtoProcura.getId() >= 0) && (!LISTA_PRODUTO.isEmpty())) {
            for (Produto produtoLi : LISTA_PRODUTO) {
                if ((produtoLi != null) && (produtoLi.getId() == produtoProcura.getId())) {
                    produtoLi.setCor(produtoProcura.getCor());
                    produtoLi.setMarca(produtoProcura.getMarca());
                    produtoLi.setModelo(produtoProcura.getModelo());
                    produtoLi.setPreco(produtoProcura.getPreco());
                    produtoLi.setSaldo(produtoProcura.getSaldo());
                    produtoLi.setTamanho(produtoProcura.getTamanho());
                    break;
                }
            }
        }
    }

    public static List<Produto> listar() throws Exception {
        return LISTA_PRODUTO;
    }

    public static List<Produto> procurar(String itemBuscado) throws Exception {
        List<Produto> listaResultadoProduto = new ArrayList<>();

        boolean isNumber = itemBuscado.matches("^[0-9]+");
        boolean isDecimal = itemBuscado.matches("^(?:[1-9](?:[\\d]{0,2}(?:\\.[\\d]{3})*|[\\d]+)|0)(?:,[\\d]{0,2})?$");
        boolean isString = !isNumber && !isDecimal;

        if (itemBuscado != null && !LISTA_PRODUTO.isEmpty()) {

            for (Produto produtoLi : LISTA_PRODUTO) {
                if (itemBuscado != null && !LISTA_PRODUTO.isEmpty()) {

                    if (isNumber) {
                        if ((produtoLi.getId() == Integer.parseInt(itemBuscado)) || (produtoLi.getSaldo() == Integer.parseInt(itemBuscado))
                                || (produtoLi.getTamanho() == Integer.parseInt(itemBuscado))) {
                            listaResultadoProduto.add(produtoLi);
                        }
                    } else if (isDecimal) {
                        if ((produtoLi.getPreco() == Double.parseDouble(itemBuscado))) {
                            listaResultadoProduto.add(produtoLi);
                        }
                    } else {
                        if ((produtoLi.getCor().equalsIgnoreCase(itemBuscado)) || (produtoLi.getMarca().equalsIgnoreCase(itemBuscado))
                                || (produtoLi.getModelo().equalsIgnoreCase(itemBuscado))) {
                            listaResultadoProduto.add(produtoLi);
                        }
                    }
                }
            }
        }
        return listaResultadoProduto;
    }

    public static void excluir(Integer id) throws Exception {
        if (id != null && !LISTA_PRODUTO.isEmpty()) {
            for (int i = 0; i < LISTA_PRODUTO.size(); i++) {
                Produto produtoLi = LISTA_PRODUTO.get(i);
                if (produtoLi != null && produtoLi.getId() == id) {
                    LISTA_PRODUTO.remove(i);
                    break;
                }
            }
        }
    }

    public static Produto obter(Integer codigo)//String modelo, int tamanho
            throws Exception {
        if (codigo != null && !LISTA_PRODUTO.isEmpty()) {
            for (int i = 0; i < LISTA_PRODUTO.size(); i++) {
                if (LISTA_PRODUTO.get(i) != null && LISTA_PRODUTO.get(i).getCodigo() == codigo) {
                    return LISTA_PRODUTO.get(i);
                }
            }
        }
        return null;
    }

}
