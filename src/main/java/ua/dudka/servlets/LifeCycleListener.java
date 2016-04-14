package ua.dudka.servlets; /**
 * Created by RASTA on 19.03.2016.
 */

import ua.dudka.store.util.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class LifeCycleListener implements ServletContextListener {
    public LifeCycleListener() {

    }

    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.shutdown();
    }


}
