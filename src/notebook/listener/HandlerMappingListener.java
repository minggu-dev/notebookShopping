package notebook.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import notebook.controller.Controller;

/**
 * Application Lifecycle Listener implementation class HandlerMappingListener
 *
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)  { 
//    	Map<String, Controller> map = new HashMap<String, Controller>();
//    	ServletContext application = sce.getServletContext();
//    	String fileName = application.getInitParameter("fileName");
//    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
//    	Set<String> keys = rb.keySet();
//    	
//    	try {
//	    	for(String key : keys) {
//	    		String value = rb.getString(key);
//	    		Controller controller = (Controller)Class.forName(value).newInstance();
//	    		map.put(key, controller);
//	    	}
//    	}catch (Exception e) {
//    		e.printStackTrace();
//		}
//    	
//    	application.setAttribute("map", map);
    }
    public void contextDestroyed(ServletContextEvent sce)  {}
}
