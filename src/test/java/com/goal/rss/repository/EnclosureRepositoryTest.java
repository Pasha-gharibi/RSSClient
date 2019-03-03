package com.goal.rss.repository;

import com.goal.rss.config.AppConfig;
import com.goal.rss.jaxb.Enclosure;
import com.goal.rss.jaxb.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class, EnclosureRepository.class,ItemRepository.class})
public class EnclosureRepositoryTest {

    @Autowired
    EnclosureRepository enclosureRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void EnclosureCrudTest() {

        //insert
        Item item = new Item();
        item.setGuid("myGuid");
        Long itemId = itemRepository.insert(item);
        Enclosure enclosure = new Enclosure();
        enclosure.setType("myType");
        enclosureRepository.insertEnclosure(itemId, enclosure);
        System.out.println("enclosure: " + enclosure.toString() +" has saved!");


        //read
        Enclosure saved = enclosureRepository.findByItemId(itemId);
        Assert.assertNotNull(saved);
        Assert.assertEquals("myType", saved.getType());

        System.out.println("seved enclosure would be" + saved.toString());

    }


}