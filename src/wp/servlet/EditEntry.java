package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEntry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditEntry() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEntry> entries= (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		int key=Integer.parseInt(request.getParameter("key"));
		//int index=0;
		GuestBookEntry entry=null;
		//lấy vị trí của key truyền vào
		for(int i=0;i<entries.size();i++){	
			if(entries.get(i).getKey()==key)
				entry=entries.get(i);
		}
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title>Edit Entry</title></head><body>");
		out.println("<h2>Comment</h2>");
		out.println("<form action='EditEntry' method='Post'>");
		out.println("Name: <input type='text' name='name' value='"+ entry.getName()+"' style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		out.println("Key: <input type='text' name='key' value='"+ entry.getKey()+"' style='margin-left: 17px ;margin-bottom: 5px;' required/> <br/>");
		out.println("Message: <textarea name='message' rows='5' cols='60' required>"+entry.getMessage()+"</textarea>");
		out.println("<input type='submit' name='add' value='Comment' style='background-color: blue;margin: 5px;'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries= (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		int key=Integer.parseInt(request.getParameter("key"));
		//set lại 2 giá trị vừa xem
		for(int i=0;i<entries.size();i++){	
			if(entries.get(i).getKey()==key)
			{
				entries.get(i).setName(name);
				entries.get(i).setMessage(message);
			}
		}
		response.sendRedirect("GuestBook");
	}

}
