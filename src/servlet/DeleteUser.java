package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteUserLogic;
import model.SearchUser;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUser() {
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

		String action = request.getParameter("action");

		//登録確認画面から「登録実行」をリクエストされたときの処理
		if(action.equals("done")){
			//セッションスコープに保存された登録ユーザを呼び出し
			HttpSession session = request.getSession();
			//UserToDelete userToDelete = (UserToDelete)session.getAttribute("userToDelete");
			SearchUser searchUser = (SearchUser)session.getAttribute("searchUser");

			//削除処理（削除フラグ delete_flag を true に）の呼び出し
			DeleteUserLogic logic = new DeleteUserLogic();
			logic.exute(searchUser);

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("deleteUser");

			//登録後のフォワード先を設定
			forwardPath = "/WEB-INF/delete-jsp/deleteDone.jsp";

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
		//doGet(request, response);

	}

}
