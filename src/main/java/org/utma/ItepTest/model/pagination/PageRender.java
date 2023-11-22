package org.utma.ItepTest.model.pagination;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
/**
 * La clase PageRender proporciona funcionalidad para renderizar la paginación en una interfaz de usuario.
 *
 * <p>
 * Esta clase se utiliza para generar información sobre la paginación, como la página actual, el número total de páginas,
 * y las páginas disponibles para la navegación.
 * </p>
 *
 * @param <T> Tipo de elemento que contiene la página.
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
public class PageRender <T>
{
    /**
     * URL base para las páginas de la interfaz de usuario.
     */
    private String url;

    /**
     * Página actual.
     */
    private Page<T> page;
    /**
     * Número total de páginas.
     */
    private int totalPaginas;
    /**
     * Número de elementos por página.
     */
    private int numElementosPorPagina;
    /**
     * Página actual.
     */
    private int paginaActual;
    /**
     * Lista de objetos PageItem que representan las páginas disponibles para la navegación.
     */

    private List<PageItem> paginas;
    /**
     * Constructor de la clase PageRender.
     *
     * @param url  URL base para las páginas de la interfaz de usuario.
     * @param page Página actual de datos.
     */
    public PageRender(String url, Page<T> page)
    {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();
        numElementosPorPagina = 1;
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber()+1;
        int desde, hasta;
        if (totalPaginas <= numElementosPorPagina)
        {
            desde = 1;
            hasta = totalPaginas;
        } else {
            if (paginaActual <= numElementosPorPagina / 2)
            {
                desde = 1;
                hasta = numElementosPorPagina;
            } else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
                desde = totalPaginas - numElementosPorPagina + 1;
                hasta = numElementosPorPagina;
            } else {
                desde = paginaActual - numElementosPorPagina / 2;
                hasta = numElementosPorPagina;
            }
        }

        for (int i = 0; i < hasta; i++)
        {
            paginas.add(new PageItem(desde +i, paginaActual == desde+1));
        }
    }
    /**
     * Verifica si la página actual es la primera.
     *
     * @return true si la página actual es la primera, false en caso contrario.
     */
    public boolean isFirst(){return page.isFirst();}
    /**
     * Verifica si la página actual es la última.
     *
     * @return true si la página actual es la última, false en caso contrario.
     */
    public boolean isLast(){return page.isLast();}
    /**
     * Verifica si hay una página siguiente.
     *
     * @return true si hay una página siguiente, false en caso contrario.
     */
    public boolean isHasNext(){return page.hasNext();}
    /**
     * Verifica si hay una página anterior.
     *
     * @return true si hay una página anterior, false en caso contrario.
     */
    public boolean isHasPrevious(){return page.hasPrevious();}
    /**
     * Obtiene la URL base para las páginas de la interfaz de usuario.
     *
     * @return La URL base.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Establece la URL base para las páginas de la interfaz de usuario.
     *
     * @param url La URL base a establecer.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Obtiene la página actual de datos.
     *
     * @return La página actual de datos.
     */
    public Page<T> getPage() {
        return page;
    }
    /**
     * Establece la página actual de datos.
     *
     * @param page La página actual de datos a establecer.
     */
    public void setPage(Page<T> page) {
        this.page = page;
    }
    /**
     * Obtiene el número total de páginas.
     *
     * @return El número total de páginas.
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }
    /**
     * Establece el número total de páginas.
     *
     * @param totalPaginas El número total de páginas a establecer.
     */
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    /**
     * Obtiene el número de elementos por página.
     *
     * @return El número de elementos por página.
     */
    public int getNumElementosPorPagina() {
        return numElementosPorPagina;
    }
    /**
     * Establece el número de elementos por página.
     *
     * @param numElementosPorPagina El número de elementos por página a establecer.
     */
    public void setNumElementosPorPagina(int numElementosPorPagina) {
        this.numElementosPorPagina = numElementosPorPagina;
    }
    /**
     * Obtiene la página actual.
     *
     * @return La página actual.
     */
    public int getPaginaActual() {
        return paginaActual;
    }
    /**
     * Establece la página actual.
     *
     * @param paginaActual La página actual a establecer.
     */
    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    /**
     * Obtiene la lista de objetos PageItem que representan las páginas disponibles para la navegación.
     *
     * @return La lista de objetos PageItem.
     */
    public List<PageItem> getPaginas() {
        return paginas;
    }
    /**
     * Establece la lista de objetos PageItem que representan las páginas disponibles para la navegación.
     *
     * @param paginas La lista de objetos PageItem a establecer.
     */
    public void setPaginas(List<PageItem> paginas) {
        this.paginas = paginas;
    }
}
