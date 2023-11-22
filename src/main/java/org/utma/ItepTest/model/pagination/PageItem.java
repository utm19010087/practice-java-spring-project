package org.utma.ItepTest.model.pagination;
/**
 * La clase PageItem representa un elemento de paginación en una interfaz de usuario.
 *
 * <p>
 * Cada instancia de esta clase contiene información sobre un número de página y si es la página actual o no.
 * </p>
 *
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
public class PageItem
{
    /**
     * Número de página.
     */
    private int numero;
    /**
     * Indica si esta página es la página actual.
     */
    private boolean actual;
    /**
     * Constructor de la clase PageItem.
     *
     * @param numero El número de página.
     * @param actual Indica si esta página es la página actual.
     */
    public PageItem(int numero, boolean actual)
    {
        this.numero = numero;
        this.actual = actual;
    }
    /**
     * Obtiene el número de página.
     *
     * @return El número de página.
     */
    public int getNumero() {return numero;}
    /**
     * Indica si esta página es la página actual.
     *
     * @return true si es la página actual, false en caso contrario.
     */
    public boolean isActual() {
        return actual;
    }
    /**
     * Establece el número de página.
     *
     * @param numero El número de página a establecer.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Establece si esta página es la página actual.
     *
     * @param actual true si es la página actual, false en caso contrario.
     */
    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
