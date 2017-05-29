package it.uniroma3.controller;

import it.uniroma3.model.Autore;
import it.uniroma3.service.AutoreService;
import it.uniroma3.validator.AutoreValidator;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/autore")
public class ControllerAutore extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public ControllerAutore() {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nextPage = "/mostraDatiAutore.jsp";
    AutoreValidator autoreValidator = new AutoreValidator();
    Autore autore = new Autore();
    request.setAttribute("autore", autore);
    
    if (autoreValidator.validate(request)) {
      AutoreService autoreService = new AutoreService();
      autoreService.save(autore);
    } 
    else {
      nextPage = "/inserimentoAutore.jsp";
    }
    
    ServletContext application = getServletContext();
    RequestDispatcher rd = application.getRequestDispatcher(nextPage);
    rd.forward(request, response);
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nextPage = "/mostraDatiAutore.jsp";
    
    Long id = Long.parseLong(request.getParameter("id"));
    AutoreService autoreService = new AutoreService();
    Autore autore = autoreService.find(id);
    request.setAttribute("autore", autore);
    
    ServletContext application = getServletContext();
    RequestDispatcher rd = application.getRequestDispatcher(nextPage);
    rd.forward(request, response);
  }
}