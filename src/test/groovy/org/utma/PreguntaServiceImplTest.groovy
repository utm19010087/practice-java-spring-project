package org.utma

import org.springframework.beans.factory.annotation.Autowired
import org.utma.ItepTest.model.entity.Pregunta
import org.utma.ItepTest.model.service.IPreguntaService
import org.utma.ItepTest.model.service.implement.PreguntaServiceImpl
import spock.lang.Specification

/**
 * Pruebas para el servicio de Pregunta (PreguntaServiceImpl).
 */
class PreguntaServiceImplTest extends Specification {

    @Autowired
    private IPreguntaService preguntaService

    /**
     * Verifica que el método findAll() no retorna null.
     */
    def "findAll() no retorna null"() {
        when:
        def preguntas = preguntaService.findAll()

        then:
        preguntas != null
    }
}