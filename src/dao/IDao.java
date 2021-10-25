package dao;

import models.ModelDefault;

public interface IDao {
	ModelDefault get(long id);
	ModelDefault[] getAll();
	ModelDefault insert(ModelDefault obj);
	int getLastIndex();
	/*
	void set(Object informacao);
	void update(long id, Object informacao);
	void delete(long id);
	*/
}
