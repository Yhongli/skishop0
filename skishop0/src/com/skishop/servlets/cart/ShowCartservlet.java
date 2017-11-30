package com.skishop.servlets.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.service.Cart;
import com.skishop.service.CartItem;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		Cart c=(Cart)session.getAttribute("cart");
		if(c==null){
			request.getRequestDispatcher("checkout0.jsp").forward(request, response);
		}else{
		List<CartItem> cartlist = new ArrayList();		
		Iterator i=c.container.values().iterator();
		while(i.hasNext()){
			CartItem ci=(CartItem)i.next();
			cartlist.add(ci);
		}
		request.setAttribute("cartlist", cartlist);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);	
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
