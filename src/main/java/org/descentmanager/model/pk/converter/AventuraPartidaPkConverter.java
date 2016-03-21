package org.descentmanager.model.pk.converter;

import org.descentmanager.model.pk.AventuraPartidaPk;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase que convierte un PK compuesta de AventuraPartida desde su representación en String
 * @author Hugo
 *
 */
public class AventuraPartidaPkConverter implements Converter<String, AventuraPartidaPk> {

	@Override
	public AventuraPartidaPk convert(String id) {
		String[] ids = id.split("-");
		AventuraPartidaPk pk = new AventuraPartidaPk(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		return pk;
	}

}
