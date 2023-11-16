package org.utma.ItepTest.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.utma.ItepTest.controller.editor.UsuarioEmailPropertyEditor;
import org.utma.ItepTest.controller.editor.UsuarioMatriculaPropertyEditor;
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
    @Autowired
    private UsuarioMatriculaPropertyEditor usuarioMatriculaPropertyEditor;
    @Autowired
    private UsuarioEmailPropertyEditor usuarioEmailPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(String.class,"matricula", usuarioMatriculaPropertyEditor);
        binder.registerCustomEditor(String.class,"email",usuarioEmailPropertyEditor);
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Usuario usuarioParam, Model model, HttpSession session, RedirectAttributes flash)
    {
        if (usuarioService.loginWithMatriculaWithPassword(usuarioParam.getMatricula(),usuarioParam.getContraseña()))
        {
            Usuario usuario = usuarioService.findByMatricula(usuarioParam.getMatricula());
            model.addAttribute("usuario", usuario);
            session.setAttribute("usuarioId", usuario.getIdUsuarios());
            return "redirect:/itep/test";
        }
            else
        {
            flash.addFlashAttribute("error_login","Usuario o contraseña incorrecta *");
        }
        return "redirect:/usuario/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/usuario/login";
    }

    @PostMapping("/registro")
    public String registrar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash)
    {
        try
        {
            if (result.hasErrors())
            {
                return "login";
            }
            usuario.setCreateAt(new Date());
            usuarioService.save(usuario);
            status.setComplete();
        }
            catch(DataIntegrityViolationException ex)
        {
            flash.addFlashAttribute("error","El usuario o matricula ya existen");
        }
        return "redirect:/usuario/login";
    }
}
