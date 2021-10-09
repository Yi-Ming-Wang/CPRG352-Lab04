/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author adamw
 */
public class NoteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = "";
        String contents = "";
        String URL;
        String path;
        String href;
        
        path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //href = request.getParameter("href");
// to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        title = br.readLine();
        //while(br.readLine() != null ){
        contents = br.readLine();
        //}
        br.close();
        Note fileContents = new Note(title, contents);

       
        
        
        href = request.getParameter("edit");
        
        
        if (href == null){
            request.setAttribute("CONTENTS", fileContents);
            URL = "/WEB-INF/viewnote.jsp";   // view page
            getServletContext().getRequestDispatcher(URL).forward(request, response);
            return;
            
        }
        else
        {
            request.setAttribute("CONTENTS", fileContents);
            URL = "/WEB-INF/editnote.jsp";   // edit page
            getServletContext().getRequestDispatcher(URL).forward(request, response);
            return;
        }
           

        //if( href.equals("edit")){
        //URL = "/WEB-INF/editnote.jsp";    
        //}
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = "";
        String contents = "";
        String URL;
        String path;
        title = request.getParameter("EDIT_TITLE");
        contents = request.getParameter("EDIT_CONTENTS");
        URL = "/WEB-INF/viewnote.jsp";
        Note fileContents = new Note(title, contents);

        // to write to a file
        path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        pw.println(title);
        pw.println(contents);
        pw.close();

        request.setAttribute("CONTENTS", fileContents);
        getServletContext().getRequestDispatcher(URL).forward(request, response);
        return;
    }

}
