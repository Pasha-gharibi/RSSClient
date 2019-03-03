package com.goal.rss.repository;

import com.goal.rss.config.AppConfig;
import com.goal.rss.jaxb.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by p.gharibi on 3/3/2019.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class, EnclosureRepository.class,ItemRepository.class})
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void insertTest(){
        //insert
        Item item = Item.create("myComment",null,"myLink","myGuid","","",null,"");
        itemRepository.insert(item);
        System.out.println("item: "+ item.toString() +" inserted" );
        List<Item> items = itemRepository.findTopTen();
        given(itemRepository.findTopTen()).willReturn(Arrays.asList(item));
    }

}
