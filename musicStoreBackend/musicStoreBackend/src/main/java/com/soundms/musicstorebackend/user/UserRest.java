package com.soundms.musicstorebackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User/")
public class UserRest {

    /* User service layer methods */
    @Autowired
    private UserService userService;

    /* API endpoints - CRUD operations */

    /*--------------------------------------------------------------------------------------------------------
     * createUser: method that saves a user in the DB;
     *
     * @param user - an object containing all the user data;
     * * @return - the created and saved user in the DB;
     *
      --------------------------------------------------------------------------------------------------------*/
    @PostMapping
    private User createUser(@RequestBody User userin){
        return userService.createUser(userin);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getAllUsers: returns all users from the DB;
     *
     * @return - a list with all the users present in the DB;
      --------------------------------------------------------------------------------------------------------*/
    @GetMapping
    private List<User> getAllUsers(){
        return userService.findAll();
    }

    /*--------------------------------------------------------------------------------------------------------
     * getUserById: gets a user from the DB using its id;
     *
     * @param id_user - the user id;
     * @return - the user data found in the DB;
      --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/{id_user}")
    private User getUserById(@PathVariable Long id_user){
        return userService.getUserById(id_user);
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateUser: method that updates the user data given the id;
     *
     * @param userUpdate - the object containing the new data;
     * @return - user data updated;
     --------------------------------------------------------------------------------------------------------*/
    @PutMapping
    private User updateUser(@RequestBody User userUpdate){
        return userService.updateUser(userUpdate);
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdUser: method that deletes a user from the DB;
     *
     * @param id - id from the user to be deleted;
     *
     --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable Long id){
        userService.deleteByIdUser(id);
    }
}
