package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jp.netwisdom.entity.Userinfo;
import cn.key.dbManager.IResultSetMapping;

public class UserinfoMapping implements IResultSetMapping{

	@Override
	public Userinfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		Userinfo userinfo = new Userinfo(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
		return userinfo;
	}
}
