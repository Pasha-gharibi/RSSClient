package com.goal.rss.repository;

import com.goal.rss.config.AppConfig;
import com.goal.rss.jaxb.Category;
import com.goal.rss.jaxb.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by p.gharibi on 3/3/2019.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class, CategoryRepository.class,ItemRepository.class})
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void CategoryListCrudTest() {

        //insert
        Item item = new Item();
        item.setGuid("myGuid");
        Long itemId = itemRepository.insert(item);
        Category category = new Category();
        category.setContent("myContent");
        categoryRepository.insertCategoryList(itemId, Arrays.asList(category));
        System.out.println("category: " + category.toString() +" has saved!");

        List<Category> saved = categoryRepository.findByItemId(itemId);
        Assert.assertNotNull(saved);
        Assert.assertEquals("myContent", saved.get(0).getContent());

        System.out.println("seved category would be" + saved.toString());


    }
}