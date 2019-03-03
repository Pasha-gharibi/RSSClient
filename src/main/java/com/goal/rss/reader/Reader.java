package com.goal.rss.reader;

/**
 * Created by p.gharibi on 3/2/2019.
 */


import com.goal.rss.jaxb.Item;
import com.goal.rss.jaxb.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class Reader {


    @Autowired
    URL url;


    /*
        A temporary array of recent GUIDs of feeds to cache latests.
     */
    public static List<String> lastGUIDs = new ArrayList<>();

    public Item[] read() throws JAXBException {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Rss rss = (Rss) unmarshaller.unmarshal(url.openStream());

            System.out.println(rss.toString());

            return rss.getChannel().getItem();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
