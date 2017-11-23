package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add() {
        super();
    }
    //Request Parameters
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int a=0;
		int b=0;
		// Lấy các giá trị a,b dùng getParameter được nhập thông qua query string hoặc WebForm
		if(request.getParameter("a") != null)
			a = Integer.parseInt(request.getParameter("a"));
		if(request.getParameter("b") != null)
			b = Integer.parseInt(request.getParameter("b"));
		*/
		
		String a = request.getParameter("a");
		String b = request.getParameter("b"); 
		if(a==null || b==null || a.trim().length()==0 ||b.trim().length()==0) {
			/*Gửi một phản hồi chuyển hướng tạm thời đến client bằng cách sử dụng URL */
			response.sendRedirect("AddForm.html");
			return;
		}
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.print("<html><head><title>Add</title></head><body>");
		// In kết quả phép cộng
		int sum = Integer.parseInt(a)+ Integer.parseInt(b);
		out.print("<p>"+ a +" + "+ b +" = "+ sum +"</p>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
