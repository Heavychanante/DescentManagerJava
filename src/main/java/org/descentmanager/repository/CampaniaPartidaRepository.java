package org.descentmanager.repository;

import org.descentmanager.model.CampaniaPartida;
import org.descentmanager.model.pk.CampaniaPartidaPk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "campaniaPartida", path = "campaniaPartida")
public interface CampaniaPartidaRepository extends PagingAndSortingRepository<CampaniaPartida, CampaniaPartidaPk> {

}