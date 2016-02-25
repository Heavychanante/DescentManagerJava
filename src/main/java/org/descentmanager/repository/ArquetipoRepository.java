package org.descentmanager.repository;

import org.descentmanager.model.Arquetipo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "arquetipos", path = "arquetipos")
public interface ArquetipoRepository extends PagingAndSortingRepository<Arquetipo, Integer> {

}