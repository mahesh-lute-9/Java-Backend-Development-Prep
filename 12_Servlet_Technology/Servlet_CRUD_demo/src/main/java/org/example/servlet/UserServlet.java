package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    /*
     * This Servlet uses UserService for the actual CRUD operations.
     * The Servlet's responsibility is mainly handling HTTP requests
     * and constructing HTTP responses.
     */
    private final UserService userService = new UserService();

    // CREATE -> POST /users
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");

        // Validate required request parameters before converting/using them.
        if (idParam == null || name == null ||
                email == null || mobileNo == null) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Some fields are missing\"}"
            );
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Invalid id\"}"
            );
            return;
        }

        User user = new User(id, name, email, mobileNo);
        userService.createUser(user);

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\"message\":\"User added successfully\"}"
        );
    }


    // READ ALL -> GET /users
    // READ ONE -> GET /users?id=1
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        response.setContentType("application/json");

        // No ID means the client is requesting all users.
        if (idParam == null) {

            List<User> users = userService.getAllUsers();

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(usersToJson(users));
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                    "{\"message\":\"Invalid id\"}"
            );
            return;
        }

        User user = userService.getUserById(id);

        // A missing resource should return 404, not 400.
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write(
                    "{\"message\":\"User not found\"}"
            );
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(userToJson(user));
    }


    // UPDATE -> PUT /users?id=1
    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");

        if (idParam == null || name == null ||
                email == null || mobileNo == null) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Some fields are missing\"}"
            );
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Invalid id\"}"
            );
            return;
        }

        User user = new User(id, name, email, mobileNo);
        User updatedUser = userService.updateUser(id, user);

        if (updatedUser == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"User not found\"}"
            );
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");

        response.getWriter().write(userToJson(updatedUser));
    }


    // DELETE -> DELETE /users?id=1
    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"id is required\"}"
            );
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Invalid id\"}"
            );
            return;
        }

        boolean deleted = userService.deleteUser(id);

        if (!deleted) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"User not found\"}"
            );
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\"message\":\"User deleted successfully\"}"
        );
    }


    /*
     * Since we are not using Jackson or another JSON library,
     * we manually convert our User object into a JSON string.
     */
    private String userToJson(User user) {
        return "{"
                + "\"id\":" + user.getId() + ","
                + "\"name\":\"" + user.getName() + "\","
                + "\"email\":\"" + user.getEmail() + "\","
                + "\"mobileNo\":\"" + user.getMobileNo() + "\""
                + "}";
    }

    private String usersToJson(List<User> users) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < users.size(); i++) {
            sb.append(userToJson(users.get(i)));

            if (i < users.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}