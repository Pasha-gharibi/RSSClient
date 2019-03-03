package com.goal.rss.service;

import com.goal.rss.config.AppConfig;
import com.goal.rss.jaxb.Item;
import com.goal.rss.reader.Reader;
import com.goal.rss.repository.CategoryRepository;
import com.goal.rss.repository.EnclosureRepository;
import com.goal.rss.repository.ItemRepository;
import com.goal.rss.service.impl.ItemServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@RunWith(SpringRunner.class)
@ComponentScan("com.goal.rss.*")
@ContextConfiguration(classes = {AppConfig.class, Reader.class, ItemServiceImpl.class, ItemRepository.class, CategoryRepository.class, EnclosureRepository.class})
public class ItemServiceTest {

    @Autowired
    ItemService service;

    @Autowired(required = true)
    Reader reader;


    @Before
    public void setup() throws Exception {
        Item[] items = reader.read();
        for (Item item : items) {
            service.save(item);
        }
    }

    @Test
    public void ImSureItsTenItem() throws Exception {

        List<Item> itemList = service.getLastTen();
        Assert.assertEquals(10, itemList.size());

    }

}
