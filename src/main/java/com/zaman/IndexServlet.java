package com.zaman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description="index",urlPatterns={"/index"},
			initParams={@WebInitParam(name="email",value="c.bulut@zaman.com.tr")})
public class IndexServlet extends HttpServlet{
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=utf-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter w = res.getWriter();
		w.println("test şimdi yarın");
		String wop = "deneme verileri";
		ServletContext ctx = getServletContext();
//		ctx.setAttribute("wop", wop);

		req.setAttribute("wop", wop);
		req.setAttribute("email", ctx.getInitParameter("email"));
		
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, res);
	}
}
