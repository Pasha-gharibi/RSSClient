package com.goal.rss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {

    @XmlElement(name = "image")
    private Image image;

    @XmlElement(name = "copyright")
    private String copyright;

    @XmlElement(name = "item")
    private Item[] item;

    @XmlElement(name = "lastBuildDate")
    private String lastBuildDate;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "language")
    private String language;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "category")
    private Category[] category;

    @XmlElement(name = "pubDate")
    private String pubDate;

    @XmlElement(name = "ttl")
    private String ttl;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "image=" + image +
                ", copyright='" + copyright + '\'' +
                ", item=" + Arrays.toString(item) +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", category=" + Arrays.toString(category) +
                ", pubDate='" + pubDate + '\'' +
                ", ttl='" + ttl + '\'' +
                '}';
    }
}
