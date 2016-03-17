package org.descentmanager.repository;

import org.descentmanager.model.Aventura;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "aventuras", path = "aventuras")
public interface AventuraRepository extends PagingAndSortingRepository<Aventura, Integer> {
	
}
