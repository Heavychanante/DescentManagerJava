package org.descentmanager.repository;

import org.descentmanager.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	/**
	 * Método que devuelve un usuario a partir de alias
	 * @param alias Alias del usuario
	 * @return Usuario
	 */
	@RestResource(path = "findByAlias", rel = "findByAlias")
	Usuario findByAlias(@Param("alias") String alias);
}