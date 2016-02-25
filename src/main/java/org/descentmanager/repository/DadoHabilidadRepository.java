package org.descentmanager.repository;

import org.descentmanager.model.DadoHabilidad;
import org.descentmanager.model.pk.DadoHabilidadPk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "dadoHabilidad", path = "dadoHabilidad")
public interface DadoHabilidadRepository extends PagingAndSortingRepository<DadoHabilidad, DadoHabilidadPk> {

}