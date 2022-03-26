package Listeners;

import com.mysql.cj.Session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 public class SessionListener implements HttpSessionListener {
     @Override
     public void sessionCreated(HttpSessionEvent httpSessionEvent) {
         System.out.println("session created");
     }

     @Override
     public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

     }
 }
