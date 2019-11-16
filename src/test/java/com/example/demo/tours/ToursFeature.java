package com.example.demo.tours;

import com.example.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//Annotations auta ta xrhsimopoioume gia na dhlwsoume oti 8a tre3ei to spring boot
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToursFeature {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc=webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllTours(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/tour-office/allTours").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json(allToursJson()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String allToursJson() {
        String json = "{\n" +
                "    \"tourResponses\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"price\": 50,\n" +
                "            \"discount\": 10,\n" +
                "            \"finalPrice\": 40,\n" +
                "            \"title\": \"sightseeing\",\n" +
                "            \"shortDesc\": \"athens sites\",\n" +
                "            \"longDesc\": \"a tour to see all ancient Athens\",\n" +
                "            \"tourPackageTitle\": \"best one\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"price\": 10,\n" +
                "            \"discount\": 5,\n" +
                "            \"finalPrice\": 5,\n" +
                "            \"title\": \"sightseeing\",\n" +
                "            \"shortDesc\": \"kallithea sites\",\n" +
                "            \"longDesc\": \"manhattan of athens\",\n" +
                "            \"tourPackageTitle\": \"best one\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"price\": 400,\n" +
                "            \"discount\": 50,\n" +
                "            \"finalPrice\": 350,\n" +
                "            \"title\": \"full day in karitena\",\n" +
                "            \"shortDesc\": \"eat and drink in karetina\",\n" +
                "            \"longDesc\": \"eat and drink in karetina\",\n" +
                "            \"tourPackageTitle\": \"Peloponese mountain\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"price\": 400,\n" +
                "            \"discount\": 50,\n" +
                "            \"finalPrice\": 350,\n" +
                "            \"title\": \"full day in dimitsana\",\n" +
                "            \"shortDesc\": \"eat and drink in dimitsana\",\n" +
                "            \"longDesc\": \"eat and drink in dimitsana\",\n" +
                "            \"tourPackageTitle\": \"Peloponese mountain\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"price\": 400,\n" +
                "            \"discount\": 50,\n" +
                "            \"finalPrice\": 350,\n" +
                "            \"title\": \"rafting in Lusious river\",\n" +
                "            \"shortDesc\": \"very nice\",\n" +
                "            \"longDesc\": \"really good day\",\n" +
                "            \"tourPackageTitle\": \"Peloponese mountain\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"price\": 10,\n" +
                "            \"discount\": 5,\n" +
                "            \"finalPrice\": 5,\n" +
                "            \"title\": \"sightseeing\",\n" +
                "            \"shortDesc\": \"kallithea sites\",\n" +
                "            \"longDesc\": \"manhattan of athens\",\n" +
                "            \"tourPackageTitle\": \"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return json;
    }
}
