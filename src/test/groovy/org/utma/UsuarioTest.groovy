package org.utma

import org.utma.ItepTest.model.entity.Usuario
import spock.lang.Specification
/**
 * Pruebas para la clase Usuario.
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/22
 */
class UsuarioTest extends Specification
{
    /**
     * Verifica que el nombre de usuario puede contener caracteres especiales.
     */
    def "Nombre con caracteres especiales"() {
        when: "Se ingresan caracteres especiales en el nombre"
        def usuario = new Usuario()
        usuario.setNombre("Prueb%a_D+}el_n(ombre")

        then: "El nombre debe ser Prueb%a_D+}el_n(ombre"
        usuario.getNombre() == "Prueb%a_D+}el_n(ombre"
    }
    /**
     * Verifica que la contraseña puede contener una variedad de caracteres especiales.
     */
    def "Contraseña con caracteres especiales"() {
        when: "Se ingresan caracteres especiales en la contraseña"
        def usuario = new Usuario()
        usuario.setContraseña("Prueb%a_%!/&)(¨*´+}};:;:Ñ")

        then: "La contraseña debe ser Prueb%a_%!/&)(¨*´+}};:;:Ñ"
        usuario.getContraseña() == "Prueb%a_%!/&)(¨*´+}};:;:Ñ"
    }
    /**
     * Verifica que la matrícula sigue el patrón utm\d{8}.
     */
    def "Matricula acepta el patrón utm\\d{8}"() {
        when: "Se ingresa una matrícula válida"
        def usuario = new Usuario()
        usuario.setMatricula("UTM1808765")

        then: "La matrícula debe ser UTM1808765"
        usuario.getMatricula() == "UTM1808765"
    }
}
