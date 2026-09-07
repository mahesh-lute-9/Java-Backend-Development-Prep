package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    /*
     * For now, HashMap acts as our in-memory database.
     *
     * Key   -> User ID
     * Value -> User object
     *
     * Later, this will be replaced with DAO + JDBC + PostgreSQL.
     */
    private final Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    // CREATE
    public User createUser(User userReq) {
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    // READ - Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    // READ - Get user by ID
    public User getUserById(Integer id) {
        return userDB.get(id);
    }

    // UPDATE
    public User updateUser(Integer id, User userReq) {

        /*
         * Before updating, check whether the user exists.
         * Otherwise, an update request could create a new entry.
         */
        if (!userDB.containsKey(id)) {
            return null;
        }

        userReq.setId(id);
        userDB.put(id, userReq);

        return userReq;
    }

    // DELETE
    public boolean deleteUser(Integer id) {
        return userDB.remove(id) != null;
    }
}