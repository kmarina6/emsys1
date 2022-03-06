package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UpdateUserLogic;
import model.UserToUpdate;


/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //フォワード先
        String forwardPath = null;

        //サーブレットクラスの動作を決定する「action」の値を
        //リクエストパラメータから取得
        String action = request.getParameter("action");

        //「登録の開始」をリクエストされたときの処理
        if(action == null){
            //フォワード先を設定
            forwardPath = "/WEB-INF/update-jsp/updateForm.jsp";
        }
        //登録確認画面から「登録実行」をリクエストされたときの処理
        else if(action.equals("done")){
            //セッションスコープに保存された登録ユーザを
            HttpSession session = request.getSession();
            UserToUpdate updateUser = (UserToUpdate)session.getAttribute("updateUser");

            //登録処理の呼び出し
            UpdateUserLogic logic = new UpdateUserLogic();
            logic.exute(updateUser);

            //不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("userToUpdate");

            //登録後のフォワード先を設定
            forwardPath = "/WEB-INF/update-jsp/updateDone.jsp";

        }

        // 設定されたフォワード先を設定
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String emp_no = request.getParameter("emp_no");
        String emp_no_after = request.getParameter("emp_no_after");
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

        //登録するユーザの情報を設定
        UserToUpdate updateUser = new UserToUpdate(emp_no, emp_no_after, emp_name, emp_kana, hire_ymd, retirement_ymd, department_data, mail_add, update_date, update_person, registered_date, registered_person);

        //セッションスコープに登録ユーザを保存
        HttpSession session = request.getSession();
        session.setAttribute("updateUser", updateUser);

        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/update-jsp/updateConfirm.jsp");
        dispatcher.forward(request, response);

	}

}
