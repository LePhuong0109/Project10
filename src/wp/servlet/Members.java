package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Members() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=(String) request.getSession().getAttribute("user");
		//kiểm tra nếu có 1 session thuộc tính "user", nếu có thì display
		if(user!=null)
		{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>Members</title></head><body>");
		out.println("<h1>This is members- only are!!!</h1>");
		out.println("<p>Welcome, " + user + "</p>");
		out.println("<p><a href='Logout'>Logout</a></p>");
		out.println("</body></html>");
		}
		//ngược lại, redirec người dùng đến trang login
		else
		{
			response.sendRedirect("Login");
		}
		
	}

}
