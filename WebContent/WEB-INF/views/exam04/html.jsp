<%-- page 지시자  --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%-- include 지시자  --%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<a href="/servletjsp/exam04/HtmlResponseController" class="btn btn-warning btn-sm">링크1</a>
		<%-- <a href="/servletjsp/exam04/JsonResponseController" class="btn btn-warning btn-sm">링크2</a> --%>
		<!-- <a href="/servletjsp/exam04/FileResponseController" class="btn btn-warning btn-sm">링크3</a> -->
	</div>
</div>

<%-- include 지시자  --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
