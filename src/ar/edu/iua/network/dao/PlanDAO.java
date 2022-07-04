package ar.edu.iua.network.dao;

import java.util.List;
import java.util.ArrayList;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.academico.plan.PlanImpl;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.modelo.exceptions.ModificarPlanEx;
import ar.edu.iua.negocio.academico.plan.BorrarPlanImpl;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;
import ar.edu.iua.negocio.academico.plan.BuscarPlanesImpl;
import ar.edu.iua.negocio.academico.plan.CrearPlanImpl;
import ar.edu.iua.negocio.academico.plan.ModificarPlanImpl;
import ar.edu.iua.persistencia.BaseDeDatos;

public class PlanDAO implements intCRUD<PlanImpl>{

    @Override
    public boolean create(PlanImpl elemento) throws CrearPlanEx {
        CrearPlanImpl crear = new CrearPlanImpl();
        crear.crear(elemento);
        return false;
    }

    @Override
    public boolean delete(PlanImpl elemento) throws BorrarPlanEx {
        BuscarPlan buscarPlan = new BuscarPlanImpl();
        Plan elem = buscarPlan.buscar(elemento.getAnio());
        BorrarPlanImpl bp = new BorrarPlanImpl();
        return bp.borrar(elem);
    }

    @Override
    public boolean update(PlanImpl elemento) throws ModificarPlanEx, BorrarPlanEx {
        Plan elem = (Plan) elemento;
        ModificarPlanImpl mp = new ModificarPlanImpl();
        return mp.modificar(elem);
    }

    @Override
    public List<PlanImpl> read(String terminos) {
        BuscarPlanesImpl bpi = new BuscarPlanesImpl();
        List<Plan> lista = bpi.buscar(terminos);
        List<PlanImpl> listaPlanImpl = new ArrayList<>();
        for (Plan plan : lista) {
            listaPlanImpl.add((PlanImpl)plan);
        }
        return listaPlanImpl;
    }

    @Override
    public List<PlanImpl> readAll() {
        List<PlanImpl> lista = new ArrayList<>();
        for (int i =0; i<BaseDeDatos.getSizePlanes();i++) {
            lista.add((PlanImpl)BaseDeDatos.getPlan(i));
        } 
        return lista;
    }
    
}
