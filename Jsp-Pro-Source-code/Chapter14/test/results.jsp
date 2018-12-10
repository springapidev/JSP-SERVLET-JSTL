<!--
normal = 6699CC
red = CC0000
warning = CC6600
pass = 00CC00

-->

<%@ page import="org.tagunit.*" %>
<%@ page errorPage="error.jsp" %>

<%
  String color = "#6699CC";
  TestContextContainer testContext = (TestContextContainer)session.getAttribute(Constants.TEST_CONTEXT);
  if (testContext != null && testContext.getStatus().equals(TestContext.PASS)) {
    color = "#00CC00";
  } else if (testContext != null && testContext.getStatus().equals(TestContext.WARNING)) {
    color = "#CC6600";
  } else if (testContext != null && (testContext.getStatus().equals(TestContext.FAIL) || testContext.getStatus().equals(TestContext.ERROR))) {
    color = "#CC0000";
  }

  String uri = request.getParameter("uri");
%>

<%@ taglib uri="http://www.tagunit.org/tagunit/display" prefix="tagunit" %>

<html>

  <head>
    <title>TagUnit - Test Results</title>
    <tagunit:base/>
    <link rel="stylesheet" href="page.css">
  </head>

  <body>

    <table width="100%" cellpadding="0" cellspacing="2" class="banner">
      <tr>
        <td width="200">
          <a href="../index.jsp"><img src="images/tagunit.gif" alt="Banner image" border="0" /></a></td>
        <td bgcolor="<%= color %>" valign="top" align="right">
          Version <tagunit:getProperty name="version"/>&nbsp;
        </td>
      </tr>
    </table>

    <table width="100%" border="0">
      <tr>
        <td>
          <h2>Test results</h2>
        </td>
        <td align="right">
          <a href="servlet/RunTests?uri=<%= uri %>">Re-run tests</a>
          |
          <a href="servlet/ViewResults?uri=<%= uri %>&showPasses=false&showWarnings=true">Hide passes</a>
          |
          <a href="servlet/ViewResults?uri=<%= uri %>&showPasses=false&showWarnings=false">Hide warnings</a>
          |
          <a href="servlet/ViewResults?uri=<%= uri %>&showPasses=true&showWarnings=true">Show all</a>
          <br>
          Ignore Warnings -
          <a href="servlet/ViewResults?uri=<%= uri %>&showPasses=true&showWarnings=true&ignoreWarnings=true">Yes</a>
          |
          <a href="servlet/ViewResults?uri=<%= uri %>&showPasses=true&showWarnings=true&ignoreWarnings=false">No</a>
        </td>
      </tr>
    </table>


    <div align="center">
      <br />
      <br />
      <table>
        <tr>
          <td>
            <table>
              <tr height="1">
                <td width="64"></td>
                <td width="400" bgcolor="#000000"></td>
                <td width="32"></td>
              </tr>
            </table>
            <table>
              <tr>
                <td width="64">
                  <b>Passes</b>
                </td>
                <td width="<%= (testContext.getNumberOfPasses()*400)/testContext.getNumberOfTests() %>" bgcolor="#00CC00"></td>
                <td width="32">
                  <%= testContext.getNumberOfPasses() %>
                </td>
              </tr>
            </table>
            <%
                if (!org.tagunit.TagUnitProperties.getInstance().getIgnoreWarnings()) {
            %>
            <table>
              <tr>
                <td width="64">
                  <b>Warnings</b>
                </td>
                <td width="<%= (testContext.getNumberOfWarnings()*400)/testContext.getNumberOfTests() %>" bgcolor="#CC6600"></td>
                <td width="32">
                  <%= testContext.getNumberOfWarnings() %>
                </td>
              </tr>
            </table>
            <%
                }
            %>
            <table>
              <tr>
                <td width="64">
                  <b>Failures</b>
                </td>
                <td width="<%= (testContext.getNumberOfFailures()*400)/testContext.getNumberOfTests() %>" bgcolor="#CC0000"></td>
                <td width="32">
                  <%= testContext.getNumberOfFailures() %>
                </td>
              </tr>
            </table>
            <table>
              <tr>
                <td width="64">
                  <b>Errors</b>
                </td>
                <td width="<%= (testContext.getNumberOfErrors()*400)/testContext.getNumberOfTests() %>" bgcolor="#CC0000"></td>
                <td width="32">
                  <%= testContext.getNumberOfErrors() %>
                </td>
              </tr>
            </table>

            <table>
              <tr height="1">
                <td width="64"></td>
                <td width="400" bgcolor="#000000"></td>
                <td width="32"></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <br />
      <br />
    </div>

    <table width="100%" border="0">
      <tagunit:testResults id="result">

        <tagunit:showLevel level="1">
          <tr><td colspan="2">&nbsp;</td></tr>
        </tagunit:showLevel>

        <tr>
          <td>
            <img src="images/spacer.gif" width="<%= level.intValue()*16 %>" height="1">
            <tagunit:hasChildren><b></tagunit:hasChildren>
            <%
                if (result instanceof org.tagunit.TagTestContext) {
                  org.tagunit.TagTestContext ttc = (org.tagunit.TagTestContext)result;
                  out.print("<a name=\"" + ttc.getTagInfo().getName() + "\">");
                  out.print("<a href=\"servlet/RunTests?uri=" + uri + "&tag=" + ttc.getTagInfo().getName() + "\">");
                }
            %>
            <jsp:getProperty name="result" property="name"/>
            <%
                if (result instanceof org.tagunit.TagTestContext) {
                  out.print("</a>");
                }
            %>
            <tagunit:hasChildren></b></tagunit:hasChildren>
          </td>
          <td>
            <tagunit:hasChildren><b></tagunit:hasChildren>
            <tagunit:pass><span class="pass">Pass</span></tagunit:pass>
            <tagunit:warning><span class="warning">Warning</span></tagunit:warning>
            <tagunit:failure><span class="fail">Fail</span></tagunit:failure>
            <tagunit:error><span class="error">Error</span></tagunit:error>
            <tagunit:hasChildren></b></tagunit:hasChildren>
          </td>
        </tr>

        <tagunit:hasMessage>
            <tagunit:warning>
              <tr><td><span class="warning"><img src="images/spacer.gif" width="<%= level.intValue()*24 %>" height="1">Warning : <tagunit:filter><jsp:getProperty name="result" property="message"/></tagunit:filter></span></td><td>&nbsp;</td></tr>
            </tagunit:warning>
            <tagunit:failure>
              <tr><td><span class="fail"><code><img src="images/spacer.gif" width="<%= level.intValue()*24 %>" height="1">Failure : <tagunit:filter><jsp:getProperty name="result" property="message"/></tagunit:filter></code></span></td><td>&nbsp;</td></tr>
            </tagunit:failure>
            <tagunit:error>
              <tr><td><span class="error"><code><img src="images/spacer.gif" width="<%= level.intValue()*24 %>" height="1">Error : <tagunit:filter><jsp:getProperty name="result" property="message"/></tagunit:filter></code></span></td><td>&nbsp;</td></tr>
            </tagunit:error>
        </tagunit:hasMessage>

      </tagunit:testResults>

    </table>

    <br />
    <br />

    <div align="center">
        <a href="license.html">License</a>
    </div>

  </body>

</html>
