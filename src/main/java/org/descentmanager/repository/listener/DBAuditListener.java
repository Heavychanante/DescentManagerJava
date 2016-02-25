package org.descentmanager.repository.listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

@SuppressWarnings("rawtypes")
public class DBAuditListener extends AbstractRepositoryEventListener {

	Logger log = Logger.getLogger(DBAuditListener.class);

	@Override
	public void onBeforeSave(Object entity) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try {
			Method setModificacion = entity.getClass().getMethod("setModificacion", new Class[]{Timestamp.class});
			setModificacion.invoke(entity, new Object[]{timestamp});
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void onBeforeCreate(Object entity) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try {
			Method setCreacion = entity.getClass().getMethod("setCreacion", new Class[]{Timestamp.class});
			Method setModificacion = entity.getClass().getMethod("setModificacion", new Class[]{Timestamp.class});
			setCreacion.invoke(entity, new Object[]{timestamp});
			setModificacion.invoke(entity, new Object[]{timestamp});
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		}
	}
}
