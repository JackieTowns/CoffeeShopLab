package co.grandcircus.coffeeshop.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.coffeeshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
}
