package wp.servlet;
import wp.model.GuestBookEntry; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/GuestBook", loadOnStartup=1) //Đảm bảo dữ liệu được khởi tạo trước khi các servlet nào được gọi sử dụng
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBook() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Khởi tạo và gán giá trị vào List GuestBookEntry là entries
		List<GuestBookEntry> entries= new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("Join","Hello", 0));
		entries.add(new GuestBookEntry("Joe","Nice site",1));
		//Đưa danh sách của entries vào trong ServletContext
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy danh sách của entries trong ServletContext
		List<GuestBookEntry> entries =  (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		
		PrintWriter out= response.getWriter();
		
		response.setContentType("text/html");

		out.println("<html><head><title>Guest Boook</title></head><body>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Message</th><th>Key</th><th colspan='2'>Option</th></tr>");
		for( int i=0; i<entries.size(); i++) {
			GuestBookEntry entry = entries.get(i);
			out.println("<tr><td>"+entry.getName()+" says: </td><td>"+ entry.getMessage() +
					"</td><td>"+entry.getKey()+"</td><td><a href='EditEntry?key="+entry.getKey()+"'>Edit</a></td> <td><a href='DeleteEntry?key="+entry.getKey()+"'>Delete</a></td></tr>");
		}
		
		out.println("</table>");
		out.println("<p><a href='AddComment'>Add Comment</a></p>");
		out.println("<p><a href='AddCommentWithCookie'>Add Comment with Cookie</a></p>");
		out.println("<p><a href='AddCommentWithSession'>Add Comment with Session</a></p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
