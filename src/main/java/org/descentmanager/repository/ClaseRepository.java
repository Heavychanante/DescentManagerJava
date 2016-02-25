package org.descentmanager.repository;

import org.descentmanager.model.Clase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "clases", path = "clases")
public interface ClaseRepository extends PagingAndSortingRepository<Clase, Integer> {

}
