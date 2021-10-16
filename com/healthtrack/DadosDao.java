package com.healthtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	
public class DadosDao implements IDadosDao {
	private List<Object> dadosRegistrados = new ArrayList<Object>();
	
	public DadosDao() {
		dadosRegistrados.add(Arrays.asList(0,"21/12/2020",1.80f,112f));
		dadosRegistrados.add(Arrays.asList(1,"20/01/2021",1.80f,111f));
		dadosRegistrados.add(Arrays.asList(2,"19/02/2021",1.80f,111f));
		dadosRegistrados.add(Arrays.asList(3,"20/03/2021",1.80f,110f));
		dadosRegistrados.add(Arrays.asList(4,"22/04/2021",1.80f,109f));
		dadosRegistrados.add(Arrays.asList(5,"20/05/2021",1.80f,108f));
		dadosRegistrados.add(Arrays.asList(6,"22/06/2021",1.80f,106f));
		dadosRegistrados.add(Arrays.asList(7,"19/07/2021",1.80f,105f));
		dadosRegistrados.add(Arrays.asList(8,"20/08/2021",1.80f,103f));
		dadosRegistrados.add(Arrays.asList(9,"20/09/2021",1.80f,100f));
	}
	
	@Override
	public Object get(long id) {	
		return dadosRegistrados.get((int) id);
	}

	@Override
	public Object[] getAll() {
		Object[] dados = new Object[dadosRegistrados.size()];
		dadosRegistrados.toArray(dados);
		return dados;
	}

	/*
	@Override
	public void set(Object informacao) {
		
		
	}

	@Override
	public void update(long id, Object informacao) {
		
		
	}

	@Override
	public void delete(long id) {
		
		
	}
	*/
}
