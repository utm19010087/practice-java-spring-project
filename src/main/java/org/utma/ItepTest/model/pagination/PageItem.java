package org.utma.ItepTest.model.pagination;

public class PageItem
{
    private int numero;
    private boolean actual;
    public PageItem(int numero, boolean actual)
    {
        this.numero = numero;
        this.actual = actual;
    }

    public int getNumero() {return numero;}

    public boolean isActual() {
        return actual;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
