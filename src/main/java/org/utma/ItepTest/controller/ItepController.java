package org.utma.ItepTest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.utma.ItepTest.controller.auxiliar.LoginValidator;
import org.utma.ItepTest.model.dao.IResultadoDao;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.pagination.PageRender;
import org.utma.ItepTest.model.service.IPreguntaService;
import org.utma.ItepTest.model.service.IResultadoService;
import org.utma.ItepTest.model.service.IUsuarioService;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.Date;

/**
 * ItepController funge como el controlador de la aplicacion referente a su apartado ITEP.
 * Esta clase provee servicios para la aplicacion de tipo GET y POST asi como redireccionamientos web y validaciones
 * de entidades.
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/21
 */
@Controller
@RequestMapping("/itep")
public class ItepController
{
    /**
     * Inyecta las dependencias CRUD de PreguntaServiceImpl por medio de la interfaz de la que implementa.
     */
    @Autowired
    private IPreguntaService preguntaService;
    /**
     * Inyecta las dependencias CRUD de ResultadoServiceImpl por medio de la interfaz de la que implementa.
     */
    @Autowired
    private IResultadoService resultadoService;
    /**
     * Inyecta las dependencias CRUD de UsuarioServiceImpl por medio de la interfaz de la que implementa.
     */
    @Autowired
    private IUsuarioService usuarioService;
    /**
     * Inyecta el componente Login validator que nos permitira desacoplar la validacion del HttpSesion del controlador.
     */
    @Autowired
    private LoginValidator loginValidator;
    /**
     * info proporciona un mapeo de tipo get a la uri /info.
     * Carga la plantilla HTML de info_messages.html con un model attribute main_message que sera recibido por Thymeleaf.
     * @param model Parametro Model.
     * @return Retorna una plantilla html.
     */
    @GetMapping("/info")
    public String info(Model model)
    {
        return "message/info_message";
    }
    @GetMapping("/grammar_info")
    public String grammarInfo(Model model)
    {
        return "message/grammar_message";
    }

    /**
     * test proporciona un mapeo de tipo get a la uri /test.
     * Carga la plantilla itep_test.html con varios model attribute, usuarioId como un attribute de HttpSession
     * @param model Parametro Model.
     * @param session Parametro HttpSession.
     * @return Retorna una plantilla html.
     */
    @GetMapping("/test")
    public String test(Model model, HttpSession session)
    {
        if (loginValidator.validator(session))
        {
            return "redirect:/usuario/login";
        }
        model.addAttribute("usuarioId",session.getAttribute("usuarioId"));
        model.addAttribute("preguntas",preguntaService.findAll());
        return "test/itep_test";
    }
    /**
     * testPost proporciona un mapeo de tipo post a la uri /test.
     * testPost recibe un ModelAttribute de tipo RespuestaDto desde el formulario login y lo procesa para guardar los datos
     * en la base de datos por medio de resultadoService asi como los datos del usuario referentes al test.
     * @param respuestaDto Parametro ModelAttribute.
     * @param model Parametro Model.
     * @param session Parametro HttpSession.
     * @return
     */
    @PostMapping("/test")
    public String testPost(@ModelAttribute RespuestaDto respuestaDto, Model model, HttpSession session)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (loginValidator.validator(session))
        {
            return "redirect:/usuario/login";
        }
        respuestaDto.setUsuarioId(usuarioId);
        resultadoService.deleteResultadoByUsuarioId(usuarioId);
        resultadoService.saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(respuestaDto);
        Usuario usuario = new Usuario();
        usuario = usuarioService.findById(usuarioId);
        usuario.setUltimaAplicacion(new Date());
        usuario.setUltimaPuntuacion(resultadoService.findResultadoByUsuarioIdWhereIsCorrect(usuarioId));
        usuarioService.save(usuario);

        return "redirect:/itep/resultados";
    }

    /**
     * resultados proporciona un mapeo de tipo get a la uri /resultados.
     * recibe in entero por medio de un RequestParam que sera vital para manipular el Pageable de la plantilla results,
     * a su vez manipula los model attributes para enviarlos a la plantilla html.
     * @param page Parametro int.
     * @param session Parametro HttpSession.
     * @param model Parametro Model.
     * @return Retorna una uri.
     */
    @GetMapping("/resultados")
    public String resultados(@RequestParam(name = "page", defaultValue = "0") int page ,HttpSession session,Model model)
    {
        Long usuarioId = (Long) session.getAttribute("usuarioId");
        if (loginValidator.validator(session))
        {
            return "redirect:/usuario/login";
        }
        Pageable pageRequest = PageRequest.of(page,2);
        Page<Resultado> preguntas = resultadoService.findResultadoByUsuarioId(usuarioId, pageRequest);
        PageRender<Resultado> pageRender = new PageRender<>("/itep/resultados",preguntas);
        model.addAttribute("usuario", usuarioService.findById(usuarioId));
        model.addAttribute("resultados",preguntas);
        model.addAttribute("page",pageRender);
        return "test/results";
    }
}
