package controller;

import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "")
public class HomeNotLogin extends HttpServlet {
    MovieService movieService = new MovieService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "search":
                String name = req.getParameter("Search");
                req.setAttribute("movies", movieService.findByName(name));
                dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("movies", movieService.fillAllMovie());
                dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
