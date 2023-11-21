package org.utma.ItepTest.controller.auxiliar;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.utma.ItepTest.model.entity.Usuario;

@Component
public class LoginValidator
{
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
