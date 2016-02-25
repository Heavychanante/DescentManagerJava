package org.descentmanager.model.pk.converter;

import org.descentmanager.model.pk.JugadorObjetoPk;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase que convierte un PK compuesta de JugadorObjeto desde su representación en String
 * @author Hugo
 *
 */
public class JugadorObjetoPkConverter implements Converter<String, JugadorObjetoPk> {

	@Override
	public JugadorObjetoPk convert(String id) {
		String[] ids = id.split("-");
		JugadorObjetoPk pk = new JugadorObjetoPk(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		return pk;
	}

}
