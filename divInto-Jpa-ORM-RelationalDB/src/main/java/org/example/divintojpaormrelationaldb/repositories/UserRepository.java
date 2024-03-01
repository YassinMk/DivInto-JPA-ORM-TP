package org.example.divintojpaormrelationaldb.repositories;

import org.example.divintojpaormrelationaldb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
