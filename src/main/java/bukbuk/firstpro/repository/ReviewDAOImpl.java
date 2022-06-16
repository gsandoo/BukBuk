package bukbuk.firstpro.repository;

import bukbuk.firstpro.model.BukReviewDTO;
import bukbuk.firstpro.model.BukServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
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
    public List<BukReviewDTO> list(String book_title) {

        sql = "select * from buk_review where book_title = ?";

        return (List<BukReviewDTO>) this.jdbcTemplate.queryForObject(sql, new RowMapper<BukReviewDTO>() {
            @Override
            public BukReviewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BukReviewDTO dto = new BukReviewDTO();

                dto.setReview_id(rs.getString("review_id"));
                dto.setBook_title(rs.getString("book_title"));
                dto.setReview_rate(rs.getDouble("review_rate"));
                dto.setReview_title(rs.getString("review_title"));
                dto.setReview_context(rs.getString("review_context"));
                dto.setReview_date(rs.getString("review_date"));
                dto.setReview_num(rs.getByte("review_num"));

                return dto;
            }

        }, book_title);
    }

    @Override
    public int insertReview(BukReviewDTO dto) {
        sql = "select nvl(max(review_num), 0) from buk_review";

        int max_num = this.jdbcTemplate.queryForObject(sql, Integer.class);

        sql = "insert into buk_review values(?, ?, ?, ?, ?, sysdate, ?)";

        return this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                     ps.setString(1, dto.getReview_id());
                     ps.setString(2, dto.getBook_title());
                     ps.setDouble(3, dto.getReview_rate());
                     ps.setString(4, dto.getReview_title());
                     ps.setString(5, dto.getReview_context());
                     ps.setInt(6, max_num + 1);
            }
        });
    }


}
