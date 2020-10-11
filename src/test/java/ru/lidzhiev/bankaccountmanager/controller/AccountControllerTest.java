package ru.lidzhiev.bankaccountmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.lidzhiev.bankaccountmanager.repository.AccountRepository;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class AccountControllerTest {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private MockMvc mvc;

    private JSONParser parser = new JSONParser();

    @BeforeEach
    @Sql(scripts = "classpath:/data.sql")
    void setup() {

    }


    @Test
    void transferMoney() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/transferMoney")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input("json/TransferMoney.json"))).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void putMoney() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/putMoney")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input("json/PutAndWithdrawMoney.json"))).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void withDraw() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/withDraw")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input("json/PutAndWithdrawMoney.json"))).andReturn();
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    private String input(String fileName) throws IOException, ParseException {
        URL url = getClass().getClassLoader().getResource(fileName);
        Object obj = parser.parse(new FileReader(url.getPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}