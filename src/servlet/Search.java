package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DepartmentBean;
import model.SearchUser;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//      // TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//      // TODO Auto-generated method stub
		//      doGet(request, response);

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String emp_no = request.getParameter("emp_no");
		String emp_no_after = request.getParameter("emp_no");
		String emp_name = request.getParameter("emp_name");
		String emp_kana = request.getParameter("emp_kana");
		String hire_ymd = request.getParameter("hire_ymd");
		String retirement_ymd = request.getParameter("retirement_ymd");
		String department_data = request.getParameter("department_data");
		String mail_add = request.getParameter("mail_add");
		String update_date = request.getParameter("update_date");
		String update_person = request.getParameter("update_person");
		String registered_date = request.getParameter("registered_date");
		String registered_person = request.getParameter("registered_person");
		Boolean delete_flag = false;

		//---------------------------------------------------------------------------------------------
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/emsys?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root";
		String password = "Km_elie3173ms1955";

		//フォワード先
		String forwardPath = null;

		String deleteUpdateFlag = request.getParameter("deleteUpdateFlag");
		try {

			// JDBC ドライバを読み込み
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// データベースへ SQL 文を発行
			Statement stmt = conn.createStatement();

			// 編集前内容の表示の処理
			String sql = "SELECT * FROM employee_data WHERE emp_no='" + emp_no + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// SQL リザルトからデータを取得し、bean に保存していく
				emp_name = rs.getString("emp_name");
				emp_kana = rs.getString("emp_kana");
				if (rs.getDate("hire_ymd") != null) {
					hire_ymd = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("hire_ymd"));
				} else {
					hire_ymd = "null";
				}
				if (rs.getDate("retirement_ymd") != null) {
					retirement_ymd = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("retirement_ymd"));
				} else {
					retirement_ymd = "null";
				}
				department_data = rs.getString("department_data");
				mail_add = rs.getString("mail_add");
				update_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("update_date"));
				update_person = rs.getString("update_person");
				registered_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("registered_date"));
				registered_person = rs.getString("registered_person");
				delete_flag = rs.getBoolean("delete_flag");
			}

			rs.close();
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

		// beanList を生成
		ArrayList<DepartmentBean> depBeanList = new ArrayList<DepartmentBean>();

		try {

			// JDBC ドライバを読み込み
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// データベースへ SQL 文を発行
			Statement stmt = conn.createStatement();

			//「登録の開始」をリクエストされたときの処理
			//---------------------------------------------------------
			String sql = "SELECT * FROM m_department";
			//---------------------------------------------------------
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// bean を生成
				DepartmentBean depBean = new DepartmentBean();

				// SQL リザルトからデータを取得し、bean に保存していく
				depBean.setId(rs.getString("id"));
				depBean.setJobName(rs.getString("job_name"));
				// データを保存した bean を beanList に追加
				depBeanList.add(depBean);
			}
			rs.close();
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
		request.setAttribute("depBeanList", depBeanList);


		ServletContext context = this.getServletContext();

		//登録するユーザの情報を設定
		SearchUser searchUser = new SearchUser(emp_no, emp_no_after, emp_name, emp_kana, hire_ymd, retirement_ymd,
				department_data, mail_add, update_date, update_person, registered_date, registered_person);

		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("searchUser", searchUser);

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得
		String action = request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		if (action.equals("update")) {
			if (delete_flag == false) {
				forwardPath = "/WEB-INF/update-jsp/updateForm.jsp";
			} else {
				if(deleteUpdateFlag == null) {
				forwardPath = "/WEB-INF/update-jsp/updateNe.jsp";
				} else {
					forwardPath = "/WEB-INF/update-jsp/updateForm.jsp";
				}
			}
		} else if (action.equals("delete")) {
			if (delete_flag == false) {
				forwardPath = "/WEB-INF/delete-jsp/deleteConfirm.jsp";
			} else {
				forwardPath = "/WEB-INF/delete-jsp/deleteNe.jsp";
			}
		}

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}