package com.sportbemy.sportbemy.controller;

import com.sportbemy.sportbemy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // 1. Pantalla principal: Listar usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        // Obtenemos la lista del servicio
        var lista = usuarioService.listarTodos();

        // La metemos en la "caja" (Model) para enviarla al HTML
        model.addAttribute("usuarios", lista);

        // Retornamos el nombre del archivo HTML (sin .html)
        return "usuarios";
    }

    @GetMapping("/desactivar/{id}")
    public String desactivarUsuario(@PathVariable Long id) {
        usuarioService.desactivarUsuario(id);
        return "redirect:/usuarios";
    }
}
