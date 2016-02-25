package org.descentmanager.model.pk.converter;

import org.descentmanager.model.pk.DadoHabilidadPk;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase que convierte un PK compuesta de DadoHabilidad desde su representación en String
 * @author Hugo
 *
 */
public class DadoHabilidadPkConverter implements Converter<String, DadoHabilidadPk> {

	@Override
	public DadoHabilidadPk convert(String id) {
		String[] ids = id.split("-");
		DadoHabilidadPk pk = new DadoHabilidadPk(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
		return pk;
	}

}
