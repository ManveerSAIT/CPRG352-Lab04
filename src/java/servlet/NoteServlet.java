
package servlet;

import java.util.Scanner;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author manve
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        Scanner scan = new Scanner(new File(path));
        String noteTitle = scan.nextLine();
        String noteContent = scan.nextLine();
        
        scan.close(); 
        
        Note noteObject = new Note(noteTitle, noteContent);
        
        request.setAttribute("note", noteObject);
           
        String param = request.getParameter("edit");
        
        if(param == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return; 
        }
        
        else if(param == ""){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }   
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String notetitle = request.getParameter("title");
        String notecontents = request.getParameter("contents");
        
        Note noteObject = new Note(notetitle, notecontents);
        
        request.setAttribute("note", noteObject);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter pw = new PrintWriter(path); 
        pw.write(notetitle + "\n");
        pw.write(notecontents);
        
        pw.close(); 
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        
    }
}
