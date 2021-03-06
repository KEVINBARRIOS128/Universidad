/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WILDER BARRIOS
 */
@Stateless
public class AsignacionCursoFacade extends AbstractFacade<AsignacionCurso> {

    @PersistenceContext(unitName = "ApiUniversidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionCursoFacade() {
        super(AsignacionCurso.class);
    }
    
}
