package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import lt.bit.data.Person;
import java.util.List;
import lt.bit.db.DB;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            vertical-align: top;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background: #3399ff;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("               text-align: center; \n");
      out.write("            }\n");
      out.write("          \n");
      out.write("            ul {\n");
      out.write("                padding: 20px;\n");
      out.write("                \n");
      out.write("                }\n");
      out.write("                ul > li {\n");
      out.write("                background: #e7e7e7;\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 100%;\n");
      out.write("                float: left;\n");
      out.write("                top: 30px;\n");
      out.write("                bottom: 30px;\n");
      out.write("                margin: 10px;\n");
      out.write("                padding: 10px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                    \n");
      out.write("            .button {\n");
      out.write("                border: none;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                text-align: left;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 12px;\n");
      out.write("                margin: 4px 2px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                \n");
      out.write("            } \n");
      out.write("            .button > a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .button1{\n");
      out.write("                background-color: #e7e7e7; \n");
      out.write("                color: black;\n");
      out.write("                margin: 15px 30px;\n");
      out.write("            }\n");
      out.write("               \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Address Book</h1>\n");
      out.write("        ");
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Person> list = DB.getAll();
            
           // list.sort(p1, p2)->p1.getFirstName().length)-p2.getFirstName().length);
           list.sort((p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName()));
               
           
           /* if (p1.getFirstName() > p2.getFirstName()){
            return  -1;
           }else if(p1.getFirstName().equals(p2.getFirstName())){
               return 0;
           }else{
               return 1;
           }   
           });*/
         
            for (Person p: list){
              
      out.write("\n");
      out.write("     \n");
      out.write("     <ul>\n");
      out.write("         <li><label><b>First name: </b></label>\n");
      out.write("             ");
      out.print(p.getFirstName());
      out.write("<br>\n");
      out.write("             <label><b>Last name: </b></label>\n");
      out.write("             ");
      out.print(p.getLastName());
      out.write(" <br>\n");
      out.write("             <label><b>Birth date: </b></label>\n");
      out.write("             ");
      out.print(sdf.format(p.getBirthDate()));
      out.write("<br> \n");
      out.write("             <label><b>Salary: </b></label>\n");
      out.write("             ");
      out.print(p.getSalary());
      out.write("<br>\n");
      out.write("        <button class=\"button\"><a href=\"delete?id=");
      out.print(p.getId());
      out.write("\">Del</a></button>\n");
      out.write("        <button class=\"button\"><a href=\"edit.jsp?id=");
      out.print(p.getId());
      out.write("\">Edit</a></button>\n");
      out.write("        <button class=\"button\"><a href=\"addresses.jsp?id=");
      out.print(p.getId());
      out.write("\">Addresses</a></button>\n");
      out.write("        <button class=\"button\"><a href=\"contacts.jsp?id=");
      out.print(p.getId());
      out.write("\">Contacts</a></button>\n");
      out.write("    </li>\n");
      out.write("    </ul>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("       \n");
      out.write("     \n");
      out.write("     <button class=\"button button1\"><a href=\"edit.jsp\">New</a></button>\n");
      out.write("         \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
