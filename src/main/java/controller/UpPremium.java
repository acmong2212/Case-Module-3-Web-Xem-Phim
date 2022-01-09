package controller;

import model.User;
import service.MovieService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/premium")
public class UpPremium extends HttpServlet {
    MovieService movieService = new MovieService();
    UserService userService = new UserService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                String name = req.getParameter("Search");
                req.setAttribute("movies", movieService.findByName(name));
                dispatcher = req.getRequestDispatcher("/view/HomeUserPremium.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("movies", movieService.fillAllMovie());
                dispatcher = req.getRequestDispatcher("/view/HomeUserPremium.jsp");
                dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int keyCode = Integer.parseInt(req.getParameter("keyCode"));
        String checkKeyCode = req.getParameter("checkKeyCode");
        User user= userService.searchUserByName(checkKeyCode);
        if(userService.checkKeyCode(keyCode)) {
            if (user.getKeyCode() == keyCode) {
                req.setAttribute("movies", movieService.fillAllMovie());
                dispatcher = req.getRequestDispatcher("/view/HomeUserPremium.jsp");
                dispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("/homeAccount");
            }
        } else {
            resp.sendRedirect("/homeAccount");
        }
    }
}
