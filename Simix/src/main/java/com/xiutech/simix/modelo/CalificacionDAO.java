/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xiutech.simix.modelo;

import java.util.List;

/**
 * Clase para manejar datos de tabla Calificacion en la base.
 * @author Jose Fernando Reyes Garcia
 * @version 04/04/19
 */
public class CalificacionDAO extends AbstractDAO<Calificacion>{
      
    /**
     * Constructor default. Usa el constructor de AbstractDAO.
     */
    public CalificacionDAO(){
        super();
    }
    
    /**
     * Guarda una Calificacion en la base.
     * @param calificacion la Calificacion a agregar.
     */
    @Override
    public void save(Calificacion calificacion){
        super.save(calificacion);
    }
    
    /**
     * Actualiza una Calificacion en la base.
     * @param calificacion la Calificacion a actualizar.
     */
    @Override
    public void update(Calificacion calificacion){
        super.update(calificacion);
    }
    
    /**
     * Elimina una Calificacion en la base.
     * @param calificacion la Calificacion eliminar.
     */
    @Override
    public void delete(Calificacion calificacion){
        super.delete(calificacion);
    }
    
    /**
     * Busca una Calificacion, dado su identificador.
     * @param id el identificador de la Calificacion.
     * @return la Calificacion, null si no está.
     */
    public Calificacion find(CalificacionId id){
        return super.find(Calificacion.class, id);
    }
    
    /**
     * Busca todas las calificaciones en la base.
     * @return Una lista de todas las calificaciones en la base.
     */
    public List<Calificacion> findAll(){
        return super.findAll(Calificacion.class);
    }
      
}

