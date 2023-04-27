<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">Find Password</h1>
                            
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                          <c:choose>
                          <c:when test="${empty check}">
                           <form:form id="contactForm" action="./findPassword" modelAttribute="memberVO" method="post" data-sb-form-api-token="API_TOKEN" enctype="multipart/form-data">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="userName" type="text" placeholder="Enter Title..." name="userName" data-sb-validations="required" /> -->
                                        <form:input path="username" cssClass="form-control" id="username"/>
                                        <form:label path="username">userName</form:label>
                                        <form:errors path="username" cssClass="is-invalid"></form:errors>
                                        
                                    </div>
                                   
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="email" type="email" placeholder="Enter Title..." name="email" data-sb-validations="required" /> -->
                                        <form:input path="email" cssClass="form-control" id="name"/>
                                        <form:label path="email">email</form:label>
                                        <form:errors path="email" cssClass="is-invalid"></form:errors>
                                    </div>
                                   
                                    
                                    
                                   
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                               </form:form>
                               </c:when>
                               <c:otherwise>
                               		<script type="text/javascript">
                               			alert("비밀번호 변경 완료");
                               			location.href="/member/login"
                               		</script>
                               </c:otherwise>
                                </c:choose>
                                </div>
            
                     </div>
                    </div>
                </div>
            </section>
            
        
        </main>
      <!-- footer 적용 -->
         <c:import url="../temp/footer.jsp"></c:import>
      <!-- footer 끝  -->
</body>
</html>