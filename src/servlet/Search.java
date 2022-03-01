package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//      // TODO Auto-generated method stub
		//      response.getWriter().append("Served at: ").append(request.getContextPath());

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得
		String action = request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		if(action.equals("update")){
			//フォワード先を設定
			forwardPath = "/WEB-INF/update-jsp/updateTop.jsp";
		}
		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("delete")){
			forwardPath = "/WEB-INF/delete-jsp/deleteTop.jsp";		}

		// 設定されたフォワード先を設定
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//      // TODO Auto-generated method stub
		//      doGet(request, response);

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String emp_no = request.getParameter("emp_no");
		String emp_no_after = request.getParameter("emp_no");
		String emp_name = request.getParameter("emp_name");
		String emp_kana = request.getParameter("emp_kana");
		String hire_ymd = request.getParameter("hire_ymd");

		String hire_y = request.getParameter("hire_y");
		String hire_m = request.getParameter("hire_m");
		String hire_d = request.getParameter("hire_d");

		String retirement_ymd = request.getParameter("retirement_ymd");

		// ここまだ使ってない
		String retirement_y = request.getParameter("retirement_y");
		String retirement_m = request.getParameter("retirement_m");
		String retirement_d = request.getParameter("retirement_d");

		String department_data = request.getParameter("department_data");
		String mail_add = request.getParameter("mail_add");
		String update_date = request.getParameter("update_date");
		String update_person = request.getParameter("update_person");
		String registered_date = request.getParameter("registered_date");
		String registered_person = request.getParameter("registered_person");
		Boolean delete_flag = false;

		//---------------------------------------------------------------------------------------------
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/emsys?useSSL=false";
		String user = "root";
		String password = "Km_elie3173ms1955";

		//フォワード先
		String forwardPath = null;

		try {

			// JDBC ドライバを読み込み
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// データベースへ SQL 文を発行
			Statement stmt = conn.createStatement();

			//「登録の開始」をリクエストされたときの処理
			String sql = "SELECT * FROM employee_data WHERE emp_no='" + emp_no + "'";
			System.out.print("kiteruyo_sql" + sql + "   ");
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// SQL リザルトからデータを取得し、bean に保存していく
				emp_name = rs.getString("emp_name");
				emp_kana = rs.getString("emp_kana");
				if(rs.getDate("hire_ymd") != null) {
					hire_ymd =  new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("hire_ymd"));

					hire_y =  new SimpleDateFormat("yyyy").format(rs.getDate("hire_ymd"));
					hire_m =  new SimpleDateFormat("MM").format(rs.getDate("hire_ymd"));
					hire_d =  new SimpleDateFormat("dd").format(rs.getDate("hire_ymd"));
				}
				if(rs.getDate("retirement_ymd") != null) {
					retirement_ymd = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("retirement_ymd"));
				}
				department_data = rs.getString("department_data");
				mail_add = rs.getString("mail_add");
				update_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("update_date"));
				update_person = rs.getString("update_person");
				registered_date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("registered_date"));
				registered_person = rs.getString("registered_person");
				delete_flag = rs.getBoolean("delete_flag");
			}
			//System.out.print("kiteruyo  ");

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
		ServletContext context = this.getServletContext();
		//------------------------------------------------------------------------------------


		//登録するユーザの情報を設定
		SearchUser searchUser = new SearchUser(emp_no, emp_no_after, emp_name, emp_kana, hire_ymd, hire_y, hire_m, hire_d, retirement_ymd, retirement_y, retirement_m, retirement_d, department_data, mail_add, update_date, update_person, registered_date, registered_person);

		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("searchUser", searchUser);


		//サーブレットクラスの動作を決定する「action」の値を
		//リクエストパラメータから取得
		String action = request.getParameter("action");

		//「登録の開始」をリクエストされたときの処理
		System.out.print("kiteruyo!Delete_flag2 " + delete_flag + "  ");
		if(action.equals("update")){
			if(delete_flag == false) {
				forwardPath = "/WEB-INF/update-jsp/updateForm.jsp";
			}else{
				forwardPath = "/WEB-INF/update-jsp/updateNe.jsp";
			}

		}else if(action.equals("delete")){
			if(delete_flag == false) {
				forwardPath = "/WEB-INF/delete-jsp/deleteConfirm.jsp";
			}else{
				forwardPath = "/WEB-INF/delete-jsp/deleteNe.jsp";
			}
		}

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
}