package com.goal.rss.jaxb;

import javax.xml.bind.annotation.*;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlTransient
    private Long id;

    @XmlAttribute(name = "domain")
    private String domain;

    @XmlValue
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Category{" +
                "domain='" + domain + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static Category create(String domain, String content) {
        Category category = new Category();
        category .domain = domain;
        category .content = content;
        return category;
    }
}
