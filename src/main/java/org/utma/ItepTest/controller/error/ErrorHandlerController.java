package org.utma.ItepTest.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * ErrorHandlerController funge como un controlador y handler para excepciones capturadas.
 * Esta clase hace uso de la etiqueta ControllerAdvice para declarar un controlador, tambien hace uso de la etiqueta
 * ExceptionHandler para capturar la excepcion y tratarla.
 * @author Francisco Javier Gonzalez / Fabrica de Software UTMA
 * @version 0.1, 2023/11/22
 */
@ControllerAdvice
public class ErrorHandlerController
{
    /**
     * excepcionGenerica genera un handler para mapear la clase Exception.
     * Enviara model attributes a la plantilla generico.html para mostrar los errores generados/capturados por el
     *  exceptionHandler.
     * @param ex Parametro Exception.
     * @param model Parametro Model.
     * @return Retorna la plantilla HTML.
     */
    @ExceptionHandler({Exception.class})
    public String excepcionGenerica(Exception ex, Model model)
    {
        model.addAttribute("error", "Error inesperado!");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/generico";
    }
}
