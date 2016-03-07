package org.descentmanager.controller;

import java.util.LinkedHashMap;

import org.descentmanager.model.Usuario;
import org.descentmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
    public Usuario register(@RequestBody LinkedHashMap<String, Object> body) {
		String name		= (String) body.get("name");
		String username = (String) body.get("username");
		String password = (String) body.get("password");
		Usuario newUsuario = new Usuario();
		newUsuario.setNombre(name);
		newUsuario.setAlias(username);
		newUsuario.setPassword(password);
		Usuario usuario = usuarioRepository.save(newUsuario);
        return usuario;
    }
}
