package com.apress.projsp;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisAuditResponseWrapper extends HttpServletResponseWrapper
{
  private PrintWriter tpWriter;
  private VisAuditOutStream tpStream;

  public VisAuditResponseWrapper(ServletResponse inResp, String inAddr,
                                 String inHost)
      throws java.io.IOException
  {
    super((HttpServletResponse) inResp);
    tpStream = new VisAuditOutStream(inAddr, inHost);
    tpWriter = new PrintWriter(tpStream);
  }

  public ServletOutputStream getOutputStream()
      throws java.io.IOException
  {
    return tpStream;
  }

  public PrintWriter getWriter() throws java.io.IOException {
    return tpWriter;
  }
}
