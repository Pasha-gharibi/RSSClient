package com.goal.rss.repository;

import com.goal.rss.jaxb.Enclosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@Repository
public class EnclosureRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertEnclosure(Long itemId, final Enclosure enclosure) {

        String sql = " INSERT INTO  enclosure( item_id, lngt, type, url)  VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{itemId, enclosure.getLength(), enclosure.getType(), enclosure.getUrl()});

    }

    public Enclosure findByItemId(Long itemId) {
        return jdbcTemplate.queryForObject("select * from enclosure where item_id =" + itemId, new BeanPropertyRowMapper<Enclosure>(Enclosure.class));
    }

}
