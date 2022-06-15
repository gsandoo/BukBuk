package bukbuk.firstpro.repository;

import bukbuk.firstpro.model.BukReviewDTO;
import bukbuk.firstpro.model.BukServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sql = null;

    @Autowired
    public ReviewDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BukReviewDTO> list() {
        List<BukReviewDTO> list = null;

        sql = "select * from buk_review";

        return list = this.jdbcTemplate.query(sql, new RowMapper<BukReviewDTO>() {
            @Override
            public BukReviewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BukReviewDTO dto = new BukReviewDTO();

                dto.setReview_id(rs.getString("review_id"));
                dto.setBook_title(rs.getString("book_title"));
                dto.setReview_rate(rs.getDouble("review_rate"));
                dto.setReview_title(rs.getString("review_title"));
                dto.setReview_context(rs.getString("review_context"));
                dto.setReview_date(rs.getString("review_date"));

                return dto;
            }

        });
    }


}
