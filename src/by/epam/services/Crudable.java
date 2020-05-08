package by.epam.services;
import by.epam.dao.Dao;
import by.epam.entity.Entity;
import java.util.ArrayList;
import java.util.Optional;

public interface Service<E extends Entity, DAO extends Dao<E, KEY>, KEY> {

    Optional<E> getEntityByKey(KEY key);

    boolean add(E ob);

    ArrayList<E> getAll();

    boolean update(E entity);

    boolean delete(KEY key);
}
