package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import lt.bit.data.Address;
import lt.bit.db.DB;

public final class addresses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("       ");
 
            String ids = request.getParameter("id");
                try{
                Integer id = Integer.valueOf(ids);
                List<Address> addresses = DB.getById(id).getAddresses();
         
         for(int i=1; i<addresses.size();i++){
        
      out.write("\n");
      out.write("    <li>");
      out.print(addresses.get(i).getAddress());
      out.write(' ');
      out.print(addresses.get(i).getCity());
      out.write(' ');
      out.write(' ');
      out.print(addresses.get(i).getPostalCode());
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"save\">\n");
      out.write("            \n");
      out.write("             \n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(id);
      out.write("\" name=\"id\">\n");
      out.write("            \n");
      out.write("                \n");
      out.write("           <input name=\"address\" value=\"");
      out.print(addresses.get(i).getAddress());
      out.write("\"> \n");
      out.write("           <input name=\"city\" value=\"");
      out.print(addresses.get(i).getCity());
      out.write("\"> \n");
      out.write("           <input name=\"postalCode\" value=\"");
      out.print(addresses.get(i).getPostalCode());
      out.write("\"> \n");
      out.write("           \n");
      out.write("           <a href=\"deleteAddress?id=");
      out.print(addresses.get(i).getAddress());
      out.write("\">Del</a>\n");
      out.write("           <a href=\"editAddress.jsp?id=");
      out.print(addresses.get(i).getAddress() );
      out.write("\">Edit</a>\n");
      out.write("        </li>\n");
      out.write("        ");
 } 
         }catch(Exception ex){
                //ignore
            }
      out.write("\n");
      out.write("           <input type=\"submit\" value=\"save\">\n");
      out.write("            <a href=\"editAddress.jsp?\">New</a>\n");
      out.write("           <a href=\"index.jsp\">Back</a>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    \n");
      out.write("       \n");
      out.write("    </body>\n");
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
