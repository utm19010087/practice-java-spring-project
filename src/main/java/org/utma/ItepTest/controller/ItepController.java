package org.utma.ItepTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.utma.ItepTest.model.dao.IPreguntaDao;
import org.utma.ItepTest.model.entity.Respuesta;

@Controller
@RequestMapping("/itep")
public class ItepController
{
    @Autowired
    private IPreguntaDao preguntaDao;
    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("preguntas",preguntaDao.findAll());
        return "test/itep_test";
    }

    @PostMapping("/test")
    public String testPost(Respuesta respuesta, Model model)
    {
        System.out.println(respuesta.getIdRespuestas());
        return "redirect:/itep/test";
    }
}
