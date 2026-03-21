package com.prashant.fooddelivery.controller;

import com.prashant.fooddelivery.dto.UserResponseDTO;
import com.prashant.fooddelivery.model.User;
import com.prashant.fooddelivery.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/* * CONTROLLER LAYER: The "Receptionist" of the app.
 * It receives web requests and sends back responses.
 * @RestController Marks this class as a REST API controller.
 * Spring will automatically convert return values into JSON responses.*/
@RestController

// * Base URL for all endpoints inside this controller.
// * Every API here will start with /users
@RequestMapping("/users")
public class UserController {

    // Service layer dependency
    // Controller should not directly talk to database
    private final UserService userService;

    /*
     * Constructor Injection
     * Spring automatically provides the UserService bean here.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* * API: Create/Register a new user
     * Endpoint: POST /users/register
     * @RequestBody tells Spring to convert JSON request into a User object */
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody User user) {
        // Delegate business logic to the service layer
//        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return userService.createUser(user);
    }

    /* * API: Fetch all users
     * Endpoint: GET /users
     * Returns a list of all users stored in the database */
    @GetMapping
    public List<UserResponseDTO> getUsers() {

        // Call service layer which fetches data from repository/database
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    //* @PathVariable maps the ID from the URL to the 'id' parameter.
    public UserResponseDTO getUserById(@PathVariable Long id) {
        // We call the service and return the safe DTO
        return userService.getUserById(id);
    }




}
