package wp.servlet;
import wp.model.GuestBookEntry;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i=2;
    public AddCommentWithSession() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h2>Comment</h2>");
		out.print("<form action='AddCommentWithSession' method='Post'>");
		
		String name= (String) request.getSession().getAttribute("name");
		if(name!=null)
			out.println("Name: "+ name +"</br>");
		//Ngược lại display input field
		else
			out.println("Name: <input type='text' name='name' style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		
		
		out.println("<input type='hidden' name='key' value="+ i++ +" style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		out.println("Message: <textarea name='message' rows='5' cols='60' required></textarea>");
		out.println("<input type='submit' name='add' value='Comment' style='margin: 5px;'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy name từ cookie
		String name= (String) request.getSession().getAttribute("name");
		if(name==null)
		{
			 name=request.getParameter("name");
			 request.getSession().setAttribute("name", name);
			
		}
		
		String message=request.getParameter("message");
		int key= Integer.parseInt(request.getParameter("key"));
		//create  guestbook entry
		GuestBookEntry entry= new GuestBookEntry(name,message,key);
		//add a new entry to the guestBook
		List<GuestBookEntry> entries=(List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(entry);
	
		response.sendRedirect("GuestBook");
	}
}
