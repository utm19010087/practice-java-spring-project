package org.utma.ItepTest.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IUsuarioService;

import java.util.Date;

@Controller
@RequestMapping("/usuario")
@SessionAttributes("usuario")
public class UsuarioController
{
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam("matricula") String matricula,
            @RequestParam("password") String password, Model model, HttpSession session)
    {
        if (usuarioService.loginWithMatriculaWithPassword(matricula,password))
        {
            Usuario usuario = usuarioService.findByMatricula(matricula);
            model.addAttribute("usuario", usuario);
            session.setAttribute("usuarioId", usuario.getIdUsuarios());
            return "redirect:/itep/test/" + usuario.getIdUsuarios();
        }
        return "login";
    }

    @PostMapping("/registro")
    public String registrar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status)
    {
        if (result.hasErrors())
        {
            return "login";
        }
        usuario.setCreateAt(new Date());
        usuarioService.save(usuario);
        status.setComplete();
        return "redirect:/usuario/login";
    }
}
