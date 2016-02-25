package org.descentmanager.repository;

import org.descentmanager.model.Campania;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "campanias", path = "campanias")
public interface CampaniaRepository extends PagingAndSortingRepository<Campania, Integer> {

}