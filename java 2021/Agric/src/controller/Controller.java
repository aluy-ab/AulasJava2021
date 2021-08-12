package controller;

import java.util.ArrayList;

import model.Model;
import util.Parameter;

public interface Controller {

	public ArrayList<Model> consultar ( Parameter... parameters ) throws Exception;
	
	public void manter ( Model model );	
	
	public void excluir ( Model model ) throws Exception;
	public void salvar  ( Model model ) throws Exception;		
}
