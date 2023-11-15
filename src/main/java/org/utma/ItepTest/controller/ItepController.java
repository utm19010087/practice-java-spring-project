package org.utma.ItepTest.controller;

import jakarta.servlet.http.HttpSession;
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
    public String test(@PathVariable("id") Long id, Model model, HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null || !usuarioId.equals(id))
        {
            return "redirect:/usuario/login";
        }

        model.addAttribute("usuarioId",usuarioId);
        model.addAttribute("preguntas",preguntaService.findAll());
        return "test/itep_test";
    }

    @PostMapping("/test")
    public String testPost(@ModelAttribute RespuestaDto respuestaDto, Model model, HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null)
        {
            return "redirect:/usuario/login";
        }
        respuestaDto.setUsuarioId(usuarioId);
        resultadoService.deleteResultadoByUsuarioId(usuarioId);
        resultadoService.saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(respuestaDto);
        return "redirect:/itep/resultados/" + respuestaDto.getUsuarioId();
    }

    @GetMapping("/resultados/{id}")
    public String resultados(@PathVariable("id") Long id ,Model model)
    {
        model.addAttribute("usuario", usuarioService.findById(id));
        model.addAttribute("resultados",resultadoService.findResultadoByUsuarioId(id));
        return "test/results";
    }
}
