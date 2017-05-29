package it.uniroma3.controller;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.QuadroService;
import it.uniroma3.validator.QuadroValidator;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quadro")
public class ControllerQuadro extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public ControllerQuadro() {
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String nextPage = "/mostraDatiQuadro.jsp";
    QuadroValidator quadroValidator = new QuadroValidator();
    Quadro quadro = new Quadro();
    request.setAttribute("quadro", quadro);
    
    if (quadroValidator.validate(request)) {
      QuadroService quadroService = new QuadroService();
      AutoreService autoreService = new AutoreService();
      Long id = Long.parseLong(request.getParameter("autoreId"));
      Autore autore = autoreService.find(id);
      quadro.setAutore(autore);
      quadroService.save(quadro);
    } 
    else {
      nextPage = "/inserimentoQuadro.jsp";
    }
    
    ServletContext application = getServletContext();
    RequestDispatcher rd = application.getRequestDispatcher(nextPage);
    rd.forward(request, response);
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nextPage = "/inserimentoQuadro.jsp";
    AutoreService autoreService = new AutoreService();
    List<Autore> autori = autoreService.findAll();
    request.setAttribute("autori", autori);
    
    ServletContext application = getServletContext();
    RequestDispatcher rd = application.getRequestDispatcher(nextPage);
    rd.forward(request, response);
  }
}