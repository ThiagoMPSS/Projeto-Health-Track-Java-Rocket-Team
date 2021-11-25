package com.RocketTeam.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

import com.RocketTeam.dao.Ati_Fis_DAO;
import com.RocketTeam.dao.IDao;
import com.RocketTeam.dao.Imc_DAO;
import com.RocketTeam.dao.PressaoDAO;
import com.RocketTeam.dao.RefeicaoDAO;
import com.RocketTeam.models.Ati_Fis;
import com.RocketTeam.models.Imc;
import com.RocketTeam.models.ModelDefault;
import com.RocketTeam.models.Pressao;
import com.RocketTeam.models.Refeicao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("/CRUD")
@WebServlet(name="CRUD", urlPatterns = { "/Refeicoes/Add/CRUD", "/Refeicoes/Edit/CRUD", "/Refeicoes/Delete/CRUD",
										 "/Exercicios/Add/CRUD","/Exercicios/Edit/CRUD", "/Exercicios/Delete/CRUD",
										 "/Pressao/Add/CRUD", "/Pressao/Edit/CRUD", "/Pressao/Delete/CRUD",
										 "/DadosGerais/Add/CRUD", "/DadosGerais/Edit/CRUD", "/DadosGerais/Delete/CRUD" })
public class CRUD extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        old(request, response);
		PrintWriter writer = response.getWriter();
		String[] Path = request.getServletPath().split("/");
		String root = request.getContextPath();
		String tabela = Path[1];
		String funcao = Path[2];
		
		IDao dao = null;
		switch (tabela) {
			case "DadosGerais":
				dao = new Imc_DAO();
				break;
			case "Refeicoes":
				dao = new RefeicaoDAO();
				break;
			case "Pressao":
				dao = new PressaoDAO();
				break;
			case "Exercicios":
				dao = new Ati_Fis_DAO();
				break;
		}
		
		Map<String, String[]> params = request.getParameterMap();

		try {
			switch (funcao) {
				case "Add":
					dao.insert(getModel(tabela, params));
					break;
				case "Edit":{
					String idS = request.getParameter("id");
					long id = Long.parseLong(idS);
					ModelDefault model = getModel(tabela, params);
					dao.update(id, model);
					break;
				} case "Delete":{
					long id = Long.parseLong(request.getParameter("id"));
					dao.delete(id);
					break;
				} case "Get":{
					long id = Long.parseLong(request.getParameter("id"));
					dao.get(id);
					break;
				}
			}
			writer.print("Realizado com sucesso!");
			
			switch (tabela) {
				case "DadosGerais":
					response.sendRedirect(root + "/Dashboard");
					break;
				default:
					response.sendRedirect(root + "/" + tabela);
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			writer.print("Erro: " + e.getMessage());
		}
	}
	
	private ModelDefault getModel(String Tabela, Map<String, String[]> dados) {
		ModelDefault obj = null;
		long id = -1;
		if (dados.containsKey("id")) {
			id = Long.parseLong(dados.get("id")[0]);
		}
		long userId = -1;
		if (dados.containsKey("userId")) {
			userId = Long.parseLong(dados.get("userId")[0]);
		}
		userId = 1; //Sem sistema de Usuario
		
		switch (Tabela) {
			case "DadosGerais":
				Date dataAtualizacao = null;
				if (dados.containsKey("dataAtualizacao"))
					dataAtualizacao = Date.valueOf(dados.get("dataAtualizacao")[0]);
				else
					dataAtualizacao = new Date(Calendar.getInstance().getTime().getTime());
				
				if (id > -1) {
					obj = new Imc(id, userId, Float.parseFloat(dados.get("peso")[0]),
										  	Float.parseFloat(dados.get("altura")[0]), dataAtualizacao);
				} else {
					obj = new Imc(userId, Float.parseFloat(dados.get("peso")[0]),
						  				Float.parseFloat(dados.get("altura")[0]), dataAtualizacao);
				}
				break;
			case "Refeicoes":
				Date data_Refeicao = null;
				if (dados.containsKey("dt_refeicao"))
					data_Refeicao = Date.valueOf(dados.get("dt_refeicao")[0]);
				else
					data_Refeicao = new Date(Calendar.getInstance().getTime().getTime());
				
				if (id > -1) {
					obj = new Refeicao(id, userId, dados.get("ds_alimento")[0],
												   Float.parseFloat(dados.get("nr_calorias")[0]),
												   data_Refeicao);
				} else {
					obj = new Refeicao(userId, dados.get("ds_alimento")[0],
							   				   Float.parseFloat(dados.get("nr_calorias")[0]),
							   				   data_Refeicao);
				}
				break;
			case "Pressao":
				Date dt_Medicao = null;
				if (dados.containsKey("dt_medicao"))
					dt_Medicao = Date.valueOf(dados.get("dt_medicao")[0]);
				else
					dt_Medicao = new Date(Calendar.getInstance().getTime().getTime());
				
				if (id > -1) {
					obj = new Pressao(id, userId, Float.parseFloat(dados.get("nr_pressao")[0]), dt_Medicao);
				} else {
					obj = new Pressao(userId, Float.parseFloat(dados.get("nr_pressao")[0]), dt_Medicao);
				}
				break;
			case "Exercicios":
				Date dt_atividade = null;
				if (dados.containsKey("dt_atividade"))
					dt_atividade = Date.valueOf(dados.get("dt_atividade")[0]);
				else
					dt_atividade = new Date(Calendar.getInstance().getTime().getTime());
				
				if (id > -1) {
					obj = new Ati_Fis(id, userId, dt_atividade, dados.get("ds_frequencia_ati_fis")[0]);
				} else {
					obj = new Ati_Fis(userId, dt_atividade, dados.get("ds_frequencia_ati_fis")[0]);
				}
				break;
		}
		return obj;
	}
	
	@SuppressWarnings("unused")
	private void old (HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		String[] Path = request.getServletPath().split("/");
		String Tabela = Path[1];
		String Funcao = Path[2];
		writer.print("Tabela: " + Tabela + "<br/>");
		writer.print("Função: " + Funcao + "<br/>");
		writer.print("<br/>");
		
		request.getParameterMap().forEach((k, v) -> {
				try {
					response.getWriter().write(k + ": " + v[0] + "<br/>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		writer.print("<br/><br/>Alterações Realizadas!");
	}

}
