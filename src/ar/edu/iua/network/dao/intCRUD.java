/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.iua.network.dao;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.PlanImpl;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.modelo.exceptions.ModificarPlanEx;

/**
 *
 * @author csimes
 */
public interface intCRUD<EntidadDTO> {
    public boolean create(EntidadDTO elemento) throws CrearPlanEx;

    public boolean delete(EntidadDTO elemento) throws BorrarPlanEx;

    public boolean update(EntidadDTO elemento) throws ModificarPlanEx, BorrarPlanEx;

    public List<PlanImpl> read(String terminos);

    public List<EntidadDTO> readAll();

}
