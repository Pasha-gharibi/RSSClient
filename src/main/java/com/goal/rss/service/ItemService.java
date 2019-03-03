package com.goal.rss.service;

import com.goal.rss.jaxb.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by p.gharibi on 3/2/2019.
 */
public interface ItemService {
    void save(Item item);

    List<Item> getLastTen();

}
