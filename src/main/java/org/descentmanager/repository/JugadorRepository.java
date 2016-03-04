package org.descentmanager.repository;

import org.descentmanager.model.Jugador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "jugadores", path = "jugadores")
public interface JugadorRepository extends PagingAndSortingRepository<Jugador, Integer> {

}