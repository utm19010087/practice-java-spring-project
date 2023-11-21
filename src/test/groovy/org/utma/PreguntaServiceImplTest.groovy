package org.utma

import org.springframework.beans.factory.annotation.Autowired
import org.utma.ItepTest.model.entity.Pregunta
import org.utma.ItepTest.model.service.IPreguntaService
import org.utma.ItepTest.model.service.implement.PreguntaServiceImpl
import spock.lang.Specification

class PreguntaServiceImplTest extends Specification
{
    @Autowired
    private IPreguntaService preguntaService;

    def "Find all no retorna null"()
    {
        when:
        def pregunta = preguntaService.findAll()
        then:
        pregunta != null
    }
}
