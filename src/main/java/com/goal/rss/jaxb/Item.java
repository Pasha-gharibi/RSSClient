package com.goal.rss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlTransient
    private Long id;

    @XmlElement(name = "comments")
    private String comments;

    @XmlElement(name = "enclosure")
    private Enclosure enclosure;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "guid")
    private String guid;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "category")
    private Category[] category;

    @XmlElement(name = "pubDate")
    private String pubDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category[] getCategory() {
        return category;
    }

    public void setCategory(Category[] category) {
        this.category = category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }


    @Override
    public String toString() {
        return "Item{" +
                "comments='" + comments + '\'' +
                ", enclosure=" + enclosure +
                ", link='" + link + '\'' +
                ", guid='" + guid + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", category=" + Arrays.toString(category) +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }

    public static Item create(String comments, Enclosure enclosure, String link, String guid, String description, String title, Category[] category, String pubDate) {
        Item item = new Item();
        item.comments = comments;
        item.enclosure = enclosure;
        item.link = link;
        item.guid = guid;
        item.description = description;
        item.title = title;
        item.category = category;
        item.pubDate = pubDate;
        return item;
    }
}
