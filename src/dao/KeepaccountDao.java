package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Keepaccount;

public class KeepaccountDao {

	private static ArrayList<Keepaccount> resultList;
	private static Keepaccount result;

	public static ArrayList<Keepaccount> getAllFriends() {
		return resultList;

	}
	public static ArrayList<Keepaccount> getAllpokemon(){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Keepaccount> result = new ArrayList<Keepaccount>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pokemon?useSSL=false",
					"root",
					"kame0630");

			String sql = "select * from Keepaccount";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				int spending = rs.getInt("spending");
				int income = rs.getInt("income");

				Keepaccount keepaccount = new Keepaccount(spending,income);

				result.add(keepaccount);

			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return result;

	}

	public static Keepaccount Insertkeepaccunt(Int spending,Int income) {

		Keepaccount result = null;
		Connection con = null;
		PreparedStatement pstmt = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pokemon?useSSL=false",
				"root",
				"kame0630");

	String sql = "INSERT INTO keepaccount("spending,income) VALUES(?,?)";

	pstmt = con.prepareStatement(sql);


	pstmt.setInt(1.spending);
	pstmt.setInt(2,income);

	pstmt.executeUpdate();

	}
	catch (SQLException e) {
		System.out.println("DBアクセスに失敗しました。");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	} finally {
		try {
			if( pstmt != null) {
				pstmt.close();

			}
		} catch(SQLException e){
			System.out.println("DB切断時にエラーが発生しました。");
			e.printStackTrace();
		}

		try {
			if( con != null) {
				con.close();
			}

		}catch (SQLException e) {
			System.out.println("DB接続時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
	return  result;
}


}