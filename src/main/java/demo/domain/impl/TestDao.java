package demo.domain.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import demo.domain.ITestDao;
@Repository
public class TestDao implements ITestDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List test() {
		String sql = "SELECT * FROM file_in_server";
		List list = jdbcTemplate.queryForList(sql);
		return list;
	}

	@Override
	public void testTransaction() {
		String delSql = "DELETE FROM file_in_server WHERE object_id = '1'";
		jdbcTemplate.update(delSql);
		String addSql = "INSERT INTO file_block VALUES ('123456789',1,10)";
		jdbcTemplate.update(addSql);
	}

}
