package bukbuk.firstpro.repository;

import bukbuk.firstpro.model.BukServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sql = null;

    @Autowired
    public ServiceRepositoryImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public BukServiceDTO save(BukServiceDTO dto) {
        return null;
    }

    @Override
    public Optional<BukServiceDTO> findById(String service_title) {
        List<BukServiceDTO> result = jdbcTemplate.query("select * from buk_service where service_id = ?", bukServiceDTORowMapper(), service_title);

        return result.stream().findAny();
    }

    @Override
    public List<BukServiceDTO> findAll() {
        return jdbcTemplate.query("select * from buk_service", bukServiceDTORowMapper());
    }

    @Override
    public List<BukServiceDTO> test() {
        List<BukServiceDTO> list = null;

        sql = "select * from buk_service";

        return list = this.jdbcTemplate.query(sql, new RowMapper<BukServiceDTO>() {
            @Override
            public BukServiceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BukServiceDTO dto = new BukServiceDTO();

                dto.setService_category(rs.getInt("service_category"));
                dto.setService_id(rs.getString("service_id"));
                dto.setService_title(rs.getString("service_title"));
                dto.setService_context(rs.getString("service_context"));
                dto.setService_date(rs.getString("service_date"));
                dto.setService_hit(rs.getInt("service_hit"));
                dto.setService_group(rs.getInt("service_group"));
                dto.setService_step(rs.getInt("service_step"));
                dto.setService_indent(rs.getInt("service_indent"));

                return dto;
            }

        });

    }

    private RowMapper<BukServiceDTO> bukServiceDTORowMapper(){
        return new RowMapper<BukServiceDTO>(){

            @Override
            public BukServiceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BukServiceDTO dto = new BukServiceDTO();
                dto.setService_id(rs.getString("service_id"));
                dto.setService_title(rs.getString("service_title"));

                return dto;

            }
        };
    }
}
