<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<h4>GET 방식</h4>
		<a href="${pageContext.request.contextPath}/exam02/GetController?param1=value1&param2=value2" class="btn btn-warning">링크로 이동</a>
		<hr/>
		<form method="get" action="${pageContext.request.contextPath}/exam02/GetController">
			<input type="text" name="param3" value="value3"/> <br/>
			<input type="text" name="param4" value="value4"/> <br/>
			<input type="submit" value="Form으로 제출" class="btn btn-warning"/>
		</form>

		<h4 class="mt-5">POST 방식</h4>
		<hr/>
		<form method="post" action="${pageContext.request.contextPath}/exam02/PostController">
			<input type="text" name="param3" value="value3"/> <br/>
			<input type="text" name="param4" value="value4"/> <br/>
			<input type="submit" value="Form으로 제출" class="btn btn-warning"/>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
