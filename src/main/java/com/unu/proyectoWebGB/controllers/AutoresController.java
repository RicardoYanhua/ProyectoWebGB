package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.models.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutoresModel modelo = new AutoresModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoresController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//response.setContentType("text/html;charset=UTF-8");
		
		
		if (request.getParameter("op") == null) {
			listar(request,response);
			return;
		}
		
		
		String operacion = request.getParameter("op");
		
		
		switch (operacion) {

		case "listar":
			listar(request, response);
			break;

		case "nuevo":
			 nuevo(request, response);
		 break;


		}
	}
	
	private void nuevo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nuevoAutor", modelo.getlistarAutores());
		request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaAutores", modelo.getlistarAutores());
		request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		
		/*
		Iterator<Autor> it = modelo.getlistarAutores().iterator();
		while(it.hasNext()) {
			Autor a = it.next();
			System.out.println(a.getIdAutor() + " " + a.getNacionalidad() + " " + a.getNombre());
			
		}*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
