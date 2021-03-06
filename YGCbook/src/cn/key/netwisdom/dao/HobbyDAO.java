package cn.key.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.jp.netwisdom.entity.Hobby;
import cn.jp.netwisdom.entity.Userinfo;
import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
//DAO层
public class HobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	

	public boolean save(List<Hobby> list) {
		int row = 0;
		//创建与数据库对应的数据类型 问好代表还未传入的未知数据
		String sql = "insert into hobby(username,hobby)" + 
		                "values(?,?)";
		
		
		for(Hobby hobby: list){
			 
			    //创建一个对象 获取entity里面属性和get方法
				Object[] values = new Object[]{
						hobby.getUsername(),
						hobby.getHobby()
				                              };
		
		//最终执行SQl文是通过try/template来执行
		try {
			row = template.updata(sql, values);
			if(row !=1){
				 break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		return (row == 1);
	}
	
	
	
	
	 
	public boolean updata(BookInfo book) {
		
		String sql = "update bookInfo " +
						" set bookName=?,booktypeId=?,pbName=?,author=?,context=?," +
										"smallImg=?,bigImg=?,price=?,pbdate=?,bookStates=?,ygcprice=?" +
						" where bookId=?";
		int row = 0;
		String dateStr = DataTool.datetoString(book.getPbdate());
		Object[] values = new Object[]{book.getBookName(), book.getBooktypeId(), book.getPbName(), book.getAuthor(), book.getContext(), 
				book.getSmallImg(), book.getBigImg(), book.getPrice(), dateStr, book.getBookStates(), book.getYgcprice(), book.getBookId()};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	public boolean upDelete(int type,int id) {
		String sql = "update bookInfo" +
						" set bookStates=" + type +
						" where bookId=" + id;
		int row = 0;
		try {
			row = template.updata(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	public int getPageCount(int pageSize, int bookStates) {
		int pageCount = 0;
		int rows = 0;
		String sql = "select count(*) " +
		" from bookInfo " +
		" where ";
		StringBuffer sb = new StringBuffer(sql);
		switch (bookStates) {
		case 1:
		sb.append(" bookStates=1");
		break;
		case 2:
		sb.append(" bookStates=2");
		break;
		case 3:
		sb.append(" bookStates=3");
		break;
		case 4:
		sb.append(" 1=1");
		break;
		default:
		sb.append(" bookStates<>3 ");
		}
		try {
		rows = template.select(sb.toString());
		pageCount = rows / pageSize;
		if((rows % pageSize) != 0) {
			pageCount ++;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return pageCount;
	}
	
	public int getForPageCount(int pageSize, int bookStates, int typeId) {
		int pageCount = 0;
		int rows = 0;
		String sql = "select count(*) " +
		" from bookInfo " +
		" where booktypeId=" + typeId + " and ";
		StringBuffer sb = new StringBuffer(sql);
		switch (bookStates) {
		case 1:
		sb.append(" bookStates=1");
		break;
		case 2:
		sb.append(" bookStates=2");
		break;
		case 3:
		sb.append(" bookStates=3");
		break;
		case 4:
		sb.append(" 1=1");
		break;
		default:
		sb.append(" bookStates<>3 ");
		}
		try {
		rows = template.select(sb.toString());
		pageCount = rows / pageSize;
		if((rows % pageSize) != 0) {
			pageCount ++;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return pageCount;
	}
	
	public List<BookInfo> findByAuthorBookName(String bookName, String author) {
		String sql = "select bookId,bookName,booktypeId,pbName,author," +
						"context,smallImg,bigImg,price,pbdate," +
						"bookStates,ygcprice " +
						" from bookInfo " +
						" where bookStates=2 ";
		StringBuffer sb = new StringBuffer(sql);
		if(bookName.length() != 0) {
			sb.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			sb.append(" and author like '%" + author + "%'");
		}
		List<BookInfo> list = new Vector<BookInfo>();
		try {
			list = template.selete(sb.toString(), new BookInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getPageCountByIndex(String bookName, String author, int pageSize, int bookStates) {
		int pageCount = 0;
		int rows = 0;
		StringBuilder where = new StringBuilder(" where 1=1 and bookStates=" + bookStates);
		if(bookName.length() != 0) {
			where.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			where.append(" and author like '%" + author + "%'");
		}
		
		String sql = "select count(*) " +
					" from bookInfo " + where;
		try {
		rows = template.select(sql);
		pageCount = rows / pageSize;
		if((rows % pageSize) != 0) {
			pageCount ++;
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return pageCount;
	}
	
	public List<BookInfo> getNowPageByAuthorBookName(String bookName, String author, int nowPage, int pageSize, int bookStates) {
		StringBuilder where = new StringBuilder(" where bookStates=" + bookStates);
		if(bookName.length() != 0) {
			where.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			where.append(" and author like '%" + author + "%'");
		}
		String sql = "select top " + pageSize + "bookId,bookName,booktypeId,pbName,author," +
						"context,smallImg,bigImg,price,pbdate," +
						"bookStates,ygcprice " +
						" from bookInfo " + where +
						"	and " +
						"	bookId not in" +
						"		(select top " + (nowPage-1)*pageSize + " bookId from bookInfo  " + where + 
						"	and 1=1) ";
		
		List<BookInfo> list = new Vector<BookInfo>();
		try {
			list = template.selete(sql, new BookInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

