package com.adobe.cq;

import com.adobe.cq.impl.RegistrationServiceImpl;
import com.adobe.cq.models.Registration;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;


@SlingServlet(paths = "/bin/customservlet")
/*@SlingServlet(resourceTypes = "service/postRegistrationDetails",
        extensions = "html",
        methods = "GET",
        metatype = true)*/
public class RegistrationServlet extends SlingAllMethodsServlet {
    Logger log = LoggerFactory.getLogger(this.getClass());
    RegistrationService registrationService = new RegistrationServiceImpl();


    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        log.info("Registration Servlet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! doPost22");
        log.debug("Registration Servlet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! doPost22");
        log.error("Registration Servlet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! doPost22");
        String result = "";
        Registration registration = new Registration();
        registration.setFirstName( request.getParameter("materialRegisterFormFirstName"));
        registration.setLastName( request.getParameter("materialRegisterFormLastName"));
        registration.setEmail( request.getParameter("materialRegisterFormEmail"));
        registration.setPassword( request.getParameter("materialRegisterFormPassword"));
        registration.setPhoneNumber( request.getParameter("materialRegisterFormPhone"));

       try {
            result = registrationService.createRegistration(registration);
       }catch (Exception ex){
           log.error("Exception while calling createRegistration - {}",ex.getMessage());
       }
        if("SUCCESS".equals(result)){
            log.info("Registration Successfull");
        }
        else{
            log.info("Registration Error");
        }



    }


}
