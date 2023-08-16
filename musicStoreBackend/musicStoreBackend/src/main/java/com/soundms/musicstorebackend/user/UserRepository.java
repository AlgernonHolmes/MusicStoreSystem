package com.soundms.musicstorebackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /* abstract methods for springboot implementation */

    public User getUsuarioByid(Long id);

}
