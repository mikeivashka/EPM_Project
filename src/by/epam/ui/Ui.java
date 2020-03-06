package by.epam.ui;

import java.io.IOException;
import java.util.Scanner;

import by.epam.dao.Controller;
import by.epam.entity.Activity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Ui<E extends Controller> {
    static Logger log = LogManager.getLogger();
    public E controller;
    public Ui(){
        try {
            controller.load();
        } catch (ClassNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
    }
}
