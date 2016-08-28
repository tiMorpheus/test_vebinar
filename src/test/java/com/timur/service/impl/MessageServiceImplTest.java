package test.com.timur.service.impl;

import main.com.timur.service.MessageService;
import main.com.timur.service.impl.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MessageServiceImplTest {
    MessageService service;

    @Before
    public void init(){
        service = new MessageServiceImpl();
    }
    @Test
    public void getGreetings() throws Exception {
        String name = "Timur";
        String expected = "Hello, Timur! How are you?";

        String actual = service.getGreetings(name);

        Assert.assertEquals(expected, actual);
    }

}