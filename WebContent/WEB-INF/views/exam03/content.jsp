<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<h4 class="mt-5">POST 방식</h4>
		<hr/>
		<form method="post" action="/servletjsp/exam03/ContentController">
			<input type="text" name="param1" value="홍길동"/> <br/>
			<input type="submit" value="Form으로 제출" class="btn btn-warning"/>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
