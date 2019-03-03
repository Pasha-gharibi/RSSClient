package com.goal.rss.service.impl;

import com.goal.rss.jaxb.Category;
import com.goal.rss.jaxb.Enclosure;
import com.goal.rss.jaxb.Item;
import com.goal.rss.repository.CategoryRepository;
import com.goal.rss.repository.EnclosureRepository;
import com.goal.rss.repository.ItemRepository;
import com.goal.rss.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EnclosureRepository enclosureRepository;

    @Override
    public void save(Item item) {
        Long savedId = itemRepository.insert(item);
        enclosureRepository.insertEnclosure(savedId, item.getEnclosure());
        categoryRepository.insertCategoryList(savedId, Arrays.asList(item.getCategory()));
    }

    @Override
    public List<Item> getLastTen() {
        List<Item> itemList = itemRepository.findTopTen();
        for (Item item : itemList) {
            List<Category> categoryList = categoryRepository.findByItemId(item.getId());

            item.setCategory(categoryList.toArray(new Category[categoryList.size()]));
            Enclosure enclosure = enclosureRepository.findByItemId(item.getId());
            item.setEnclosure(enclosure);
        }
        return itemList;
    }
}
































