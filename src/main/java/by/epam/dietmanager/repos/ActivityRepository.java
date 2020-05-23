package by.epam.dietmanager.repos;

import by.epam.dietmanager.collections.TrainingType;
import by.epam.dietmanager.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByType(TrainingType type);
}
