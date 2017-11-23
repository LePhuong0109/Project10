package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		//tạo form chứa 2  thông tin được thêm vào
		out.print("<html><head><title>Login</title></head><body>");
		out.print("<form action='Login' method='Post'>");
		out.println("Username:<input type='text' name='username'/><br/>");
		out.println("Password:<input type='text' name='password' rows='5' cols='60'/>");
		//sau khi submit thì các giá trị name và mesage sẽ được gửi thông qua phương thức Post
		out.println("<input type='submit' name='submit' value='Submit'/>");
		out.println("</form>");
		out.print("</body></html>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//Kiểm tra username và password, nếu đúng thì redirect tới members page
		if(username.equals("loc") && password.equals("113"))
		{
			//tùy thuộc trang members nó muốn hiển thị ra cái gì thì ta xét thuộc tính nó here
			request.getSession().setAttribute("user", username);
			response.sendRedirect("Members");
		}
		//Ngược lại redirect tới login page
		else
		{
			response.sendRedirect("Login");
		}
	}

}
