package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AddCommentDAO;
import wp.model.GuestBookEntry;

@WebServlet("/Addcomment")
public class Addcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addcomment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");   // Set contentype khi xuat ra mot file html.
		
		out.println("<html><head><title>Add Comment</title><head><body>");
		out.println("<form action='AddComment' method='Post'>");
		out.println("Name:<input type='text' name='name'/><br/>");
		out.println("Message:<textarea name='message' rows='5' cols='60'></textarea>");
		out.println("<input type='submit' name='add' value='Add'/>");
		
		out.println("</form>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");		
		AddCommentDAO a = new AddCommentDAO();
		try {
			a.themComment(name, message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("GuestBook.jsp"); 
	}

}
