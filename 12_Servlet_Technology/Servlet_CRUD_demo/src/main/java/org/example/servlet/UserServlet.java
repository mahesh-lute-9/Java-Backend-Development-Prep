package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

// This annotation tells the container to call this class when /users is requested
@WebServlet("/users")
public class UserServlet extends HttpServlet {

    // UserServlet is dependent on UserService class so
    private UserService userService = new UserService();


    // doPost
    @Override
    public void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));      // converting id into INTEGER
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");

        // checks
        if(id == null || email == null ||
                name == null || mobileNo == null){

            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"some fields are missing\"\n" +
                            "}"
            );
        }

        User user = new User(id, name, email, mobileNo);
        User createdUser = userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added successfully\"\n" +
                        "}"
        );
    }


    //doGet
    @Override
    public void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        // check
        if(idParam == null){
            List<User> users = userService.getAllUsers();
            // return users;

            response.setStatus(201);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParam);
        User userRes = userService.getUserById(id);

        if(userRes == null){
            response.setStatus(400);
            response.setContentType("application/json");
        }
        // return user (200)
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(userToUser(userRes));
    }

    @Override
    public void doPut(HttpServletRequest request,
                        HttpServletResponse response){

        // try your own
    }

    @Override
    public void doDelete(HttpServletRequest request,
                            HttpServletResponse response){

        // try you own
    }

    // user to json
    private String userToUser(User user){
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : " + user.getName() + ",\n" +
                "    \"email\" : " + user.getEmail() + ",\n" +
                "    \"mobileNo\" : " + user.getMobileNo() + "\n" +
                "}";
    }

    // users to json
    private String usersToJson(List<User> users) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < users.size(); i++) {
            sb.append(userToUser(users.get(i)));
            if (i < users.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}


// class going to listen incoming requests from tomcat(servlet container)
// for mapping there are two methods XML based and annotations based, here we are going to use annotation based
// web.xml or annotations (@WebServlet) for mapping
// in servlet there is class specific endpoint not a method specific
// Create --> POST --> /users
// Read --> GET --> /users?id={id}
// ReadAll --> GET --> /users
// Update --> PUT --> /users?id={id}
// Delete --> DELETE --> /users?id={id}

// whenever tomcat gets request Tomcat --> GET /users
                                        /*
                                            It does internally like:
                                            UserServlet servlet = new UserServlet();
                                            servlet.doGet(HttpServletRequest,HttpServletResponse);       --> here it gets HttpServletRequest and HttpServletResponse objects
                                         */

// in SpringBoot the jackson library does the work of mapping the variables to JSON body, but in servlet we have to implement a complex code for that so instead of that
// we just pass values through query params in Postman coz it is simple
// Now it will loo like localhost:8080/users?id=1&name=Aditya&email=aditya@gmail.com&mobileNo=9856561229 this