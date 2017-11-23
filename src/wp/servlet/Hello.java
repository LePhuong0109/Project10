package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/Hello","/HelloWorld","/a","/trung","/haha/*"})
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Hello() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Tạo một trang html
		PrintWriter out= response.getWriter();//khai báo đối tượng PrintWriter là out
		response.setContentType("text/html");//xuất file html
		//code sinh ra trang html bằng cách gọi out
		out.print("<html><head><title>Chi Trung</title></head><body>");
		out.print("<h2 style='color: red; background-color: blue ;'>Hello Everybody</h2>");
		out.print("</body></html>"); 
		
	}
}