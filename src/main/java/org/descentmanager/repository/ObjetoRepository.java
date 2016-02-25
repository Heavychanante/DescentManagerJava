package org.descentmanager.repository;

import org.descentmanager.model.Objeto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "objetos", path = "objetos")
public interface ObjetoRepository extends PagingAndSortingRepository<Objeto, Integer> {

}
