package dao;
public interface IDao {
	Object get(long id);
	Object[] getAll();
	void insert();
	/*
	void set(Object informacao);
	void update(long id, Object informacao);
	void delete(long id);
	*/
}
