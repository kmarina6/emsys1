package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class MemberDao {

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
    public int insertMember(User user) throws DAOException {
        getConnection();
        int count = 0;
        String sql = "INSERT INTO employee_data (emp_no, emp_name, emp_kana, hire_ymd, department_data, mail_add, update_date, update_person, registered_date, registered_person, delete_flag) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 今日の日付(yyyy-mm-dd) -----------------------------------------------------------
        long miliseconds = System.currentTimeMillis();
        Date nowdate = new Date(miliseconds);

        // 社員番号 -------------------------------------------------------------------------
        String emp_no_st = user.getEmpNo();
        int emp_no = Integer.parseInt(emp_no_st);

        // 氏名 -------------------------------------------------------------------------------
        String emp_name = user.getEmpName();

        // よみかな ---------------------------------------------------------------------------
        String emp_kana = user.getEmpKana();

        // 入社日date型変換 -------------------------------------------------------------------
        String st_hire_y = user.getHireY();
        String st_hire_m = user.getHireM();
        String st_hire_d = user.getHireD();
        String st_hire_ymd = st_hire_y + "-" + st_hire_m + "-" + st_hire_d;
        Date hire_ymd  = java.sql.Date.valueOf(st_hire_ymd);


        // 所属部署 ---------------------------------------------------------------------------
        String department_data = user.getDepartmentData();

        // メールアドレス --------------------------------------------------------------------
        String mail_add = user.getMailAdd();

        // 更新日 ----------------------------------------------------------------------------
        //Date update_date = nowdate;

        // 更新者 ----------------------------------------------------------------------------
        //String update_person = user.getUpdatePerson();

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

        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, emp_no);
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

            count += pstmt.executeUpdate();
        } catch(SQLException e) {
            throw new DAOException("[UserDAO#insertMember]異常", e);
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