package delete;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ConnectionManager;
import dao.DAOException;
import model.User;

public class Delete {

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
    public int updateMember(User user) throws DAOException {
    	System.out.print("kiteruyo2");
    	getConnection();
        int count = 0;
        //String sql = "UPDATE INTO employee_data (emp_no, emp_name, emp_kana, hire_ymd, department_data, mail_add) VALUES(?, ?, ?, ?, ?, ?)";
        String sql = "UPDATE employee_data SET  emp_name = ?, emp_kana = ?, hire_ymd = ?, department_data = ?, mail_add = ? WHERE emp_no = ?";

        // 氏名
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

        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
        	pstmt.setString(1, emp_name);
            pstmt.setString(2, emp_kana);
            pstmt.setDate(3, test_hire_ymd);
            pstmt.setString(4, department_data);
            pstmt.setString(5, mail_add);
            pstmt.setInt(6, emp_no_test);

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