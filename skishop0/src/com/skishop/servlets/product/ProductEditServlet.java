package com.skishop.servlets.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.product.ProductDao;
import com.skishop.dao.product.ProductTypeDao;
import com.skishop.entity.Product;
import com.skishop.entity.ProductType;

/**
 * Servlet implementation class ProductEditServlet
 */
@WebServlet("/editProduct")
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		ProductDao pd=new ProductDao();
		request.setAttribute("product", pd);
		request.setAttribute("action", "edit");
		ProductTypeDao ptd=new ProductTypeDao();
		List<ProductType> list=ptd.findAll();
		request.setAttribute("pst", list);
		request.getRequestDispatcher("editproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
