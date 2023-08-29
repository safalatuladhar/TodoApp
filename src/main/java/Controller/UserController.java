package Controller;

import Model.User;
import Service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet("/signup")

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init(){
        userService = new UserService();
    }

//    public void doPost(HttpServlet request, HttpServlet response){
//        signup(request, response);
//    }

//    protected void doGet(HttpServlet request, HttpServlet response){
//        response.sendRedirect(signup/signup.jsp);
//    }
//
//    private void signup(HttpServlet request, HttpServlet response) {
//        User user = new User();
//        String firstName = request.getInitParameter("first_name");
//        String lastName = request.getInitParameter("last_name");
//        String username = request.getInitParameter("username");
//        String password = request.getInitParameter("password");
//
//        try {
//            int result = userService.signup(user);
//            if (result == 1){
//            }
//        }
//    }

}
