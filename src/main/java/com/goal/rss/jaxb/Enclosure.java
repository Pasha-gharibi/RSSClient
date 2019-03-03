package com.goal.rss.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Enclosure {

    @XmlTransient
    private Long id;

    @XmlAttribute(name = "length")
    private String length;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Enclosure{" +
                "length='" + length + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static Enclosure create(Long id, String type, String url,String lenght) {
        Enclosure enc = new Enclosure();
        enc.setId(id);
        enc.setType(type);
        enc.setUrl(url);
        enc.setLength(lenght);
        return enc;
    }
}
