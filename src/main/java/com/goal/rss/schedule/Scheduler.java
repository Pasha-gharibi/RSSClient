package com.goal.rss.schedule;

import com.goal.rss.config.Dashboard;
import com.goal.rss.jaxb.Item;
import com.goal.rss.reader.Reader;
import com.goal.rss.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@Component
public class Scheduler {

    @Autowired
    Reader reader;

    @Autowired
    ItemService itemService;

    @Scheduled(cron = Dashboard.GOAL_SCHEDULE_CRON)
    void readGoalRssFeeds() throws JAXBException {
        Item[] items = reader.read();

            /*
                check if current feeds exist in last temporary feeds
             */
        for (Item item : items) {
            if (!Reader.lastGUIDs.contains(item.getGuid())) {
                itemService.save(item);
            }
        }
            /*
                refresh all temporary rss guids
             */
        Reader.lastGUIDs = Arrays.stream(items).map(i -> i.getGuid()).collect(Collectors.toList());
    }

}
