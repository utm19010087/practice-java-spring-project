package org.utma

import org.utma.ItepTest.model.entity.Usuario
import spock.lang.Specification

class UsuarioTest extends Specification
{
    def "Username with special characters"()
    {
        when: "Se ingresan caracteres especiales"
        def usuario = new Usuario();
        usuario.setNombre("Prueb%a_D+}el_n(ombre")
        then: "nombre is Prueb%a_D+}el_n(ombre"
        usuario.getNombre() == "Prueb%a_D+}el_n(ombre"
    }

    def "Password with special characters"()
    {
        when: "Se ingresan caracteres especiales"
        def usuario = new Usuario();
        usuario.setContraseña("Prueb%a_%!/&)(¨*´+}};:;:Ñ")
        then: "nombre is Prueb%a_%!/&)(¨*´+}};:;:Ñ"
        usuario.getContraseña() == "Prueb%a_%!/&)(¨*´+}};:;:Ñ"
    }

    def "Matricula accepts utm\\d{8} pattern"()
    {
        when: "Se ingresan datos en matricula"
        def usuario = new Usuario();
        usuario.setMatricula("UTM1808765")

        then: "matricula is UTM1808765"
        usuario.getMatricula() == "UTM1808765"
    }
}
