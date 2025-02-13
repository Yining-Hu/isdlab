/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tf.isd.controller;

/**
 *
 * @author yih
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import tf.isd.model.dao.DBManager;

public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String favcol = request.getParameter("favouriteColour");
        DBManager manager = (DBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Email format is incorrect.");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Name format is incorrect.");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Password format is incorrect.");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                User exist = manager.findUser(email, password);
                if (exist != null) {
                    session.setAttribute("existErr", "Student already exists in the Database.");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    manager.addUser(email, name, password, gender, favcol);
                    User user = new User(email, name, password, gender, favcol);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}