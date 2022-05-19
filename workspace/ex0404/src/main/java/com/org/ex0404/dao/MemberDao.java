package com.org.ex0404.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.org.ex0404.dto.Member;

@Repository // 저장소
public class MemberDao {
	
	@Autowired
	DriverManagerDataSource dataSource;
	
	public boolean insert(Member member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring5", "root", "1234");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("insert into member (username, password) values (?,?)");
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.executeUpdate();
			// insert, delete, update 는 executeUpdate
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<Member> selectall() {
		List<Member> list = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("select * from member");
			rs = pstmt.executeQuery(); // select
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setPassword(rs.getString("password"));
				member.setUsername(rs.getString("username"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(List<Integer> list) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String ids = "";
		for(int i=0; i<list.size(); i++) {
			if(list.size()-1 == i) {
				ids += list.get(i);
			} else {
				ids += list.get(i)+",";
			}
		}
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("delete from member where id in ("+list+")");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member selectone(int id) {
		Member member = new Member();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("select * from member where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
			}
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public boolean update(Member member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("update member"
					+ " set username=?, password =?"
					+ " where id=?");
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setInt(3, member.getId());
			pstmt.executeUpdate();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
