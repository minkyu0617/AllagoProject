package com.allago.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.ObjectTypeHandler;

public class AllagoDateTypeHandler extends BaseTypeHandler<java.util.Date> {
	@Override
	public java.util.Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdt.parse(rs.getString(columnIndex));
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return date;
	}

	@Override
	public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdt.parse(rs.getString(columnIndex));
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return date;
	}

	@Override
	public Date getNullableResult(ResultSet rs, String columnIndex) throws SQLException {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdt.parse(rs.getString(columnIndex));
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return date;
	}

	@Override
	public Date getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1, Date arg2, JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub

	}
}
