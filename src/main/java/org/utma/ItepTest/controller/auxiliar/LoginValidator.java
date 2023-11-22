package org.utma.ItepTest.controller.auxiliar;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.utma.ItepTest.model.entity.Usuario;

/**
 * LoginValidator representa una validacion del atributos de un HttpSession.
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/21
 */
@Component
public class LoginValidator
{
    /**
     * Valida que el atributo en HttpSession no sea vacio y devuelve un boolean proveniente de la validacion
     * @param session Refiere a el HttpSession.
     * @return devuelve el boolean calculado.
     */
    public boolean validator(HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null)
        {
            return true;
        }
        return false;
    }
}
