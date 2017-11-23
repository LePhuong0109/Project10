package wp.servlet;
import wp.model.GuestBookEntry; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i=2;
    public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h2>Comment</h2>");
		out.println("<form action='AddComment' method='Post'>");
		out.println("Name: <input type='text' name='name' style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		out.println("Key: <input type='hidden' name='key' value="+ i++ +" style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		out.println("Message: <textarea name='message' rows='5' cols='60' required></textarea>");
		out.println("<input type='submit' name='add' value='Comment' style='background-color: blue;margin: 5px;'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries= (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		String name= request.getParameter("name");
		String message= request.getParameter("message");
		int key= Integer.parseInt(request.getParameter("key"));
		entries.add(new GuestBookEntry(name,message, key));
		response.sendRedirect("GuestBook");
	}

}
