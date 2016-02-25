package org.descentmanager.model.pk.converter;

import org.descentmanager.model.pk.CampaniaPartidaPk;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase que convierte un PK compuesta de CampaniaPartida desde su representación en String
 * @author Hugo
 *
 */
public class CampaniaPartidaPkConverter implements Converter<String, CampaniaPartidaPk> {

	@Override
	public CampaniaPartidaPk convert(String id) {
		String[] ids = id.split("-");
		CampaniaPartidaPk pk = new CampaniaPartidaPk(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		return pk;
	}

}
