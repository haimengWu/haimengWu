package com.HaimengWu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCUtils {
	// �������ݿ��Ĵ������Ϣ
		private static String driver = "com.mysql.cj.jdbc.Driver";
		private static String url = "jdbc:mysql://127.0.0.1:3306/wuhaimeng?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
		//private static String driver = "com.mysql.jdbc.Driver";
		//private static String url = "jdbc:mysql://127.0.0.1:3306/wuhaimeng?useSSL=false&useUnicode=true&characterEncoding=utf8";
		private static String username = "root";
		private static String password = "root";
		private static Connection conn;
 
	// ����һ����̬��,�ڵ���JDBCUtils���ǳ�ʼ��,��ȡ���ݿ�����
	static {
		try {
			/*
			 * java.sql.DriverManager�������������ݿ���������� static void
			 * registerDriver(Driver driver) �� DriverManager ע�������������
			 * ����Դ��������һ��static����,������driver��ʱ�Ѿ�������,�������ﲻ��Ҫ�ٴε���,���ǿ���ʹ�÷��似��
			 * DriverManager.registerDriver(new Driver());
			 */
			Class.forName(driver);
			// ��ȡ���ݿ����Ӷ���
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// �ѱ����쳣ת��Ϊ����ʱ�쳣
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
	//�������ݿ����Ӷ���
	public static Connection getConnection() {
		return conn;
	}
	//����״̬
	public Statement getState() {
		Statement state=null;
		try {
			state=getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println("creating Statement failed");
			e.printStackTrace();
		}
		return state;
	}
	
	//��̬�ر�������
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

