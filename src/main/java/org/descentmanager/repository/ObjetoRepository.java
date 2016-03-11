package org.descentmanager.repository;

import org.descentmanager.model.Objeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "objetos", path = "objetos")
public interface ObjetoRepository extends CrudRepository<Objeto, Integer> {

}
