package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer> {
    Nutritionist findByEmail(String email);
    Optional<Nutritionist> findById(Integer id);
}
