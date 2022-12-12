<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      게시물 보기
   </div>
   <div class="card-body">   
      <div>
         <div>
            <div>
               <p>
                  <span><b>번호:  </b></span> 
                  <span>${board.bno}</span>
               </p>
               
               <p>
                  <span><b>제목:  </b></span> 
                  <span>${board.btitle}</span>
               </p>
               
               <p>
                  <span><b>글쓴이:  </b></span> 
                  <span>${board.bwriter}</span>
               <p>
               
               <p>
                  <span><b>조회수:  </b></span> 
                  <span>${board.bhitcount}</span>
               <p>
               
               <p>
                  <span><b>날짜:  </b></span> 
                  <span><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd HH.mm.ss"/></span> <br/>
               </p>
               
               <c:if test="${board.bfileName != null}">
	               <p>
	                  <span><b>첨부:  </b></span>
	                  <span>
	                  	  <a href="DownloadAttachController?bno=${board.bno}">
	                  	  	<img src="DownloadAttachController?bno=${board.bno}" width="100">
	                  	  </a>
                  	  </span> <br/>
	               </p>
               </c:if>
               
               <c:if test="${board.bfileName == null}">
               	 <p>
              	 	<span><b>첨부:  </b></span>
              	 	<span>첨부된 이미지가 없습니다!</span>
              	 </p>	
               </c:if>
            </div>
            
            <div>
               <span class="title"><b>내용:  </b></span> <br/>
               <textarea style="width:100%" readonly>${board.bcontent}</textarea>
            </div>
            
            <a class="btn btn-warning btn-sm mt-2" href="ContentController">목록</a>
            <a class="btn btn-warning btn-sm mt-2" href="UpdateController">수정</a>
            <a class="btn btn-warning btn-sm mt-2" href="DeleteController">삭제</a>
            
         </div>
      </div>
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>