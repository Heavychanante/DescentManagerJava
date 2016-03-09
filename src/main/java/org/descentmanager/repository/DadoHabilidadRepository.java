package org.descentmanager.repository;

import org.descentmanager.model.DadoHabilidad;
import org.descentmanager.model.pk.DadoHabilidadPk;
import org.descentmanager.repository.projection.DadoHabilidadProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "dadoHabilidad", path = "dadoHabilidad", excerptProjection = DadoHabilidadProjection.class)
public interface DadoHabilidadRepository extends PagingAndSortingRepository<DadoHabilidad, DadoHabilidadPk> {

	/**
	 * Método que devuelve el listado habilidades que utilizan un determinado dado
	 * @param dadoId Identificador de dado
	 * @param pageable Paginable
	 * @return Listado de Habilidades con dadoId asignado
	 */
	@RestResource(path = "findByDado", rel = "findByDado")
	Page<DadoHabilidad> findByIdDadoId(@Param("dadoId") Integer dadoId, Pageable pageable);

	/**
	 * Método que devuelve el listado de dados que son utilizados por una habilidad determinada
	 * @param habilidadId Identificador de habilidad
	 * @param pageable Paginable
	 * @return Listado de dados asignados a una habilidad
	 */
	@RestResource(path = "findByHabilidad", rel = "findByHabilidad")
	Page<DadoHabilidad> findByIdHabilidadId(@Param("habilidadId") Integer habilidadId, Pageable pageable);
}