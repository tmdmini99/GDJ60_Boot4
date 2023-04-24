<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- css favicon -->
        <c:import url="../temp/style.jsp"></c:import>
        <!-- css favicon -->
    </head>
<body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
        	<!-- Navigation-->
          	 <c:import url="../temp/header.jsp"></c:import>
            <!-- Header-->
            <section class="bg-light py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">${board} List</h1>
                        <p class="lead fw-normal text-muted mb-0">With our no hassle pricing plans</p>
                    </div>
                    <div>
                    	<table class="table table-hover">
                    	<thead>
                    		<tr>
                    			<th>Num</th>
                    			<th>Title</th>
                    			<th>Writer</th>
                    			<th>Date</th>
                    			<th>Hit</th>
                    		</tr>
                    	</thead>
                    	<tbody>
                    	<c:forEach items="${list}" var="boardVO">
                    		<tr>
                    		<td>${boardVO.num}</td>
                    		<td><a href="./detail?num=${boardVO.num}">${boardVO.title}</a></td>
                    		<td>${boardVO.writer}</td>
                    		<td>${boardVO.regDate}</td>
                    		<td>${boardVO.hit}</td>
                    		
                    		<%-- 
                    			<td>${boardVO.ref}</td>
                    			<td>${boardVO.depth}</td>
                    			<td>${boardVO.step}</td> --%>
                    		
                    		</tr>
                    	
                    	</c:forEach>
                    	
                    	</tbody>
                    	</table>
                    </div>
                   
                   <!-- paging1 -->
		<div class="row">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<a class="page-link" href="./list" aria-label="Previous" data-board-page="1">
			        			<!-- 						==page=1 -->
			        			
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<a class="page-link" href="/list?page=${pager.startNum-1}" aria-label="Previous" data-board-page="${pager.startNum-1}">
			        			<span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->
			      			</a>
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    		<li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="./list?page=${i}" data-board-page="${i}">${i}</a></li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after ? 'disabled' : ''}"> <!--  -->
			      			<a class="page-link " href="./list?page=${pager.lastNum+1}"  aria-label="Next" data-board-page="${pager.lastNum+1}">
			        			<span aria-hidden="true">&rsaquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<a class="page-link " href="./list?page=${pager.totalPage}"  aria-label="Next" data-board-page="${pager.totalPage}">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		</li>
		  			</ul>
				</nav>
		
			</div>
                   
                   
                   
                   
                   <%-- <!-- paging2 -->
		<div class="row">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="1">
			        			<!-- 						==page=1 -->
			        			
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
			        			<span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->
			      			</a>
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    		<li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="#" data-board-page="${i}">${i}</a></li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after ? 'disabled' : ''}"> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
			        			<span aria-hidden="true">&rsaquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		</li>
		  			</ul>
				</nav>
		
			</div> --%>
			<!-- 검색창 -->
			<form class="row g-3" action="./list" method="get" id="searchForm">
				<input type="hidden" name="page" value="1" id="page">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label>
					<select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title" ${pager.kind eq 'title' ? 'selected' : '' }>제목</option>
						<option value="contents" ${pager.kind eq 'contents' ? 'selected' : '' }>내용</option>
						<option value="wrtier" ${pager.kind eq 'writer' ? 'selected' : '' }>작성자</option>
					</select>
				</div>
				<div class="col-auto">
					<label for="Search" class="visually-hidden">Search</label>
					<input type="text" class="form-control" name="search" id="search" placeholder="검색어 입력" value="${pager.search}">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
                    
                </div>
            </section>
            
        <a href="./add">write</a>
        
        </main>
		<!-- footer 적용 -->
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
  
		<script type="text/javascript" >

		const pl = document.getElementsByClassName("page-link");
		const searchForm=document.getElementById("searchForm");
		const page=document.getElementById("page");

		//for
		//for of -- for(꺼내타입명 변수명 : 배열명 Collection)

		//js 향상된 for문
		for(let p of pl){
		    p.addEventListener("click",function(e){
		        
		        let v=p.getAttribute("data-board-page");
		        page.value=v;
		        console.log(v);
		        searchForm.submit();
		        
		    });
		}
		</script> -->
		   <c:import url="../temp/footer.jsp"></c:import>
		<!-- footer 끝  -->
</body>
</html>