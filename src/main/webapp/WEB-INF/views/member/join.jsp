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
                            <h1 class="fw-bolder">Get in touch</h1>
                            <p class="lead fw-normal text-muted mb-0">We'd love to hear from you</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
            <%-- <form id="contactForm" action="./join" method="post" data-sb-form-api-token="API_TOKEN" enctype="multipart/form-data"> --%>
            						<form:form id="contactForm" action="./join" modelAttribute="memberVO" method="post" data-sb-form-api-token="API_TOKEN" enctype="multipart/form-data">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="userName" type="text" placeholder="Enter Title..." name="userName" data-sb-validations="required" /> -->
                                        <form:input path="userName" cssClass="form-control" id="userName"/>
                                        <form:label path="userName">userName</form:label>
                                        <form:errors path="userName" cssClass="is-invalid"></form:errors>
                                        
                                    </div>
                                    <!-- Writer address input-->
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="password" name="password" type="password" data-sb-validations="required,email"/> -->
                                        <form:password path="password" cssClass="form-control" id="password"/>
                                        <form:label path="password">Password</form:label>
                                        <form:errors path="password" cssClass="is-invalid"></form:errors>
                                    </div>
                          <div class="form-floating mb-3">
                                        <!--  <input class="form-control check" id="passwordCheck" name="passwordCheck" type="password" data-sb-validations="required,email" /> -->
                                        <form:password path="passwordCheck" cssClass="form-control" id="passwordCheck"/>
                                        <form:label path="passwordCheck">PasswordCheck</form:label>
                                        <form:errors path="passwordCheck" cssClass="is-invalid"></form:errors>
                                    </div> 
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="name" type="text" placeholder="Enter Title..." name="name" data-sb-validations="required"/> -->
                                        <form:input path="name" cssClass="form-control" id="name"/>
                                        <form:label path="name">Name</form:label>
                                        <form:errors path="name" cssClass="is-invalid"></form:errors>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control check" id="email" type="email" placeholder="Enter Title..." name="email" data-sb-validations="required" /> -->
                                        <form:input path="email" cssClass="form-control" id="name"/>
                                        <form:label path="email">email</form:label>
                                        <form:errors path="email" cssClass="is-invalid"></form:errors>
                                    </div>
                                    <div class="form-floating mb-3">
                                         <input class="form-control check" id="birth" type="date" placeholder="Enter Title..." name="birth"/> 
                                        <%-- <form:input path="birth" cssClass="form-control" id="birth"/> --%>
                                        <label for="birth">Birth</label>
                                        <form:errors path="birth"></form:errors>
                                       
                                    </div>
                                    
                                    
                                   
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                               </form:form>
                                <%-- </form> --%>
                                </div>
            
            </div>
                    </div>
                </div>
            </section>
            
        
        </main>
		<!-- footer 적용 -->
		   <c:import url="../temp/footer.jsp"></c:import>
		<!-- footer 끝  -->
		<!-- <script type="text/javascript" src="/js/joinFormCheck.js"></script> -->
</body>
</html>