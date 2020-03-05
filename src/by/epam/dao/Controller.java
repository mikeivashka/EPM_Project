package by.epam.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;


public abstract class Controller<E, K>{
    static Logger log = LogManager.getLogger();
    protected ObjectInputStream inputStream;
    protected ObjectOutputStream outputStream;

    protected void initialize(String dir) {
        try (FileOutputStream ostream = new FileOutputStream(dir);
             FileInputStream istream = new FileInputStream(dir)){
            inputStream = new ObjectInputStream(istream);
            outputStream = new ObjectOutputStream(ostream);
        }
        catch (FileNotFoundException e){
            log.error(e.getStackTrace());
        }
        catch (IOException e){
            log.error(e.getStackTrace());
        }
    }
    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);
}
