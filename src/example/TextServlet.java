package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class TextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = iso-8859-2");
        getText(request, response);
        PrintWriter writer = response.getWriter();

        writer.println("<html><body><i>" +  getText(request, response) + "</i></body><br/></html>");

        writer.println("<html><body><h1> Ilość znaków wynosi: " + textLenght(request, response) + "<br/>"+
                "Ilość znaków (bez spacji) wynosi: " + changedTextLenght(request, response)+ "<br/>"+
                "Ilość słów wynosi: " + words(request, response)+ "<br/>"+
                "Palidrom: " + new StringBuffer(getText(request, response)).reverse().toString().equalsIgnoreCase(getText(request, response)) + "</h1></body></html>");
    }


    public static String getText(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = iso-8859-2");
        String text = request.getParameter("message");
        return text;
    }

    public static int textLenght(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return getText(request, response).length();
    }

    public static String changeText(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String newArea = getText(request, response).replace(" ", "");
        return newArea;
    }

    public static int changedTextLenght(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return changeText(request, response).length();
    }

    public static int words(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] strings = getText(request, response).split(" ");
        return strings.length;
    }


}


