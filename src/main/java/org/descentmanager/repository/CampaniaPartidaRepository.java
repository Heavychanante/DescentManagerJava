package org.descentmanager.repository;

import org.descentmanager.model.CampaniaPartida;
import org.descentmanager.model.pk.CampaniaPartidaPk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "campaniaPartida", path = "campaniaPartida")
public interface CampaniaPartidaRepository extends PagingAndSortingRepository<CampaniaPartida, CampaniaPartidaPk> {

}