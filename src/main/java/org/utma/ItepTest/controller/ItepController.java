package org.utma.ItepTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.utma.ItepTest.model.dao.IPreguntaDao;
import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.service.IPreguntaService;
import org.utma.ItepTest.model.service.IRespuestaService;
import org.utma.ItepTest.model.service.IResultadoService;
import org.utma.ItepTest.model.service.IUsuarioService;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

@Controller
@RequestMapping("/itep")
public class ItepController
{
    @Autowired
    private IPreguntaService preguntaService;

    @Autowired
    private IResultadoService resultadoService;

    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("preguntas",preguntaService.findAll());
        return "test/itep_test";
    }

    @PostMapping("/test")
    public String testPost(@ModelAttribute RespuestaDto respuestaDto, Model model)
    {
        resultadoService.saveRespuestaWithUsuarioWithPreguntaWithRespuesta(respuestaDto);
        return "redirect:/itep/test";
    }
}
