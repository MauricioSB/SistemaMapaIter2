/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xiutech.simix.controlador;

/**
 * Clase controlador para calificar comentarios sobre marcadores.
 * @author Mauricio Suarez Barrera
 * @version 11/05/19 
 */
public class CalificarComentarioController {
        
    private int calificacion;
    private Comentario coment;

    public Comentario getComentario() {
        return coment;
    }

    public void setComentario(Comentario coment) {
        this.coment = coment;
    }
    
    public int getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    public String calificaComentario(int id){
        String mensaje = "Se califico el comentario exitosamente";
        //busca al comentarista loggeado
        ComentaristaDAO comentaristaUDB = new ComentaristaDAO();
        SessionController.UserLogged usuario = (SessionController.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        Comentarista comentarista = comentaristaUDB.find(usuario.getCorreo());
        //busca el marcador dado el id
        MarcadorDAO marcadorUDB = new MarcadorDAO();
        Marcador marcador = marcadorUDB.find(id);
        //crea el id de la calificacion
        CalificacionId calificacionId = new CalificacionId();
        calificacionId.setIdMarcador(marcador.getIdMarcador());
        calificacionId.setCorreoComentarista(comentarista.getCorreo());
        //Se crea el comentario para agregarlo a la base de datos
        Calificacion calif = new Calificacion();
        calif.setCalificacion(getCalificacion()+1);
        calif.setComentarista(comentarista);
        calif.setComentario(coment);
        calif.setId(calificacionId);        
        //Se agrega a la base de datos.
        CalificacionDAO calificacionUDB = new CalificacionDAO ();
        calificacionUDB.save(calif);        
        return "/general/MensajeExitoIH?faces-redirect=true&mensaje=" + mensaje;
    }
    
}
