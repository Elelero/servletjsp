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
		<table class="table table-sm table-bordered mt-3">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>글쓴이</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${pageList}">
				<tr>
					<td>${board.bno}</td>
					<td><a href="DetailViewController?bno=${board.bno}" style="color: RoyalBlue; font-weight: bold;">${board.btitle}</a></td>
					<td>${board.bcontent}</td>
					<td>${board.bwriter}</td>
					<td>${board.bhitcount}</td>
					<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/></td>
				</tr>
				</c:forEach>
				
				<tr>
					<td colspan="6" class="text-center">
						<div>
							<a href="ContentController?pageNo=1" class="btn btn-outline-warning btn-sm">처음</a>
							
							<c:if test="${pager.groupNo > 1}">
								<a href="ContentController?pageNo=${pager.startPageNo-1}" class="btn btn-outline-primary btn-sm">이전</a>
							</c:if>
							
							<c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}" step="1">
								<c:if test="${pager.pageNo != i}"> 
									<a href="ContentController?pageNo=${i}" class="btn btn-outline-secondary btn-sm">${i}</a>
								</c:if>

								<c:if test="${pager.pageNo == i}"> 
									<a href="ContentController?pageNo=${i}" class="btn btn-outline-danger btn-sm">${i}</a>
								</c:if>
							</c:forEach>
							
							<c:if test="${pager.groupNo < pager.totalGroupNo}">
							<a href="ContentController?pageNo=${pager.endPageNo+1}" class="btn btn-outline-primary btn-sm">다음</a>
							</c:if>
							
							<a href="ContentController?pageNo=${pager.totalPageNo}" class="btn btn-outline-warning btn-sm">맨끝</a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
