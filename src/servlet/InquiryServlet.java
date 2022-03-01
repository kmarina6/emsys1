package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/emsys?useSSL=false";
		String user = "root";
		String password = "Km_elie3173ms1955";

		// beanList を生成
		ArrayList<UserBean> beanList = new ArrayList<UserBean>();


		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得
		String action = request.getParameter("action");
		String action_update = request.getParameter("action_update");

		try {

			// JDBC ドライバを読み込み
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// データベースへ SQL 文を発行
			Statement stmt = conn.createStatement();

			//「登録の開始」をリクエストされたときの処理
			if(action == null){
				String sql = "SELECT * FROM employee_data";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					// bean を生成
					UserBean bean = new UserBean();

					// SQL リザルトからデータを取得し、bean に保存していく
					bean.setEmpNo(rs.getInt("emp_no"));
					bean.setEmpName(rs.getString("emp_name"));
					bean.setEmpKana(rs.getString("emp_kana"));
					bean.setHireYmd(rs.getDate("hire_ymd"));
					bean.setRetirementYmd(rs.getDate("retirement_ymd"));
					bean.setDepartmentData(rs.getString("department_data"));
					bean.setMailAdd(rs.getString("mail_add"));
					bean.setUpdateDate(rs.getDate("update_date"));
					bean.setUpdatePerson(rs.getString("update_person"));
					bean.setRegisteredDate(rs.getDate("registered_date"));
					bean.setRegisteredPerson(rs.getString("registered_person"));

					// データを保存した bean を beanList に追加
					if(rs.getBoolean("delete_flag") == false){
						beanList.add(bean);
					}else {

					}
					//System.out.print("kiteruyo  ");
				}
				//登録後のフォワード先を設定
				forwardPath = "/WEB-INF/inquiry-jsp/inquiry.jsp";

				rs.close();
			}
			stmt.close();
		} catch (ClassNotFoundException e) {
			// 例外処理
			e.printStackTrace();
		} catch (SQLException e) {
			// 例外処理
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

		// beanList をリクエストにセット
		request.setAttribute("beanList", beanList);

		ServletContext context = this.getServletContext();

        // 設定されたフォワード先を設定
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
