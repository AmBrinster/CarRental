package com.adobe.cq.impl;


import com.adobe.cq.dao.RegistrationDAO;
import com.adobe.cq.models.Registration;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;


import com.adobe.cq.RegistrationService;



/**
 * One implementation of the {@link RegistrationService}. Note that
 * the repository is injected, not retrieved.
 */
@Service
@Component(metatype = false)
public class RegistrationServiceImpl implements RegistrationService {


    @Override
    public String createRegistration(Registration registration) throws Exception {
        String serviceStatus = RegistrationDAO.callRegistrationService(registration);
        return !serviceStatus.equalsIgnoreCase("200")?"FAILURE":"SUCCESS";
    }
}
