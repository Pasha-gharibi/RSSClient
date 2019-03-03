package com.goal.rss.repository;

import com.goal.rss.jaxb.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@Repository
public class ItemRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Long insert(Item item) {

        String insertSql = "INSERT INTO item ( comments, link, guid, description ,title, pubDate) VALUES(?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(insertSql, new String[]{"id"});
                        ps.setString(1, item.getComments());
                        ps.setString(2, item.getLink());
                        ps.setString(3, item.getGuid());
                        ps.setString(4, item.getDescription());
                        ps.setString(5, item.getTitle());
                        ps.setString(6, item.getPubDate());
                        return ps;
                    }
                },
                keyHolder);

        return keyHolder.getKey().longValue();
    }

    public List<Item> findTopTen() {
        return jdbcTemplate.query("select top 10 * from item order by id desc ", new ItemRowMapper());
    }

    class ItemRowMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setComments(rs.getString("comments"));
            item.setLink(rs.getString("link"));
            item.setGuid(rs.getString("guid"));
            item.setDescription(rs.getString("description"));
            item.setTitle(rs.getString("title"));
            item.setPubDate(rs.getString("pubdate"));
            return item;
        }

    }



}
