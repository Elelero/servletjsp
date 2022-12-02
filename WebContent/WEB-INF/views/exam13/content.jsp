<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		게시글목록
	</div>
	<div class="card-body">
		<a href="WriteController" class="btn btn-warning btn-sm">글쓰기</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
