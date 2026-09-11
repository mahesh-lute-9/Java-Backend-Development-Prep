package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * @WebServlet maps the URL "/hello" to this Servlet.
 *
 * When a client sends:
 *      GET /hello
 *
 * Tomcat finds this Servlet and handles the request through it.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    /*
     * Servlet Lifecycle - Step 1
     *
     * Tomcat creates the Servlet object.
     * The constructor is called when the object is created.
     *
     * Constructor → object creation
     */
    public HelloServlet() {
        System.out.println("HelloServlet Constructor called");
    }

    /*
     * Servlet Lifecycle - Step 2
     *
     * After creating the Servlet object, Tomcat initializes it
     * by calling init().
     *
     * init() is normally used for one-time initialization work.
     *
     * Constructor → creates object
     * init()      → initializes Servlet
     */
    @Override
    public void init() {
        System.out.println("init() method called");
    }

    /*
     * Servlet Lifecycle - Step 3
     *
     * For every incoming request, the Servlet container calls
     * service().
     *
     * HttpServlet's service() examines the HTTP method and
     * dispatches the request to the appropriate method:
     *
     * GET    → doGet()
     * POST   → doPost()
     * PUT    → doPut()
     * DELETE → doDelete()
     *
     * We normally override doGet(), doPost(), etc.
     * instead of overriding service() directly.
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");

        response.getWriter().write("Hello");
    }

    /*
     * Servlet Lifecycle - Step 4
     *
     * When Tomcat takes this Servlet out of service,
     * it calls destroy().
     *
     * This is used for cleanup work.
     *
     * Complete lifecycle:
     *
     * Constructor
     *      ↓
     *    init()
     *      ↓
     * service()
     *      ↓
     * doGet()/doPost()/doPut()/doDelete()
     *      ↓
     * destroy()
     */
    @Override
    public void destroy() {
        System.out.println("destroy() method called");
    }
}