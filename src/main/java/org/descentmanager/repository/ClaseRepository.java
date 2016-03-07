package org.descentmanager.repository;

import org.descentmanager.model.Clase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "clases", path = "clases")
public interface ClaseRepository extends PagingAndSortingRepository<Clase, Integer> {

	@RestResource(path = "findByArquetipo", rel = "findByArquetipo")
	Page<Clase> findByArquetipoId(@Param("arquetipoId") Integer arquetipoId, Pageable pageable);
}
