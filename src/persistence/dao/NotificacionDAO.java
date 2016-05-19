package persistence.dao;

import java.util.List;

import bussines.Notificacion;

public interface NotificacionDAO {
    
	public Notificacion obtenerInformacionDeNotificacion(int id_Notificacion);
	
	public void eliminarNotificacion(int id_Notificacion);
	
	public Notificacion crearNotificacion(Notificacion notificacion);
	
	public void editarNotificacion(Notificacion notificacion);
	
	public List<Notificacion> obtenerNotificacionesDeHoy ();
}
