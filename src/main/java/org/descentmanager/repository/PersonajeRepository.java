package org.descentmanager.repository;

import org.descentmanager.model.Personaje;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "personajes", path = "personajes")
public interface PersonajeRepository extends PagingAndSortingRepository<Personaje, Integer> {

}