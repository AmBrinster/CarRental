package com.adobe.cq;

import com.adobe.cq.models.Registration;

/**
 * A simple service interface
 */
public interface RegistrationService {
    
    String createRegistration(Registration registration) throws Exception;
}