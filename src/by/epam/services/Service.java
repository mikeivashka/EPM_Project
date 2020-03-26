package by.epam.services;

import by.epam.dao.Dao;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Service <E extends Entity, KEY, DAO extends Dao<E,KEY>> {
    static Logger log = LogManager.getLogger();
    protected ArrayList <E> data;
    protected DAO dao;
    public  E getEntityByKey(KEY key){
        try {
            for(E obj : data) {
                if (obj.hashCode() == key.hashCode()) return obj;
            }
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            log.error("OBJECT NOT FOUND EXCEPTION");
        }
        return data.get(0);
    }
}
