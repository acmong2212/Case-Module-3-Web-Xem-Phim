package controller;

import model.Movie;
import model.User;
import service.CategoriesService;
import service.MovieService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    MovieService movieService = new MovieService();
    CategoriesService categoriesService = new CategoriesService();
    UserService userService = new UserService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "edit":
                editMovie(req, resp);
                break;
            case "delete":
                deleteMovie(req, resp);
                break;
            case "editAccount":
                editAccount(req, resp);
                break;
            case "deleteAccount":
                deleteAccount(req, resp);
                break;
            case "viewAdmin":
                req.setAttribute("categories", categoriesService.getAllCategories());
                req.setAttribute("movies", movieService.fillAllMovie());
                dispatcher = req.getRequestDispatcher("/view/HomeAccount.jsp");
                dispatcher.forward(req,resp);
                break;
            case "viewManager":
                resp.sendRedirect("/view/AdminManager.jsp");
                break;
            case "managerAccount":
                req.setAttribute("user", userService.findAll());
                dispatcher = req.getRequestDispatcher("/view/AdminManagerAccount.jsp");
                dispatcher.forward(req,resp);
                break;
            case "managerMovie":
            default:
                req.setAttribute("categories", categoriesService.getAllCategories());
                req.setAttribute("movies", movieService.fillAllMovie());
                dispatcher = req.getRequestDispatcher("/view/AdminManagerMovie.jsp");
                dispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createMovie":
                createMovie(req, resp);
                break;
            case "edit":
                updateMovie(req, resp);
                break;
            case "editAccount":
                updateAccount(req, resp);
                break;
    }
}

    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        userService.deleteUser(idUser);

        req.setAttribute("user", userService.findAll());
        dispatcher = req.getRequestDispatcher("/view/AdminManagerAccount.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        String nameUser= req.getParameter("nameUser");
        String passUser = req.getParameter("passUser");
        String phoneNumber = req.getParameter("phoneNumber");
        int isPremium = Integer.parseInt(req.getParameter("isPremium"));
        int isUser = Integer.parseInt(req.getParameter("isUser"));
        int isAdmin = Integer.parseInt(req.getParameter("isAdmin"));

        userService.updateUser(new User(idUser, nameUser, passUser, phoneNumber, isPremium, isUser, isAdmin));

        req.setAttribute("user", userService.findAll());
        dispatcher = req.getRequestDispatcher("/view/AdminManagerAccount.jsp");
        dispatcher.forward(req,resp);
    }

    private void editAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        User user =  userService.getUserById(idUser);

        req.setAttribute("idUser", idUser);
        req.setAttribute("user", user);
        dispatcher = req.getRequestDispatcher("/view/EditAccount.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteMovie(HttpServletRequest req, HttpServletResponse resp) {
        int idMovie = Integer.parseInt(req.getParameter("idMovie"));
        movieService.deleteMovie(idMovie);

        try {
            resp.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idMovie = Integer.parseInt(req.getParameter("idMovie"));
        Movie movie =  movieService.getMovieById(idMovie);

        req.setAttribute("idMovie", idMovie);
        req.setAttribute("categories", categoriesService.getAllCategories());
        req.setAttribute("movies", movie);
        dispatcher = req.getRequestDispatcher("/view/EditMovie.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateMovie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idMovie = Integer.parseInt(req.getParameter("idMovie"));
        String nameMovie = req.getParameter("nameMovie");
        String description = req.getParameter("description");
        int idCategories = Integer.parseInt(req.getParameter("Categories"));
        int year = Integer.parseInt(req.getParameter("year"));
        String image = req.getParameter("image");

        movieService.editMovie(new Movie(idMovie, nameMovie, description, idCategories, year, image));

        resp.sendRedirect("/admin");
    }

    private void createMovie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nameMovie = req.getParameter("nameMovie");
        String description = req.getParameter("description");
        int idCategories = Integer.parseInt(req.getParameter("Categories"));
        int year = Integer.parseInt(req.getParameter("year"));
        String image = req.getParameter("image");

        movieService.createMovie(new Movie(nameMovie, description, idCategories, year, image));

        resp.sendRedirect("/admin");
    }
}
