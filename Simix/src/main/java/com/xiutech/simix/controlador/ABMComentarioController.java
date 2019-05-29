package com.xiutech.simix.controlador;

import com.xiutech.simix.modelo.Comentario;
import com.xiutech.simix.modelo.ComentarioDAO;
import com.xiutech.simix.modelo.ComentarioId;
import com.xiutech.simix.modelo.Comentarista;
import com.xiutech.simix.modelo.ComentaristaDAO;
import com.xiutech.simix.modelo.Marcador;
import com.xiutech.simix.modelo.MarcadorDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/** 
 *  Clase del controlador dedicada al alta de comentarios en marcadores.
 * @author Andrea Fernanda Muñiz Patiño
 * @version 11/05/19 
 */
@ManagedBean 
public class ABMComentarioController{
    private String texto; 
    
    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
 
    /**
     * Agrega un comentario a un marcador en la base de datos.
     * @param id el identificador del marcador al que se agrega el comentario
     * @return el url de redireccionamiento, en este caso, para mostrar un mensaje.
     */
    public String agregaComentario(int id){
        String mensaje = "Se agrego exitosamente";
        //busca al comentarista loggeado
        ComentaristaDAO comentaristaUDB = new ComentaristaDAO();
        SessionController.UserLogged usuario = (SessionController.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        Comentarista comentarista = comentaristaUDB.find(usuario.getCorreo());
        //busca el marcador dado el id
        MarcadorDAO marcadorUDB = new MarcadorDAO();
        Marcador marcador = marcadorUDB.find(id);
        //crea el id del comentario
        ComentarioId comentId = new ComentarioId();
        comentId.setIdMarcador(marcador.getIdMarcador());
        comentId.setCorreoComentarista(comentarista.getCorreo());
        //Se crea el comentario para agregarlo a la base de datos
        Comentario coment = new Comentario();
        coment.setTexto(getTexto());
        coment.setComentarista(comentarista);
        coment.setMarcador(marcador);
        coment.setId(comentId);
        //Se agrega a la base de datos.
        ComentarioDAO comentarioUDB = new ComentarioDAO ();
        comentarioUDB.save(coment);
        return "/general/MensajeExitoIH?faces-redirect=true&mensaje=" + mensaje;
    }

    public String editarComentario(Comentario coment) {
        /*1.- Obtener el comentario a editar
         * 2.-Obtener el texto del comentario
         * 3.- Cambiar el texto
         * 4.- Guardar el texto
        */
        String mensaje = "Se modifico exitosamente";
        //busca al comentarista loggeado
        ComentaristaDAO comentaristaUDB = new ComentaristaDAO();
        SessionController.UserLogged usuario = (SessionController.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        Comentarista comentarista = comentaristaUDB.find(usuario.getCorreo());
        //busca el marcador dado el id

        //Busca el id del comentario
        String comModificado = this.texto;
        //Comentario viejo 
        //Comentario coment = new Comentario();
        coment.getTexto();
        coment.setTexto(comModificado);
        coment.setComentarista(comentarista);
        //coment.setMarcador(marcador);
        //coment.setId(comentId);                
        //Se agrega a la base de datos.
        ComentarioDAO comentarioUDB = new ComentarioDAO ();
        comentarioUDB.save(coment);
        return "/general/MensajeExitoIH?faces-redirect=true&mensaje=" + mensaje;
    }    
    
}
