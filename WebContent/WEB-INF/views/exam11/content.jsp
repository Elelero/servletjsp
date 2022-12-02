<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<h4 class="mt-3">값 출력</h4>
		1. ${5} <br/>
		2. ${"홍길동"} <br/>
		
		<h4 class="mt-3">산술 연산자</h4>
		3. ${2+5} <br/>
		4. ${7 mod 3} , ${7 % 3} <br/>
		
		<h4 class="mt-3">논리 연산자</h4>
		5. ${true || false} , ${true or false} <br/>
		6. ${true && false} , ${true and false} <br/>
		7. ${!true} , ${not true} <br/>
		
		<h4 class="mt-3">비교 연산자</h4>
		8. ${2 < 5} , ${2 lt 5} <br/>
		9. ${2 > 5} , ${2 gt 5} <br/>
		9. ${2 <= 5} , ${2 le 5} <br/>
		10. ${2 >= 5} , ${2 ge 5} <br/>
		11. ${2 != 5} , <%-- ${2 ne 5} --%> <br/>
		12. ${empty null} , ${empty ""} <br/>
		
		<h4 class="mt-3">PageContext를 이용해서 Request, Response, Session의 Getter 얻기</h4>
		<%-- 13. ${pageContext.getRequest().getContextPath()} <br/> --%>
		13. ${pageContext.request.contextPath} <br/>
		<%-- 13. ${pageContext.request.queryString} <br/> --%>
		
		<h4 class="mt-3">request 범위 -> session 범위 -> application 범위순으로 저장된 이름의 값을 출력</h4>
		14. | 유저ID: ${user.userId} | 유저명: ${user.userName} | <br/>
		15. | 게시글 번호: ${board.bno} | 게시글 제목: ${board.btitle} | 게시글 내용: ${board.bcontent} | <br/>
		16. | 객체정보: ${info} |
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
