package br.com.calçados.produto;

public class ItemVenda {

    private int idProduto;
    private int idVenda;
    private int quant;
    private double totalProduto = 0.00d;

    public void setProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getProduto() {
        return this.idProduto;
    }

    public void setVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getVenda() {
        return this.idVenda;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return this.quant;
    }

    public void setTotal(double totalProduto) {
        this.totalProduto = totalProduto;
    }

    public double getTotal() {
        return this.totalProduto;
    }
}
