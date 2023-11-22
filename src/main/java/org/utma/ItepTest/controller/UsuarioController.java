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
import org.utma.ItepTest.controller.auxiliar.LoginValidator;
import org.utma.ItepTest.controller.editor.ValuePropertyEditor;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IUsuarioService;

import java.util.Date;

/**
 * UsuarioController
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
@Controller
@RequestMapping("/usuario")
@SessionAttributes("usuario")
public class UsuarioController
{
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ValuePropertyEditor valuePropertyEditor;

    @Autowired
    private LoginValidator loginValidator;
    /**
     * Inicializa el WebDataBinder para personalizar la conversión de propiedades.
     *
     * @param binder El WebDataBinder a inicializar.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(String.class,"matricula", valuePropertyEditor);
        binder.registerCustomEditor(String.class,"email", valuePropertyEditor);
    }
    /**
     * Maneja las solicitudes GET para la página de inicio de sesión.
     * Si el usuario ya está autenticado, redirige al menú principal.
     *
     * @param model   El modelo para la vista.
     * @param session La sesión HTTP.
     * @return La vista de inicio de sesión o la redirección al menú principal.
     */
    @GetMapping("/login")
    public String login(Model model, HttpSession session)
    {
        if (loginValidator.validator(session))
        {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
        return "redirect:/usuario/menu";
    }
    /**
     * Maneja las solicitudes POST para el proceso de inicio de sesión.
     * Autentica al usuario y redirige al menú principal si la autenticación es exitosa.
     *
     * @param usuarioParam   Los datos del usuario para el inicio de sesión.
     * @param model          El modelo para la vista.
     * @param session        La sesión HTTP.
     * @param flash          Atributos para mensajes flash.
     * @return La redirección al menú principal o a la página de inicio de sesión en caso de error.
     */
    @PostMapping("/login")
    public String loginPost(Usuario usuarioParam, Model model, HttpSession session, RedirectAttributes flash)
    {
        if (usuarioService.loginWithMatriculaWithPassword(usuarioParam.getMatricula(),usuarioParam.getContraseña()))
        {
            Usuario usuario = usuarioService.findByMatricula(usuarioParam.getMatricula());
            model.addAttribute("usuario", usuario);
            session.setAttribute("usuarioId", usuario.getIdUsuarios());
            return "redirect:/usuario/menu";
        }
            else
        {
            flash.addFlashAttribute("error_login","Usuario o contraseña incorrecta *");
        }
        return "redirect:/usuario/login";
    }
    /**
     * Maneja las solicitudes GET para la página del menú principal.
     * Si el usuario no está autenticado, redirige a la página de inicio de sesión.
     *
     * @param model   El modelo para la vista.
     * @param session La sesión HTTP.
     * @return La vista del menú principal o la redirección a la página de inicio de sesión.
     */
    @GetMapping("/menu")
    public String menu(Model model, HttpSession session)
    {
        if (loginValidator.validator(session))
        {
            model.addAttribute("usuario", new Usuario());
            return "redirect:/usuario/login";
        }
        return "menu";
    }
    /**
     * Maneja las solicitudes GET para cerrar sesión.
     * Invalida la sesión si el usuario está autenticado.
     *
     * @param session La sesión HTTP.
     * @return La redirección a la página de inicio de sesión.
     */
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        if (!(loginValidator.validator(session)))
        {
            session.invalidate();
        }
        return "redirect:/usuario/login";
    }
    /**
     * Maneja las solicitudes POST para el proceso de registro de usuarios.
     * Registra un nuevo usuario si los datos son válidos.
     *
     * @param usuario       El usuario a registrar.
     * @param result        El resultado del enlace.
     * @param model         El modelo para la vista.
     * @param status        El estado de la sesión.
     * @param flash         Atributos para mensajes flash.
     * @return La redirección a la página de inicio de sesión.
     */
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
