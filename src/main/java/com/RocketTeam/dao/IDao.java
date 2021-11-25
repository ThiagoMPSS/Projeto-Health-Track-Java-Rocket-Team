package com.RocketTeam.dao;

import java.sql.SQLException;

import com.RocketTeam.models.ModelDefault;

public interface IDao {
	ModelDefault get(long id) throws SQLException;
	ModelDefault[] getByFk(long id) throws SQLException;
	ModelDefault[] getAll() throws SQLException;
	ModelDefault insert(ModelDefault obj) throws SQLException;
	void delete() throws SQLException;
	//Retorna o ultimo valor da chave primaria
	int getLastIndex() throws SQLException;
	void update(long id, ModelDefault informacao) throws SQLException;
	void delete(long id) throws SQLException;
}
