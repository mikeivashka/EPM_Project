package by.epam.services;

import by.epam.dao.Dao;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Service <E extends Entity, KEY, DAO extends Dao<E>> {
    static Logger log = LogManager.getLogger();
    protected ArrayList <E> data;
    protected DAO dao;

    public Service(){
        this.data = dao.load();
    }

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
    protected Integer getIndexByKey(KEY key){
        for(int i=0; i<data.size()-1;i++) {
            if (data.get(i).hashCode() == key.hashCode()) return i;
        }
        return -1;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dao.save(data);
    }

    public abstract E consoleBuilder();

    public abstract void consoleManager();
}
