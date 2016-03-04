//package org.descentmanager.service;
//
//import org.descentmanager.model.CurrentUser;
//import org.descentmanager.model.Usuario;
//import org.descentmanager.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CurrentUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario usuario = usuarioRepository.findByAlias(username);
//		if (usuario == null) {
//			throw new UsernameNotFoundException("User \"" + username + "\" not found");
//		}
//		CurrentUser currentUser = new CurrentUser(usuario);
//		return currentUser;
//	}
//
//}
