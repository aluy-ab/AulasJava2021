package controller;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import dao.Dao;
import model.Model;
import model.ModelPessoa;
import util.Parameter;
import view.ViewConsultarPessoa;
import view.ViewManterPessoa;

public class ControllerPessoa implements Controller {
	
	Dao dao = new Dao(new ModelPessoa());
	ViewConsultarPessoa viewConsultar = new ViewConsultarPessoa(this);
	ViewManterPessoa viewManter = new ViewManterPessoa(this);
	
	public ControllerPessoa(Component parent) {
		viewConsultar.mostrar(parent);
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
	public void salvar(Model model) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException,
											NoSuchFieldException, SecurityException, IllegalArgumentException, Exception {
		dao.salvar(model);
		viewManter.close();
		viewConsultar.consultar();
	}
	
	public static void main(String[] args) {
		new ControllerPessoa(null);
	}

}
