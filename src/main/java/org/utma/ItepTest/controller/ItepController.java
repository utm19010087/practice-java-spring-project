package org.utma.ItepTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.utma.ItepTest.model.service.IPreguntaService;
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

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("usuarioId",usuarioService.findById(id).getIdUsuarios());
        model.addAttribute("preguntas",preguntaService.findAll());
        return "test/itep_test";
    }

    @PostMapping("/test")
    public String testPost(@ModelAttribute RespuestaDto respuestaDto, Model model)
    {
        resultadoService.saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(respuestaDto);
        return "redirect:/itep/test/" + respuestaDto.getUsuarioId();
    }
}
