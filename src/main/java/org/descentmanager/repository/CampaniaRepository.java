package org.descentmanager.repository;

import org.descentmanager.model.Campania;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "campanias", path = "campanias")
public interface CampaniaRepository extends PagingAndSortingRepository<Campania, Integer> {

}