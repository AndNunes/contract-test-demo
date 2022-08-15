package com.contract.consumer.contractconsumer.service.impl;

import com.contract.consumer.contractconsumer.model.User;
import com.contract.consumer.contractconsumer.model.dto.UserDto;
import com.contract.consumer.contractconsumer.service.ConsumerService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static final String URL_APPLICATION_KEY = "api.url";
    private static final String PATH_API = "/user";
    private Client client;
    private WebTarget webTarget;
    private Gson gson;

    @Autowired
    private Environment env;

    public ConsumerServiceImpl() {
        client = ClientBuilder.newClient();
        gson = new Gson();
    }

    @Override
    public User registerUser(UserDto userDto) throws IOException {

        webTarget = client
                .target(env.getProperty(URL_APPLICATION_KEY))
                .path(PATH_API);

        Response response = getInvocation(webTarget)
                .post(Entity.json(userDto));

        return convertToUser(response.readEntity(String.class));
    }

    @Override
    public List<User> searchAllUsers() {
        webTarget = client
                .target(env.getProperty(URL_APPLICATION_KEY))
                .path(PATH_API);

        Response response = getInvocation(webTarget)
                .get();

        return convertToAListOfUser(response.readEntity(String.class));
    }

    @Override
    public User searchUser(Long id) throws IOException {

        webTarget = client
                .target(env.getProperty(URL_APPLICATION_KEY))
                .path(PATH_API + "/" +  id);

        Response response = getInvocation(webTarget)
                .get();

       return convertToUser(response.readEntity(String.class));
    }

    private Invocation.Builder getInvocation(WebTarget webTarget) {
        return webTarget
                .request()
                .header("Content-Type", MediaType.APPLICATION_JSON);
    }

    private User convertToUser(String userResponse) {
        return gson.fromJson(userResponse, User.class);
    }

    private List<User> convertToAListOfUser(String userResponse) {
        return gson.fromJson(userResponse, new TypeToken<List<User>>(){}.getType());
    }
}
