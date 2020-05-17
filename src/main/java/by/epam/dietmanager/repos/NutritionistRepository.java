package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer> {
    Nutritionist findByEmail(String email);
}
