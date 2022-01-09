package controller;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    CategoriesService categoriesService = new CategoriesService();
    MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;

        if (action == null) {
            action = "";
        }
        switch (action) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rd = new Random();
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login": {
                String userLogin = req.getParameter("Username");
                String passLogin = req.getParameter("Password");
                User user = userService.searchUser(userLogin, passLogin);
                if (user != null) {
                    if (user.getIsAdmin() == 1) {
//                        bay vao view admin
                        session.setAttribute("acc", user);
                        resp.sendRedirect("/homeAccount");
                    } else if (user.getIsAdmin() != 1) {
                        session.setAttribute("acc", user);
//                        bay vao view user
                        resp.sendRedirect("/homeAccount");
                    }
                } else {
                    req.setAttribute("messLogin", "Tai khoan hoac mat khau khong dung");
                    dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            break;
            case "sign": {
                String username = req.getParameter("Username");
                String pass1 = req.getParameter("Password");
                String pass2 = req.getParameter("Verification");
                String phone = req.getParameter("Phone");
                int isUser = 1;
                int keyCode = rd.nextInt(100000);
//                viet them phan check sign, neu co tk roi thi bat tao tk lai
//                neu kiem tra khac null thi se yeu cau dk lai
                if (userService.searchUserByName(username) != null) {
                    req.setAttribute("mess1", "Tai khoan da ton tai, dang ky lai");
                    dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                    dispatcher.forward(req, resp);
                } else if (!pass1.equals(pass2)) {
                    req.setAttribute("mess", "Check lai Password");
                    dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    User user = new User(username, pass1, phone, isUser, keyCode);
                    userService.createUser(user);
                    req.setAttribute("mess2", "Dang ky thanh cong, hay dang nhap lai");
                    dispatcher = req.getRequestDispatcher("/view/HomeNotLogin.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            break;
        }

    }

}

