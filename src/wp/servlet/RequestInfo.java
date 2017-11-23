package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
    }
    //Http Servlet Request và Request Header
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>Request Information</title></head><body>");
		//Trả về tên của phương thức HTTP mà yêu cầu này được thực hiện
		out.println("<p>Method: " +request.getMethod() +"</p>");
		//Trả về Context Path 
		out.println("<p>ContextPath: " +request.getContextPath() +"</p>");
		// Trả về địa chỉ của trang này
		out.println("<p>URL: " +request.getRequestURL() +"</p>");
		//Trả về một phần của URL từ Context Path đến Phần path được map tới Servlet. 
		out.println("<p>URI: " +request.getRequestURI() +"</p>");
		//Trả về địa chỉ IP của client gửi yêu cầu
		out.println("<p>RemoteAddress: " +request.getRemoteAddr() +"</p>");
		// Kiểm tra và thông báo nó có hỗ trợ phương thức nén gzip hay không
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
			out.println("<p>Gzip supported.</p>");
		else
			out.println("<p>Gzip not supported.</p>");
		out.println("</body></html>"); 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gọi doGet trong doPost
		doGet(request, response);
	}

}
