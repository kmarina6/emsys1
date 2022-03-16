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
import javax.servlet.http.HttpSession;

import bean.DepartmentBean;
import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
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

		String error_state = null;

		//「登録の開始」をリクエストされたときの処理
		if(action == null){

			//------------------------------------------
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/emsys?allowPublicKeyRetrieval=true&useSSL=false";
			String user = "root";
			String password = "Km_elie3173ms1955";

			// beanList を生成
			ArrayList<DepartmentBean> depBeanList = new ArrayList<DepartmentBean>();

			try {
				//---所属部署をマスタから読み込み---

				// JDBC ドライバを読み込み
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);

				// データベースへ SQL 文を発行
				Statement stmt = conn.createStatement();


				//---------------------------------------------------------
				String sql = "SELECT * FROM m_department";
				//---------------------------------------------------------
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					// bean を生成
					DepartmentBean bean = new DepartmentBean();

					// SQL リザルトからデータを取得し、bean に保存していく
					bean.setId(rs.getString("id"));
					bean.setJobName(rs.getString("job_name"));
					// データを保存した bean を beanList に追加

					depBeanList.add(bean);
					//System.out.print("kiteruyo  ");
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

			//-------------------------------------------
			//フォワード先を設定
			forwardPath = "/WEB-INF/register-jsp/registerForm.jsp";
		}
		else if(action.equals("done")){
			//---登録確認画面から「登録実行」をリクエスト---

			//セッションスコープに保存された登録ユーザを
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");

			//登録処理の呼び出し
			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");

			RegisterUserLogic logicTest = new RegisterUserLogic();
			error_state = logicTest.exute(registerUser);

			if(error_state == null) {
				//登録完了
				forwardPath = "/WEB-INF/register-jsp/registerDone.jsp";
			}else if(error_state == "error_duplicate") {
				// 登録時二重送信エラー
				forwardPath = "/WEB-INF/register-jsp/registerDoneDuplicate.jsp";
			}else if(error_state == "error_sql") {
				forwardPath = "/WEB-INF/register-jsp/registerDoneNe.jsp";
			}

		}

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
		String emp_name = request.getParameter("emp_name");
		String emp_kana = request.getParameter("emp_kana");
		String hire_ymd;
		if(request.getParameter("hire_ymd") == "") {
			hire_ymd = "null";
		}else {
			hire_ymd = request.getParameter("hire_ymd");
		}
		//String retirement_ymd = request.getParameter("retirement_ymd");
		String department_data = request.getParameter("department_data");
		String mail_add = request.getParameter("mail_add");
		String update_date = request.getParameter("update_date");
		String update_person = request.getParameter("update_person");
		String registered_date = request.getParameter("registered_date");
		String registered_person = request.getParameter("registered_person");

		//登録するユーザの情報を設定
		User registerUser = new User(emp_no, emp_name, emp_kana, hire_ymd, department_data, mail_add, update_date, update_person, registered_date, registered_person);

		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/register-jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}