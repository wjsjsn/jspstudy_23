package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex10_1")
public class Ex10_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		// jsp에 out 내장 객체가 존재하는데 같은 기능을 함
		PrintWriter out = response.getWriter();
		
		// 페이지 이동(포워딩, 리다이렉트) : JSP에도 존재하고 사용하는 기능
		//                         현재 페이지에서 작업 후 다른 페이지로 이동
		//                         (현재 페이지가 보이지 x)
		
		// 리다이렉트 : 다른 페이지에서 다른 페이지로 이동하면서 
		//          기존의 request와 response 정보가 사라짐
		//          새로운 request와 response가 만들어짐
		//          즉, 파라미터값들이 최종 페이지에서는 사라짐
		//          주소창에는 최종 주소가 보임
		// 사용법 : response.sendRedirect("이동할 주소");
		//        이동할 주소가 servlet이면 확장자를 사용하지 않음
		//        이동할 주소가 html이면 확장자를 사용
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		out.println("<h2>Ex10_1</h2>");
		out.println("<h3><ul>");
		out.println("<li>이름 : " + name + "</li>");
		out.println("<li>나이 : " + age + "</li>");
		out.println("</ul></h3>");
		
		// 리다이렉트 실행
		response.sendRedirect("Ex10_2");
	}
}
















