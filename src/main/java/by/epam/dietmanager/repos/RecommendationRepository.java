package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.model.Recommendation;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Set;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
     Set<Recommendation> findByAuthorId(Integer id);
     Set<Recommendation> findByReceiverId(Integer id);
     Set<Recommendation> findByReceiverIdAndAuthorId(Integer receiverId, Integer authorId);
     Set<Recommendation> findByDateBetween(Date start, Date end);
}
