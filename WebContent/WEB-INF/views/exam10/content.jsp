<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<a href="${pageContext.request.contextPath}/exam10/ExceptionHandlingController" class="btn btn-warning btn-sm">try-catch 이용</a>
		<a href="${pageContext.request.contextPath}/exam10/NoExceptionHandlingController" class="btn btn-warning btn-sm">web.xml</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
