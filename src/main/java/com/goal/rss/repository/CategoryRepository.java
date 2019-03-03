package com.goal.rss.repository;

import com.goal.rss.jaxb.Category;
import com.goal.rss.jaxb.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by p.gharibi on 3/2/2019.
 */
@Repository
public class CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertCategoryList(Long itemId, final List<Category> categoryList) {

        String sql = " INSERT INTO  category ( item_id, domain, content) VALUES (?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {

                Category category = categoryList.get(i);
                ps.setLong(1, itemId);
                ps.setString(2, category.getDomain());
                ps.setString(3, category.getContent());

            }

            @Override
            public int getBatchSize() {
                return categoryList.size();
            }
        });

    }


    public List<Category> findByItemId(Long itemId) {
        return jdbcTemplate.query("select * from category where item_id =" + itemId, new CategoryRowMapper());
    }

    class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setDomain(rs.getString("domain"));
            category.setContent(rs.getString("content"));

            return category;
        }

    }
}
