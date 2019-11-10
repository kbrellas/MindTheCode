package com.example.demo;

import com.example.demo.mappers.UserMapper;
import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperShould {
    private UserMapper mapper;
    private UserRepository userRepository;
    private List<User> userInput = new ArrayList<>();
    private List<UserResponse> expectedOutput = new ArrayList<>();

    @Before
    public void setup(){
        mapper = new UserMapper();
        User kostas = new User("Kwtso","Mprellas",40, User.Status.PLATINUM);
        User mitsos = new User("Mitsos","Mitsaras",20, User.Status.GOLD);
        kostas.setId(1);
        mitsos.setId(2);
        userInput.add(kostas);
        userInput.add(mitsos);
        UserResponse kwtsos = new UserResponse(1,"Kwtso Mprellas",40,"platinum");
        UserResponse makis = new UserResponse(1,"Mitsos Mitsaras",20,"gold");
        expectedOutput.add(kwtsos);
        expectedOutput.add(makis);

    }

    @Test
    public void mapUserToUserResponse(){
        List<UserResponse> output = mapper.mapUsers(userInput);
        Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));
    }
}
