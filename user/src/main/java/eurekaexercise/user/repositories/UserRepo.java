package eurekaexercise.user.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eurekaexercise.user.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}

