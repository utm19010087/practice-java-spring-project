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
import org.utma.ItepTest.controller.editor.ValuePropertyEditor;
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
    private ValuePropertyEditor valuePropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(String.class,"matricula", valuePropertyEditor);
        binder.registerCustomEditor(String.class,"email", valuePropertyEditor);
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (usuarioId == null)
        {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
        return "redirect:/itep/info";
    }

    @PostMapping("/login")
    public String loginPost(Usuario usuarioParam, Model model, HttpSession session, RedirectAttributes flash)
    {
        if (usuarioService.loginWithMatriculaWithPassword(usuarioParam.getMatricula(),usuarioParam.getContraseña()))
        {
            Usuario usuario = usuarioService.findByMatricula(usuarioParam.getMatricula());
            model.addAttribute("usuario", usuario);
            session.setAttribute("usuarioId", usuario.getIdUsuarios());
            return "redirect:/itep/info";
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
    public String registrar(@Valid Usuario usuario, BindingResult result,
                            Model model, SessionStatus status, RedirectAttributes flash)
    {
        try
        {
            if (result.hasErrors())
            {
                flash.addFlashAttribute("error","Debes ingresar tu matricula con el formato UTM y sus 8 digitos!");
                return "redirect:/usuario/login";
            }
            usuario.setCreateAt(new Date());
            usuarioService.save(usuario);
            status.setComplete();
        }
            catch(DataIntegrityViolationException ex)
        {
            flash.addFlashAttribute("error","El correo electronico o matricula que ingresaste ya fueron registrados!");
        }
        return "redirect:/usuario/login";
    }
}
