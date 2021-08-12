package controller;

import java.awt.Component;
import java.util.ArrayList;

import dao.Dao;
import model.Model;
import model.ModelAgricultor;
import util.Parameter;
import view.ViewConsultarAgricultor;
import view.ViewManterAgricultor;

public class ControllerAgricultor implements Controller {

	Dao dao = new Dao ( new ModelAgricultor() );
	ViewConsultarAgricultor viewConsultar = new ViewConsultarAgricultor(this);
	ViewManterAgricultor viewManter = new ViewManterAgricultor(this);
	
	public ControllerAgricultor ( Component parent ) {
		viewConsultar.mostrar( parent );
	}
	
	@Override
	public ArrayList<Model> consultar(Parameter... parameters) throws Exception {
		return dao.consultar(parameters);
	}

	@Override
	public void manter(Model model) {
		viewManter.mostrar(model, viewConsultar);		
	}

	@Override
	public void excluir(Model model) throws Exception {
		dao.excluir(model);
		viewManter.close();
		viewConsultar.consultar();		
	}

	@Override
	public void salvar(Model model) throws Exception {
		dao.salvar(model);
		viewManter.close();
		viewConsultar.consultar();
	}
	
	public static void main(String[] args) {
		new ControllerAgricultor(null);
	}

}
