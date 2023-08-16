package com.soundms.musicstorebackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class UserService{

    /* Repository layer methods */
    @Autowired
    private UserRepository userRepo;

    /* Services available */


    /*--------------------------------------------------------------------------------------------------------
     * createUser: method that saves a user in the DB;
     *
     * @param user - an object containing all the user data;
     * * @return - the created and saved user in the DB;
     *
      --------------------------------------------------------------------------------------------------------*/
    public User createUser(User userin){
        return userRepo.save(userin);
    }

    /*--------------------------------------------------------------------------------------------------------
     * getUserById: method that obtains a specific user from DB using its id;
     *
     * @param id-user - the id of the user;
     * @return - the user data in the DB;
     --------------------------------------------------------------------------------------------------------*/
    public User getUserById(Long id_user){
        return userRepo.getUsuarioByid(id_user);
    }

    /*--------------------------------------------------------------------------------------------------------
     * findAll: method to find all users in the DB;
     *
     * @return - a list with all users;
     --------------------------------------------------------------------------------------------------------*/
    public List<User> findAll(){
        return userRepo.findAll();
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateUser: method that updates the user data given the id;
     *
     * @param userUpdate - the object containing the new data;
     * @return - user data updated;
     --------------------------------------------------------------------------------------------------------*/
    public User updateUser(User userUpdate) {
        User present = userRepo.findById(userUpdate.getId()).orElse(null);
        if (present != null) {
            present.setId(userUpdate.getId());
            present.setName(userUpdate.getName());
            present.setPassword(userUpdate.getPassword());
            present.setEmail(userUpdate.getEmail());
            return userRepo.save(present);
        } else {
            return null;
        }
    }

    /*--------------------------------------------------------------------------------------------------------
     * deleteByIdUser: method that deletes a user from the DB;
     *
     * @param id - id from the user to be deleted;
     *
     --------------------------------------------------------------------------------------------------------*/
    public void deleteByIdUser(Long id) {
        userRepo.deleteById(id);
    }

}
