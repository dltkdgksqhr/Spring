package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;
					}
				},
				email);

		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder(); //JdbcTamplate에서 자동으로 생성된 키 값 구하기 위해 사용
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) "+
						"values (?, ?, ?, ?)",
						new String[] {"ID"}); // String[] id는 칼럼이 자동 증가 키 칼럼, 자동 생성되는 키 칼럼 목록을 지정할 때 사용된다.
				// 인덱스 파라미터 값 설정
				pstmt.setString(1,  member.getEmail());
				pstmt.setString(2,  member.getPassword());
				pstmt.setString(3,  member.getName());
				pstmt.setTimestamp(4,  
						new Timestamp(member.getRegisterDate().getTime()));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey(); //Number 타입으로 리턴 (KeyHolder)
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update("update MEMBER set NAME =?, PASSWORD =? where EMAIL=?",
				             member.getName(),member.getPassword(),member.getEmail());
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Member member = new Member(rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;
					}
				});
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}
}
