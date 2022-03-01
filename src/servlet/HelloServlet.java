package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   // request.jspから送られてきたテキストを受け取りtextという変数に入れる
		String EmpName = request.getParameter("EmpName");
		String EmpKana = request.getParameter("EmpKana");
		String HireYMD = request.getParameter("HireYMD");
		String RetirementYMD = request.getParameter("RetirementYMD");
		String DepartmentData = request.getParameter("DepartmentData");
		String MailAdd = request.getParameter("MailAdd");

	        // response.jspで文字列を取得するための準備
		request.setAttribute("EmpName", EmpName);
		request.setAttribute("EmpKana", EmpKana);
		request.setAttribute("HireYMD", HireYMD);
		request.setAttribute("RetirementYMD", RetirementYMD);
		request.setAttribute("DepartmentData", DepartmentData);
		request.setAttribute("MailAdd", MailAdd);

		//db
		/*		db db = new db();

				try {
					db.dbconection();
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		*/

		// request.jspを表示する
		request.getRequestDispatcher("response.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
