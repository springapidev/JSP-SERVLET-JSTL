<%@ taglib uri="http://www.tagunit.org/tagunit/core" prefix="tagunit" %>
<%@ taglib prefix="x" uri="http://www.apress.com/projsp/tags" %>

<tagunit:assertEquals name="Simple filter test">
  <tagunit:actualResult>
    <x:emailAddressFilter>simon.brown@somedomain.com</x:emailAddressFilter>
  </tagunit:actualResult>
  <tagunit:expectedResult>simon.brown@...</tagunit:expectedResult>
</tagunit:assertEquals>