package cn.smbms.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.smbms.dao.BlogTest;
import cn.smbms.model.Blog;

public class test {
	public static void main(String[] args) {
		SqlSession con = null;
		try {
			con =MyBatisUtil.createSqlSession();//Á¬½Ó
			
			List<Blog> blog = con.getMapper(BlogTest.class).allBlog();
			for (Blog blog2 : blog) {
				System.out.println(blog2.getId()+"---"+blog2.getTitle()+"--"+blog2.getAuthor().getAname());
			}
			con.commit();
		}finally {
			MyBatisUtil.closeSqlSession(con);
		}
	}
}
