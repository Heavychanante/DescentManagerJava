//package org.descentmanager.model;
//
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//
//public class CurrentUser extends User {
//
//	private static final long serialVersionUID = 1L;
//
//	private Integer id;
//	private String name;
//
//	public CurrentUser(Usuario usuario) {
//		super(usuario.getAlias(), usuario.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
//		this.id = usuario.getId();
//		this.name = usuario.getNombre();
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//}
