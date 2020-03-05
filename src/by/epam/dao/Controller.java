package by.epam.dao;


import java.io.*;
import java.util.List;

public abstract class Controller<E, K>{
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);
}
