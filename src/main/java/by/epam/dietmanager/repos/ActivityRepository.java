package by.epam.dietmanager.repos;

import by.epam.dietmanager.collections.TrainingType;
import by.epam.dietmanager.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ActivityRepository")
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
    List<Activity> findByType(TrainingType type);
}
