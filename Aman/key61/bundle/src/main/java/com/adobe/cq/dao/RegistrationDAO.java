package com.adobe.cq.dao;

import com.adobe.cq.models.Registration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class RegistrationDAO {

    public static String callRegistrationService(Registration registration) throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/registration/users");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(registration);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        int status = response.getStatusLine().getStatusCode();
        client.close();
        return String.valueOf(status);


    }

}
