package com.apress.projsp;

class VisAuditOutStream extends ReplaceContentOutputStream
{
  String addr;
  String host;

  public VisAuditOutStream(String inAddr, String inHost) {
    addr = inAddr;
    host = inHost;
  }

  public byte[] replaceContent(byte[] inBytes) {
    StringBuffer sb = new StringBuffer(inBytes.length);
    String result = new String(inBytes);
    String srchString = result.toLowerCase();
    int endBody = srchString.indexOf("</body>");
    if (endBody != -1) {
      sb.append(result.substring(0, endBody));
      sb.append("<br><small><i>Big Brother is watching you. ")
          .append("You have accessed our page from ").append(addr)
          .append(" and on a machine called ").append(host)
          .append("</i></small></br>")
          .append(result.substring(endBody));
    } else {
      sb.append(result);
    }
    return sb.toString().getBytes();
  }
}
