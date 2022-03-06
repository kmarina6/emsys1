package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		boolean judge_flag = false;

		//「登録の開始」をリクエストされたときの処理
		if(action == null){
			//フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}
		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("done")){
			//セッションスコープに保存された登録ユーザを
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");

			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			judge_flag = logic.exute(registerUser);

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");

			if(judge_flag) {
				//登録後のフォワード先を設定
				forwardPath = "/WEB-INF/jsp/registerDone.jsp";
			}else {
				forwardPath = "/WEB-INF/jsp/registerDoneNe.jsp";
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}