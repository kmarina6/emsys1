package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import model.UserToUpdate;

public class UpdateMemberDao {

    private Connection con = null;  // コネクションオブジェクト
    private Statement stmt = null;  // ステートメントオブジェクト
    private ConnectionManager cm; // コネクションマネージャー

    // Connectionの取得
    private void getConnection() throws DAOException{
        if ( this.con != null ){ return;    }
        cm = ConnectionManager.getInstance();
        con = cm.getConnection(); // データベースへの接続の取得
    }

    // Statementの取得
    private void createStmt() throws DAOException{
        if ( this.stmt != null){    return; }
        try {
            stmt =con.createStatement();
        } catch (SQLException e) {  // SQLに関する例外処理
            throw new DAOException("[createStmt]異常", e);
        }
    }

    // データを追加
    public int updateMember(UserToUpdate UserToUpdate) throws DAOException {
    	getConnection();
        int count = 0;
        String sql = "UPDATE employee_data SET  emp_no = ?, emp_name = ?, emp_kana = ?, hire_ymd = ?, department_data = ?, mail_add = ?, update_person = ? WHERE emp_no = ?";

		/*        // 氏名
		//String emp_name = user.getEmpName();
		String emp_name = "加藤次郎";

		// よみかな
		//String emp_kana = user.getEmpKana();
		String emp_kana = "かとうじろう";

		// 入社日date型変換
		//String hire_ymd = user.getHireYmd();
		String hire_ymd = "2020-10-1";
		//SimpleDateFormat test_sdf = new SimpleDateFormat("yyyy/mm/dd");
		Date test_hire_ymd  = Date.valueOf(hire_ymd);


		// 所属部署
		String department_data = "基盤技術部";

		// メールアドレス
		String mail_add = "abo@gmail.com";

		// 社員番号
		// 文字列 countstr にベタ打ちで格納
		String emp_no = "2211"+"0000";
		int emp_no_test = Integer.parseInt(emp_no);
		*/

// ------------------------------------------------------------------------------------------
     // 今日の日付(yyyy-mm-dd) -----------------------------------------------------------
        long miliseconds = System.currentTimeMillis();
        Date nowdate = new Date(miliseconds);

        // 社員番号 -------------------------------------------------------------------------
        String emp_no_st = UserToUpdate.getEmpNo();
        int emp_no = Integer.parseInt(emp_no_st);

        String emp_no_after_st = UserToUpdate.getEmpNoAfter();
        int emp_no_after = Integer.parseInt(emp_no_after_st);

        // 氏名 -------------------------------------------------------------------------------
        String emp_name = UserToUpdate.getEmpName();

        // よみかな ---------------------------------------------------------------------------
        String emp_kana = UserToUpdate.getEmpKana();

        // 入社日date型変換 -------------------------------------------------------------------
        String st_hire_y = UserToUpdate.getHireY();
        String st_hire_m = UserToUpdate.getHireM();
        String st_hire_d = UserToUpdate.getHireD();
        String st_hire_ymd = st_hire_y + "-" + st_hire_m + "-" + st_hire_d;

        System.out.print("UpMen_st_hire_y" + st_hire_y + "  ");
        System.out.print("UpMen_st_hire_m" + st_hire_m + "  ");
        //if(st_hire_y != null){
        	Date hire_ymd  = java.sql.Date.valueOf(st_hire_ymd);
        //}else{
        //	Date hire_ymd  = null;
        //}

        // 退職日date型変換 -------------------------------------------------------------------
		/*String st_hire_y = userToUpdate.getHireY();
		String st_hire_m = userToUpdate.getHireM();
		String st_hire_d = userToUpdate.getHireD();
		String st_hire_ymd = st_hire_y + "-" + st_hire_m + "-" + st_hire_d;
		Date hire_ymd  = java.sql.Date.valueOf(st_hire_ymd);
		*/

        // 所属部署 ---------------------------------------------------------------------------
        String department_data = UserToUpdate.getDepartmentData();
        System.out.print("department_data!!!" + department_data + "  ");

        // メールアドレス --------------------------------------------------------------------
        String mail_add = UserToUpdate.getMailAdd();

        // 更新日 ----------------------------------------------------------------------------
        Date update_date = nowdate;

        // 更新者 ----------------------------------------------------------------------------
        String update_person;
        if(UserToUpdate.getUpdatePerson() != "") {
        	update_person= UserToUpdate.getUpdatePerson();
        }else {
        	update_person = null;
        }

        // 登録日 ----------------------------------------------------------------------------
        //Date registered_date = nowdate;

        // 登録者 ----------------------------------------------------------------------------
		/*String registered_person;
		if(userToUpdate.getRegisteredPerson() != "") {
			registered_person = userToUpdate.getRegisteredPerson();
		}else {
			registered_person = null;
		}*/

        //---------------------------------------------------------------------------------------------------------------


        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
        	pstmt.setInt(1, emp_no_after);
        	pstmt.setString(2, emp_name);
            pstmt.setString(3, emp_kana);
            pstmt.setDate(4, hire_ymd);

            pstmt.setString(5, department_data);
            pstmt.setString(6, mail_add);
            pstmt.setString(7, update_person);
            pstmt.setInt(8, emp_no);

            //System.out.print("kiteruyo_UpdateMember_after" + emp_no_after + "  ");
            //System.out.print("kiteruyo_UserToUpdDate" + emp_no + "  ");
            count += pstmt.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException e) {

        	throw new DAOException("[UserDAO#updateMember]二重送信", e);
        }catch(SQLException e) {
            throw new DAOException("[UserDAO#updateMember]異常", e);
        } finally {
            close();
        }
        return count;
    }

    private void close() throws DAOException {
        try {
            if (stmt != null) { stmt.close(); }
        } catch (SQLException e) {
            throw new DAOException("[closeStatement]異常", e);
        } finally {
            this.stmt = null;
            this.cm = null;
        }
    }
}