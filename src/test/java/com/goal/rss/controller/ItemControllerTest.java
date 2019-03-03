package com.goal.rss.controller;

import com.goal.rss.config.AppConfig;
import com.goal.rss.jaxb.Category;
import com.goal.rss.jaxb.Enclosure;
import com.goal.rss.jaxb.Item;
import com.goal.rss.reader.Reader;
import com.goal.rss.service.ItemService;
import com.goal.rss.service.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
@ComponentScan("com.goal.rss.*")
@ContextConfiguration(classes = {AppConfig.class, Reader.class, ItemServiceImpl.class})
public class ItemControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ItemService service;

    @Test
    public void givenItem_whenGetItems_thenReturnJsonArray() throws Exception {

        Category category = Category.create("myDomain", "myContent");
        List<Category> categories = Arrays.asList(category);
        Enclosure enclosure = Enclosure.create(null, "myType", "myUrl", "myLenght");

        Item feed = Item.create("myComment",enclosure,"myLink","myGuid","myDesc","BARCELONAAAAA!!!",categories.toArray(new Category[categories.size()]),"");
        service.save(feed);
        mvc.perform(get("/api/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(feed.getTitle())))
                .andExpect(jsonPath("$[0].category[0].domain", is(category.getDomain())))
        ;
    }


}
