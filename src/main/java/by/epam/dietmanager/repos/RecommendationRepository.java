package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Set;

public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
     Set<Recommendation> findByAuthorId(Integer id);
     Set<Recommendation> findByReceiverId(Integer id);
     Set<Recommendation> findByDateBetween(Date start, Date end);
}
