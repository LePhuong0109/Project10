package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/RequestCounter",loadOnStartup=1)
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public RequestCounter() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
		//Nhất định phải gọi phương thức init trong lớp cha
		super.init(config);
		int counter=0;
		getServletContext().setAttribute("counter",counter);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get counter
		Integer counter = (Integer)getServletContext().getAttribute("counter");
		//increment  counter
		counter++;
		//set counter to application scope
		getServletContext().setAttribute("counter",counter);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>RequestCounter</title></head><body>");
		out.println("<h1>You are visitor "+ counter  + ".</h1>");
		out.println("</body></html>");
	}

}