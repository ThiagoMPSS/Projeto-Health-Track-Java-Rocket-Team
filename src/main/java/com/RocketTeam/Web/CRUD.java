package com.RocketTeam.Web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("/CRUD")
@WebServlet(name="CRUD", urlPatterns = { "/Refeicoes/Add/CRUD", "/Refeicoes/Edit/CRUD", "/Refeicoes/Remove/CRUD",
										 "/Exercicios/Add/CRUD","/Exercicios/Edit/CRUD", "/Exercicios/Remove/CRUD",
										 "/Pressao/Add/CRUD", "/Pressao/Edit/CRUD", "/Pressao/Remove/CRUD",
										 "/DadosGerais/Add/CRUD", "/DadosGerais/Edit/CRUD", "/DadosGerais/Remove/CRUD" })
public class CRUD extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
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
