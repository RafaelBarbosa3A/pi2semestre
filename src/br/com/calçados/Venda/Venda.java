package br.com.calçados.Venda;

import java.util.Date;

public class Venda {

    private int ID;
    private Date data;
    private double total;
    private int clienteID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return this.data;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return this.total;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getClienteID() {
        return this.clienteID;
    }
}
