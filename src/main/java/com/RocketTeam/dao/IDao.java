package com.RocketTeam.dao;

import com.RocketTeam.models.ModelDefault;

public interface IDao {
	ModelDefault get(long id);
	ModelDefault[] getAll();
	ModelDefault insert(ModelDefault obj);
	void delete();
	//Retorna o ultimo valor da chave primaria
	int getLastIndex();
	/*
	void set(Object informacao);
	void update(long id, Object informacao);
	void delete(long id);
	*/
}
