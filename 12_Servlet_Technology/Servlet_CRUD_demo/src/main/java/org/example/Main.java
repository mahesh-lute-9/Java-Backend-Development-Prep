package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java Servlet CRUD Application");
    }


    /*
     * ================================================================
     *                    JAVA SERVLET - INTERVIEW
     * ================================================================
     *
     * This section is our interview and conceptual reference for
     * the Servlet CRUD application built in this project.
     *
     * The project currently demonstrates:
     *
     *      Client
     *        ↓
     *      Tomcat (Servlet Container)
     *        ↓
     *      Servlet
     *        ↓
     *      Service
     *        ↓
     *      In-memory HashMap
     *
     * Later, the HashMap can be replaced with:
     *
     *      Servlet
     *        ↓
     *      Service
     *        ↓
     *      DAO
     *        ↓
     *      JDBC
     *        ↓
     *      PostgreSQL
     *
     * ================================================================
     */


    /*
     * ================================================================
     * 1. WHAT IS A SERVLET?
     * ================================================================
     *
     * A Servlet is a Java component that runs inside a Servlet
     * container and is responsible for processing client requests
     * and generating responses.
     *
     * In a web application, a client sends an HTTP request and the
     * Servlet processes that request.
     *
     * Example:
     *
     *      GET /users
     *
     * The request reaches Tomcat, Tomcat identifies the Servlet
     * mapped to /users, and the Servlet processes the request.
     *
     * Servlet = Java component for handling HTTP requests/responses.
     *
     *
     * Interview answer:
     *
     * "A Servlet is a server-side Java component that runs inside a
     * Servlet container such as Tomcat and is used to handle client
     * requests and generate responses."
     */


    /*
     * ================================================================
     * 2. WHAT IS TOMCAT?
     * ================================================================
     *
     * Apache Tomcat is a Servlet container.
     *
     * It provides the runtime environment required to execute
     * Servlets.
     *
     * Tomcat is responsible for things such as:
     *
     * - Creating Servlet instances
     * - Managing Servlet lifecycle
     * - Receiving HTTP requests
     * - Finding the appropriate Servlet using URL mapping
     * - Calling the appropriate Servlet methods
     * - Managing request and response objects
     * - Destroying Servlet instances when they are taken out of service
     *
     *
     * Important:
     *
     * Tomcat is not simply "calling doGet() directly".
     *
     * A simplified request flow is:
     *
     *      HTTP Request
     *           ↓
     *      Tomcat
     *           ↓
     *      URL Mapping
     *           ↓
     *      Servlet
     *           ↓
     *      service()
     *           ↓
     *      doGet()/doPost()/doPut()/doDelete()
     */


    /*
     * ================================================================
     * 3. WHAT IS A SERVLET CONTAINER?
     * ================================================================
     *
     * A Servlet Container is the runtime responsible for managing
     * Servlets.
     *
     * Tomcat is one example of a Servlet container.
     *
     * The container manages:
     *
     * - Servlet lifecycle
     * - Request/response handling
     * - URL mapping
     * - Servlet instantiation
     * - Concurrency
     * - Resource management
     *
     *
     * Interview distinction:
     *
     * Servlet:
     *      Application component written by the developer.
     *
     * Servlet Container:
     *      Runtime environment that manages the Servlet.
     */


    /*
     * ================================================================
     * 4. WHAT DOES @WebServlet DO?
     * ================================================================
     *
     * Example:
     *
     *      @WebServlet("/users")
     *      public class UserServlet extends HttpServlet
     *
     * @WebServlet creates a URL mapping for the Servlet.
     *
     * Therefore:
     *
     *      /users
     *
     * is mapped to:
     *
     *      UserServlet
     *
     * The package name does NOT automatically become the endpoint.
     *
     * URL mapping can be configured using:
     *
     * 1. Annotation:
     *      @WebServlet("/users")
     *
     * 2. Deployment descriptor:
     *      web.xml
     *
     * Our project uses annotation-based configuration.
     */


    /*
     * ================================================================
     * 5. HTTP METHOD → SERVLET METHOD
     * ================================================================
     *
     * A Servlet can handle different HTTP methods.
     *
     *      GET     → doGet()
     *      POST    → doPost()
     *      PUT     → doPut()
     *      DELETE  → doDelete()
     *
     * Example:
     *
     *      GET /users
     *              ↓
     *          doGet()
     *
     *      POST /users
     *              ↓
     *          doPost()
     *
     *
     * The URL identifies the Servlet.
     * The HTTP method determines which request-handling method
     * is executed.
     */


    /*
     * ================================================================
     * 6. SERVLET LIFECYCLE
     * ================================================================
     *
     * The Servlet lifecycle is managed by the Servlet container.
     *
     * Simplified lifecycle:
     *
     *      Servlet class loaded
     *             ↓
     *      Constructor
     *             ↓
     *          init()
     *             ↓
     *         service()
     *             ↓
     *      doGet()/doPost()/...
     *             ↓
     *         service()
     *             ↓
     *          ...
     *             ↓
     *         destroy()
     *
     *
     * Constructor:
     *      Used when the Servlet object is created.
     *
     * init():
     *      Called by the container to initialize the Servlet.
     *      Normally called once for a Servlet instance.
     *
     * service():
     *      Handles incoming requests and determines which HTTP
     *      method-specific operation should be invoked.
     *
     * doGet()/doPost()/doPut()/doDelete():
     *      Handle specific HTTP methods.
     *
     * destroy():
     *      Called when the Servlet is being taken out of service.
     *
     *
     * Important:
     *
     * init() is not the same as the constructor.
     *
     * Constructor:
     *      Creates the Java object.
     *
     * init():
     *      Initializes the Servlet under container management.
     *
     *
     * Also important:
     *
     * service() and doXxx() can execute many times because a Servlet
     * can handle multiple requests during its lifetime.
     */


    /*
     * ================================================================
     * 7. IS A NEW SERVLET OBJECT CREATED FOR EVERY REQUEST?
     * ================================================================
     *
     * Normally, NO.
     *
     * A Servlet container generally creates one Servlet instance
     * and uses it to process multiple requests.
     *
     * Conceptually:
     *
     *      Request 1 ─┐
     *      Request 2 ─┤
     *      Request 3 ─┼──→ Servlet instance
     *      Request 4 ─┤
     *      Request 5 ─┘
     *
     * This means multiple requests can be processed concurrently.
     *
     * Therefore, Servlet developers must be careful with mutable
     * instance variables and shared state.
     *
     *
     * Interview question:
     *
     * "Are Servlets thread-safe?"
     *
     * Better answer:
     *
     * "Servlet containers may invoke the same Servlet instance from
     * multiple threads concurrently. Therefore, application code
     * should avoid unsafe mutable shared state in Servlet instance
     * fields."
     */


    /*
     * ================================================================
     * 8. HttpServlet
     * ================================================================
     *
     * HttpServlet is a base class provided for handling HTTP-based
     * requests.
     *
     * Our Servlet:
     *
     *      public class UserServlet extends HttpServlet
     *
     * By extending HttpServlet, we can override methods such as:
     *
     *      doGet()
     *      doPost()
     *      doPut()
     *      doDelete()
     *
     * HttpServlet internally handles HTTP method dispatching.
     */


    /*
     * ================================================================
     * 9. HttpServletRequest
     * ================================================================
     *
     * HttpServletRequest represents the incoming HTTP request.
     *
     * It provides information such as:
     *
     * - Request parameters
     * - HTTP method
     * - Headers
     * - Request URI
     * - Cookies
     * - Request body
     *
     * Example:
     *
     *      String id = request.getParameter("id");
     *
     * If the request is:
     *
     *      /users?id=10
     *
     * then:
     *
     *      request.getParameter("id")
     *
     * returns:
     *
     *      "10"
     *
     *
     * Important:
     *
     * Request parameters are received as Strings.
     *
     * Therefore:
     *
     *      String idParam = request.getParameter("id");
     *
     * followed by:
     *
     *      Integer.parseInt(idParam)
     *
     * when an Integer is required.
     */


    /*
     * ================================================================
     * 10. HttpServletResponse
     * ================================================================
     *
     * HttpServletResponse represents the response sent back to
     * the client.
     *
     * We can use it to specify:
     *
     * - HTTP status code
     * - Content type
     * - Response body
     * - Headers
     *
     * Example:
     *
     *      response.setStatus(HttpServletResponse.SC_OK);
     *
     *      response.setContentType("application/json");
     *
     *      response.getWriter().write(...);
     */


    /*
     * ================================================================
     * 11. COMMON HTTP STATUS CODES USED IN CRUD
     * ================================================================
     *
     * 200 OK
     *      Request succeeded.
     *
     * 201 CREATED
     *      A new resource was successfully created.
     *
     * 400 BAD REQUEST
     *      The client sent an invalid request.
     *
     * 404 NOT FOUND
     *      The requested resource does not exist.
     *
     * 500 INTERNAL SERVER ERROR
     *      Unexpected server-side failure.
     *
     *
     * Typical CRUD usage:
     *
     *      POST   → 201 Created
     *      GET    → 200 OK
     *      PUT    → 200 OK
     *      DELETE → 200 OK
     *
     *      Invalid request → 400 Bad Request
     *      Resource missing → 404 Not Found
     */


    /*
     * ================================================================
     * 12. CRUD API DESIGN IN THIS PROJECT
     * ================================================================
     *
     * CREATE
     *
     *      POST /users
     *
     *      → doPost()
     *      → UserService.createUser()
     *
     *
     * READ ALL
     *
     *      GET /users
     *
     *      → doGet()
     *      → UserService.getAllUsers()
     *
     *
     * READ ONE
     *
     *      GET /users?id=1
     *
     *      → doGet()
     *      → UserService.getUserById(1)
     *
     *
     * UPDATE
     *
     *      PUT /users?id=1
     *
     *      → doPut()
     *      → UserService.updateUser()
     *
     *
     * DELETE
     *
     *      DELETE /users?id=1
     *
     *      → doDelete()
     *      → UserService.deleteUser()
     */


    /*
     * ================================================================
     * 13. MODEL CLASS / POJO
     * ================================================================
     *
     * User is our model class.
     *
     *      User
     *       ├── id
     *       ├── name
     *       ├── email
     *       └── mobileNo
     *
     * It represents the data of a single user.
     *
     * It should not be responsible for:
     *
     * - HTTP request handling
     * - Servlet logic
     * - Database operations
     *
     * Our User class is a POJO:
     *
     *      Plain Old Java Object
     *
     * It contains data and related methods such as getters,
     * setters, and constructors without being tied to web-layer
     * responsibilities.
     */


    /*
     * ================================================================
     * 14. SERVICE LAYER
     * ================================================================
     *
     * UserService contains application/business logic related
     * to users.
     *
     * Our architecture is:
     *
     *      UserServlet
     *            ↓
     *      UserService
     *            ↓
     *      HashMap
     *
     * The Servlet should mainly deal with:
     *
     * - HTTP request
     * - Input extraction
     * - Validation
     * - HTTP response
     *
     * The Service should deal with:
     *
     * - User-related operations
     * - Business rules
     * - Calling the persistence layer
     *
     * This separation improves maintainability and testability.
     */


    /*
     * ================================================================
     * 15. WHY ARE WE USING HashMap?
     * ================================================================
     *
     * For learning purposes, our project currently uses:
     *
     *      Map<Integer, User>
     *
     * The map acts as an in-memory data store.
     *
     * Example:
     *
     *      1 → User(...)
     *      2 → User(...)
     *      3 → User(...)
     *
     * The ID is the key.
     * The User object is the value.
     *
     * This is NOT a real database.
     *
     * If the application restarts, the HashMap contents are lost.
     *
     * The purpose is to first understand:
     *
     *      HTTP
     *      ↓
     *      Servlet
     *      ↓
     *      Service
     *      ↓
     *      CRUD logic
     *
     * before introducing JDBC and PostgreSQL.
     */


    /*
     * ================================================================
     * 16. WHY DO WE NEED A SERVICE LAYER?
     * ================================================================
     *
     * Imagine putting all CRUD logic directly inside the Servlet.
     *
     * Then one class would handle:
     *
     *      HTTP
     *      Validation
     *      Business logic
     *      Database
     *      JSON
     *
     * This creates a tightly coupled class that becomes difficult
     * to maintain and test.
     *
     * Instead:
     *
     *      Servlet
     *          ↓
     *      Service
     *          ↓
     *      DAO
     *          ↓
     *      Database
     *
     * Each layer has a clearer responsibility.
     */


    /*
     * ================================================================
     * 17. WHY NOT PUT DATABASE CODE IN THE SERVLET?
     * ================================================================
     *
     * A Servlet is part of the presentation/API layer.
     *
     * JDBC/database operations belong in a persistence/DAO layer.
     *
     * Preferred architecture:
     *
     *      Client
     *        ↓
     *      Servlet
     *        ↓
     *      Service
     *        ↓
     *      DAO
     *        ↓
     *      Database
     *
     * This allows the database implementation to change without
     * heavily modifying the Servlet.
     */


    /*
     * ================================================================
     * 18. QUERY PARAMETER
     * ================================================================
     *
     * Current examples:
     *
     *      GET /users?id=1
     *
     *      POST /users?id=1&name=John&email=john@gmail.com&mobileNo=123
     *
     * request.getParameter("id") reads the parameter.
     *
     * Query parameters are useful for simple learning and testing.
     *
     * However, for a production-style API, request bodies are
     * generally preferred for larger create/update payloads.
     *
     * Example JSON body:
     *
     * {
     *     "name": "John",
     *     "email": "john@gmail.com",
     *     "mobileNo": "1234567890"
     * }
     *
     * We will learn both approaches.
     */


    /*
     * ================================================================
     * 19. WHY DID WE MANUALLY BUILD JSON?
     * ================================================================
     *
     * Example:
     *
     *      "{"
     *          + "\"id\":" + user.getId()
     *          + ...
     *          + "}"
     *
     * We are doing this manually only to understand the Servlet
     * mechanics.
     *
     * In real applications, JSON libraries such as Jackson are
     * normally used to serialize Java objects into JSON and
     * deserialize JSON into Java objects.
     *
     *
     * Conceptually:
     *
     * Java Object
     *      ↓
     * JSON serialization
     *      ↓
     * JSON response
     *
     *
     * JSON request
     *      ↓
     * JSON deserialization
     *      ↓
     * Java Object
     */


    /*
     * ================================================================
     * 20. WHY DO WE VALIDATE BEFORE Integer.parseInt()?
     * ================================================================
     *
     * request.getParameter("id") returns String or null.
     *
     * This is dangerous:
     *
     *      Integer.parseInt(request.getParameter("id"));
     *
     * because the parameter might not exist.
     *
     * Correct flow:
     *
     *      String idParam = request.getParameter("id");
     *
     *      if (idParam == null) {
     *          // bad request
     *      }
     *
     *      Integer id = Integer.parseInt(idParam);
     *
     * We should also handle NumberFormatException because:
     *
     *      id=abc
     *
     * cannot be converted to Integer.
     */


    /*
     * ================================================================
     * 21. WHY RETURN AFTER SENDING AN ERROR RESPONSE?
     * ================================================================
     *
     * Consider:
     *
     *      if (user == null) {
     *          response.setStatus(404);
     *      }
     *
     *      response.getWriter().write(userToJson(user));
     *
     * Execution continues after the if block.
     *
     * If user is null, the code may attempt to use null and cause
     * another exception.
     *
     * Therefore:
     *
     *      if (user == null) {
     *          response.setStatus(404);
     *          response.getWriter().write(...);
     *          return;
     *      }
     *
     * The return stops further processing.
     */


    /*
     * ================================================================
     * 22. RESPONSE CONTENT TYPE
     * ================================================================
     *
     * Example:
     *
     *      response.setContentType("application/json");
     *
     * This tells the client that the response body contains JSON.
     *
     * Another example:
     *
     *      response.setContentType("text/plain");
     *
     * means plain text.
     */


    /*
     * ================================================================
     * 23. request.getParameter() vs REQUEST BODY
     * ================================================================
     *
     * request.getParameter("name")
     *
     * is generally used for parameters such as query parameters
     * and form parameters.
     *
     * Example:
     *
     *      /users?id=10
     *
     * For JSON request bodies, we can read:
     *
     *      request.getReader()
     *
     * or:
     *
     *      request.getInputStream()
     *
     * and then deserialize the JSON.
     *
     * This distinction becomes important when moving from this
     * learning project to a proper REST API.
     */


    /*
     * ================================================================
     * 24. SERVLET THREAD SAFETY
     * ================================================================
     *
     * A single Servlet instance may process multiple requests
     * concurrently using different threads.
     *
     * Therefore avoid request-specific mutable state such as:
     *
     *      private String currentUser;
     *
     * because multiple users could access the same Servlet at
     * the same time.
     *
     * Local variables inside methods are much safer because each
     * request gets its own method execution context.
     *
     * Example:
     *
     *      protected void doGet(...) {
     *          String id = request.getParameter("id");
     *      }
     *
     * "id" is local to that invocation.
     */


    /*
     * ================================================================
     * 25. CURRENT APPLICATION ARCHITECTURE
     * ================================================================
     *
     * Current:
     *
     *      Client
     *        ↓
     *      Tomcat
     *        ↓
     *      UserServlet
     *        ↓
     *      UserService
     *        ↓
     *      HashMap
     *
     *
     * Target architecture after JDBC:
     *
     *      Client
     *        ↓
     *      Tomcat
     *        ↓
     *      UserServlet
     *        ↓
     *      UserService
     *        ↓
     *      UserDAO
     *        ↓
     *      JDBC
     *        ↓
     *      PostgreSQL
     */


    /*
     * ================================================================
     * 26. INTERVIEW: EXPLAIN THIS PROJECT
     * ================================================================
     *
     * A strong interview explanation:
     *
     * "I built a CRUD web application using Java Servlets and
     * Apache Tomcat. The application exposes a /users endpoint
     * and supports create, read, update and delete operations.
     *
     * The Servlet handles HTTP requests and responses, while the
     * service layer contains the user-related operations.
     *
     * Initially I used a HashMap as an in-memory data store so that
     * I could focus on understanding Servlet request processing,
     * URL mapping, the Servlet lifecycle and HTTP methods.
     *
     * The persistence layer can then be replaced with JDBC and
     * PostgreSQL without putting database logic directly into the
     * Servlet."
     */


    /*
     * ================================================================
     * 27. COMMON INTERVIEW FOLLOW-UP QUESTIONS
     * ================================================================
     *
     * Q: Why extend HttpServlet?
     *
     * A: HttpServlet provides HTTP-specific request handling and
     *    methods such as doGet(), doPost(), doPut() and doDelete().
     *
     *
     * Q: Who manages the Servlet lifecycle?
     *
     * A: The Servlet container, such as Tomcat.
     *
     *
     * Q: What is the difference between init() and constructor?
     *
     * A: The constructor creates the Java object, while init() is
     *    called by the container to initialize the Servlet.
     *
     *
     * Q: What is service()?
     *
     * A: It is the request-processing method in HttpServlet that
     *    dispatches an HTTP request to the appropriate doXxx()
     *    method.
     *
     *
     * Q: Can multiple clients access the same Servlet simultaneously?
     *
     * A: Yes. Multiple request threads can use the same Servlet
     *    instance, so shared mutable state must be handled carefully.
     *
     *
     * Q: Difference between 400 and 404?
     *
     * A: 400 means the request itself is invalid. 404 means the
     *    requested resource could not be found.
     *
     *
     * Q: Why use a service layer?
     *
     * A: To separate business/application logic from HTTP handling
     *    and improve maintainability, testing and separation of
     *    concerns.
     *
     *
     * Q: Why isn't HashMap a real database?
     *
     * A: It is in-memory storage. Data is lost when the application
     *    process stops and it does not provide database features
     *    such as persistence, transactions and SQL querying.
     */


    /*
     * ================================================================
     * 28. SDE-LEVEL DESIGN PRINCIPLE: SEPARATION OF CONCERNS
     * ================================================================
     *
     * A major design principle demonstrated by this project is:
     *
     *      Separation of Concerns
     *
     * Servlet:
     *      HTTP/API responsibility
     *
     * Service:
     *      Business/application responsibility
     *
     * DAO:
     *      Persistence responsibility
     *
     * Database:
     *      Data persistence
     *
     *
     * This makes individual components easier to:
     *
     * - Understand
     * - Test
     * - Replace
     * - Maintain
     * - Extend
     */


    /*
     * ================================================================
     * 29. THINGS TO LEARN NEXT
     * ================================================================
     *
     * We will continue this project and add:
     *
     * - JDBC
     * - PostgreSQL
     * - DAO layer
     * - PreparedStatement
     * - Connection management
     * - Transactions
     * - Request body / JSON
     * - Jackson
     * - Validation
     * - Exception handling
     * - Proper API responses
     * - HTTP headers
     * - ServletConfig
     * - ServletContext
     * - RequestDispatcher
     * - Forward vs Redirect
     * - Sessions and Cookies
     * - Filters
     * - Listeners
     * - Authentication concepts
     * - Thread safety
     * - Deployment
     * - WAR deployment
     * - Tomcat configuration
     *
     * These concepts will be connected back to this CRUD project
     * instead of being learned in isolation.
     */


    /*
     * ================================================================
     *                         KEY TAKEAWAY
     * ================================================================
     *
     * The most important mental model:
     *
     *      HTTP Request
     *           ↓
     *      Tomcat / Servlet Container
     *           ↓
     *      URL Mapping
     *           ↓
     *      Servlet
     *           ↓
     *      service()
     *           ↓
     *      doGet()/doPost()/doPut()/doDelete()
     *           ↓
     *      Service Layer
     *           ↓
     *      Persistence Layer
     *           ↓
     *      Database
     *
     * And the response travels back in the opposite direction.
     *
     * Understanding this flow is more valuable than memorizing
     * individual Servlet methods.
     *
     * ================================================================
     */
}