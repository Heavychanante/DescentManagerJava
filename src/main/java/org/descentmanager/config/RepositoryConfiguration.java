package org.descentmanager.config;

import org.descentmanager.model.Arquetipo;
import org.descentmanager.model.Clase;
import org.descentmanager.model.Habilidad;
import org.descentmanager.model.Jugador;
import org.descentmanager.model.Objeto;
import org.descentmanager.model.Partida;
import org.descentmanager.model.Personaje;
import org.descentmanager.model.pk.converter.AventuraPartidaPkConverter;
import org.descentmanager.model.pk.converter.DadoHabilidadPkConverter;
import org.descentmanager.model.pk.converter.DadoObjetoPkConverter;
import org.descentmanager.model.pk.converter.JugadorHabilidadPkConverter;
import org.descentmanager.model.pk.converter.JugadorObjetoPkConverter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setBasePath("/api");
		config.exposeIdsFor(Habilidad.class, Jugador.class, Personaje.class, Arquetipo.class,
							Clase.class, Partida.class, Objeto.class);
	}

	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		conversionService.addConverter(new AventuraPartidaPkConverter());
		conversionService.addConverter(new DadoHabilidadPkConverter());
		conversionService.addConverter(new DadoObjetoPkConverter());
		conversionService.addConverter(new JugadorHabilidadPkConverter());
		conversionService.addConverter(new JugadorObjetoPkConverter());
	}
}
