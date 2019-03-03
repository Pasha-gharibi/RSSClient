package com.goal.rss.reader;

import com.goal.rss.jaxb.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBException;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTest {

    @Autowired
    Reader reader;


    @Test(expected = JAXBException.class)
    public void readTset() throws Exception {
        Item[] items = reader.read();
        Assert.assertNotEquals("The goal.com rss returns no feed!", items.length - 1, 0);
    }
}
