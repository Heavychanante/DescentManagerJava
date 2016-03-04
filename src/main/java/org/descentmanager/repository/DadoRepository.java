package org.descentmanager.repository;

import org.descentmanager.model.Dado;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "dados", path = "dados")
public interface DadoRepository extends PagingAndSortingRepository<Dado, Integer> {

}