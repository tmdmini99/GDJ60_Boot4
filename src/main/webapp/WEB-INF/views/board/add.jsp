<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Modern Business - Start Bootstrap Template</title>
<!-- css favicon -->
<c:import url="../temp/style.jsp"></c:import>
<!-- Bootstrap icons-->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
   rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
<!-- css favicon end-->
</head>

<body class="d-flex flex-column h-100">
   <main class="flex-shrink-0">
      <!-- Navigation-->
      <c:import url="../temp/header.jsp"></c:import>
      <!-- Header-->
 <!-- Page content-->
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
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- * * SB Forms Contact Form * *-->
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- This form is pre-integrated with SB Forms.-->
                                <!-- To make this form functional, sign up at-->
                                <!-- https://startbootstrap.com/solution/contact-forms-->
                                <!-- to get an API token!-->
                               <%--  <form id="contactForm" action="./add" method="post" enctype="multipart/form-data"> --%>
                                    <form:form id="contactForm"  modelAttribute="boardVO" action="./add" method="post" enctype="multipart/form-data">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="title" type="text" name="title" placeholder="제목을 입력하세요" data-sb-validations="required" /> -->
                                        <form:input path="title" id="title" cssClass="form-control"/>
                                        <label for="title">Title</label>
                                        <form:errors path="title"></form:errors>
                                    </div>
                                    <!-- 작성자 address input-->
                                    <div class="form-floating mb-3">
                                       <form:input path="writer" id="writer" cssClass="form-control"/>
                                        <!-- <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required,email" /> -->
                                        <label for="writer">Writer</label>
                                        <form:errors path="writer" cssClass="is-invalid"></form:errors>
                                    </div>
                                 
                                 	
                                 
                                 	
                                    <!-- Message input-->
                                    <div class="form-floating mb-3">
                                       <input type ="file" name = "boardFiles" >
                                    </div>
                                 
                                  
                      
                                    <!-- Message input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" id="contents" name="contents" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="contents">contents</label>
                                        <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                                    </div>
                                   
                                    <!-- This is what your users will see when there is-->
                                   <!-- an error submitting the form-->
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                               </form:form>
                            </div>
                        </div>
                    </div>
                    <!-- Contact cards-->
                    <div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-chat-dots"></i></div>
                            <div class="h5 mb-2">Chat with us</div>
                            <p class="text-muted mb-0">Chat live with one of our support specialists.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-people"></i></div>
                            <div class="h5">Ask the community</div>
                            <p class="text-muted mb-0">Explore our community forums and communicate with other users.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-question-circle"></i></div>
                            <div class="h5">Support center</div>
                            <p class="text-muted mb-0">Browse FAQ's and support articles to find solutions.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-telephone"></i></div>
                            <div class="h5">Call us</div>
                            <p class="text-muted mb-0">Call us during normal business hours at (555) 892-9403.</p>
                        </div>
                    </div>
                </div>
            </section>
   </main>
   
   <!-- Footer 적용 -->
   <c:import url="../temp/footer.jsp"></c:import>
   <!-- <script type="text/javascript" src="/js/boardform.js"></script> -->
   <script src="https://code.jquery.com/jquery-latest.min.js"></script>
   
   <!-- Footer 끝 -->
</body>
</html>