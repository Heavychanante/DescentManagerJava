package org.descentmanager.model.pk.converter;

import org.descentmanager.model.pk.DadoObjetoPk;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase que convierte un PK compuesta de DadoObjeto desde su representación en String
 * @author Hugo
 *
 */
public class DadoObjetoPkConverter implements Converter<String, DadoObjetoPk> {

	@Override
	public DadoObjetoPk convert(String id) {
		String[] ids = id.split("-");
		DadoObjetoPk pk = new DadoObjetoPk(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		return pk;
	}

}
