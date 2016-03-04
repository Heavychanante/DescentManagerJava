//package org.descentmanager.service;
//
//import org.descentmanager.model.Usuario;
//import org.descentmanager.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UsuarioService {
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//
//	@Transactional
//	public Usuario registerUsuario(String username, String name, String password) {
//		Usuario usuario = new Usuario();
//		usuario.setAlias(username);
//		usuario.setNombre(name);
//		usuario.setPassword(new BCryptPasswordEncoder().encode(password));
//		return usuarioRepository.save(usuario);
//	}
//}
