package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    Optional<Client> findById(Integer id);
}
