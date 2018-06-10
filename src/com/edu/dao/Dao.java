package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.edu.vo.Buyer;
import com.edu.vo.Seller;

public class Dao {
	private final String SELLER_LOGIN = "select password from seller where id=?";
	private final String BUYER_LOGIN = "select password from buyer where id=?";
	private final String SELLER_JOIN = "insert into seller values(?,?,?,?,?)";
	private final String BUYER_JOIN = "insert into buyer values(?,?,?,?)";
	private final String SELLER_REGISTER = "update seller set count=?, price=? where id=?";
	private final String BUYER_REGISTER = "update buyer set money=money+? where id=?";
	private final String SELLER_INFORMATION = "select * from seller where id=?";
	private final String BUYER_INFORMATION = "select * from buyer where id=?";
	private final String SELLER_LIST = "select * from seller";
	private final String BUYER_BUY_FRUIT = "update buyer set money=?, count=? where id=?";
	private final String SELLER_SALES_FRUIT = "update seller set money=?, count=? where id=?";

	private static Dao dao = new Dao();

	private Dao() {
	}

	public static Dao getInstance() {
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/fruit";
			String user = "root";
			String password = "cs1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("connect" + e);
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Error:close3" + e);
			}
		}
	}

	public String sellerLogin(String id) {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("dao.sellerLogin" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return password;
	}

	public String buyerLogin(String id) {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("dao.buyerLogin" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return password;
	}

	public void sellerJoin(Seller s) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_JOIN);
			pstmt.setString(1, s.getId());
			pstmt.setString(2, s.getPassword());
			pstmt.setInt(3, s.getMoney());
			pstmt.setInt(4, s.getAppleCount());
			pstmt.setInt(5, s.getApplePrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.sellerJoin" + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public void buyerJoin(Buyer b) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_JOIN);
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getPassword());
			pstmt.setInt(3, b.getMoney());
			pstmt.setInt(4, b.getAppleCount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.buyerJoin" + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public void sellerRegister(int count, int price, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_REGISTER);
			pstmt.setInt(1, count);
			pstmt.setInt(2, price);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.sellerRegister" + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public void buyerRegister(int money, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_REGISTER);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.buyerRegister" + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public Seller sellerInformation(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Seller s = new Seller();
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_INFORMATION);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				s.setId(rs.getString(1));
				s.setPassword(rs.getString(2));
				s.setMoney(rs.getInt(3));
				s.setAppleCount(rs.getInt(4));
				s.setApplePrice(rs.getInt(5));
			}
		} catch (Exception e) {
			System.out.println("dao.sellerInformation" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return s;
	}

	public Buyer buyerInformation(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buyer b = new Buyer();
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_INFORMATION);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				b.setId(rs.getString(1));
				b.setPassword(rs.getString(2));
				b.setMoney(rs.getInt(3));
				b.setAppleCount(rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println("dao.buyerInformation" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return b;
	}

	public ArrayList<Seller> sellerList() {
		ArrayList<Seller> list = new ArrayList<Seller>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Seller s = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				s = new Seller();
				s.setId(rs.getString(1));
				s.setPassword(rs.getString(2));
				s.setMoney(rs.getInt(3));
				s.setAppleCount(rs.getInt(4));
				s.setApplePrice(rs.getInt(5));
				list.add(s);
			}
		} catch (Exception e) {
			System.out.println("dao.sellerList" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	public void buyerBuyFruit(Buyer b) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_BUY_FRUIT);
			pstmt.setInt(1, b.getMoney());
			pstmt.setInt(2, b.getAppleCount());
			pstmt.setString(3, b.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.buyerBuyFruit" + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public void sellerSalesFruit(Seller s) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_SALES_FRUIT);
			pstmt.setInt(1, s.getMoney());
			pstmt.setInt(2, s.getAppleCount());
			pstmt.setString(3, s.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.sellerSalesFruit" + e);
		} finally {
			close(conn, pstmt);
		}
	}

}
