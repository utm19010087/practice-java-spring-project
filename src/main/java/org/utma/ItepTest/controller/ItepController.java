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

    @GetMapping("/info")
    public String info(Model model)
    {
        model.addAttribute("main_message",true);
        return "info_messages";
    }

    @GetMapping("/test")
    public String test(Model model, HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null)
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
        return "redirect:/itep/resultados";
    }

    @GetMapping("/resultados")
    public String resultados(HttpSession session,Model model)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null)
        {
            return "redirect:/usuario/login";
        }
        model.addAttribute("usuario", usuarioService.findById(usuarioId));
        model.addAttribute("resultados",resultadoService.findResultadoByUsuarioId(usuarioId));
        return "test/results";
    }
}
