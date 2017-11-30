package com.skishop.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.user.UserDao;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		request.getRequestDispatcher("checkout.jsp").forward(request, response);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDao ud=new UserDao();
		if(ud.findAll(email).getEmail()==null){
			String msg1 = "请输入邮箱名";
			request.setAttribute("msg1", msg1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			if(ud.findAll(email).getEmail()==email && ud.findAll(password).getPassword()==password){
				String msg2 = "登陆成功";
				request.setAttribute("msg2", msg2);
				request.getRequestDispatcher("addproduct.jsp").forward(request, response);
			}else{
				String msg3 = "信息输入有误……登陆失败";
				request.setAttribute("msg3",msg3);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
