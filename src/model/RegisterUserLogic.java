package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegisterUserLogic {
	public String exute(User user){
		String error_state = null;

		Connection conn = null;
		String URL = "jdbc:mysql://localhost:3306/emsys?allowPublicKeyRetrieval=true&useSSL=false";
		String USER = "root";
		String PASSWORD = "Km_elie3173ms1955";

		String sql = "INSERT INTO employee_data (emp_no, emp_name, emp_kana, hire_ymd, department_data, mail_add, update_date, update_person, registered_date, registered_person, delete_flag) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// 今日の日付(yyyy-mm-dd) -----------------------------------------------------------
		long miliseconds = System.currentTimeMillis();
		Date nowdate = new Date(miliseconds);

		// 社員番号 -------------------------------------------------------------------------
		String emp_no = user.getEmpNo();

		// 氏名 -------------------------------------------------------------------------------
		String emp_name = user.getEmpName();

		// よみかな ---------------------------------------------------------------------------
		String emp_kana = user.getEmpKana();

		// 入社日date型変換 -------------------------------------------------------------------
		String st_hire_ymd = user.getHireYmd();
		Date hire_ymd = null;
		if(st_hire_ymd.equals("null")) {
			hire_ymd  = null;
		}else {
			hire_ymd  = java.sql.Date.valueOf(st_hire_ymd);
		}

		// 所属部署 ---------------------------------------------------------------------------
		String department_data = user.getDepartmentData();

		// メールアドレス --------------------------------------------------------------------
		String mail_add = user.getMailAdd();

		// 登録日 ----------------------------------------------------------------------------
		Date registered_date = nowdate;

		// 登録者 ----------------------------------------------------------------------------
		String registered_person;
		if(user.getRegisteredPerson() != "") {
			registered_person = user.getRegisteredPerson();
		}else {
			registered_person = null;
		}

		// 削除フラグ ------------------------------------------------------------------------
		Boolean delete_flag = false;

		try {
			// JDBC ドライバを読み込み
			Class.forName("com.mysql.jdbc.Driver");
			// DBへのコネクションを作成する
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);  //オートコミットはオフ

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp_no);
			pstmt.setString(2, emp_name);
			pstmt.setString(3, emp_kana);
			pstmt.setDate(4, hire_ymd);
			pstmt.setString(5, department_data);
			pstmt.setString(6, mail_add);
			pstmt.setDate(7, registered_date);
			pstmt.setString(8, registered_person);
			pstmt.setDate(9, registered_date);
			pstmt.setString(10, registered_person);
			pstmt.setBoolean(11, delete_flag);

			int i = pstmt.executeUpdate();

			 //処理件数を表示する
            System.out.println("結果：" + i);

            //コミット
            conn.commit();
		} catch (ClassNotFoundException e) {
			// 例外処理
			e.printStackTrace();
		}catch(SQLIntegrityConstraintViolationException e) {
			// 例外処理
			error_state = "error_duplicate";
			e.printStackTrace();
		} catch (SQLException e) {
			// 例外処理
			error_state = "error_sql";
			e.printStackTrace();
		} catch (Exception e) {
			// 例外処理
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// 例外処理
				e.printStackTrace();
			}
		}

		return error_state;
	}
}
