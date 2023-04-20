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
            <form id="contactForm" action="./login" method="post" data-sb-form-api-token="API_TOKEN" enctype="multipart/form-data">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="title" type="text" placeholder="Enter Title..." name="userName" data-sb-validations="required" />
                                        <label for="title">Name</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                                    </div>
                                    <!-- Writer address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="writer" name="password" type="password" data-sb-validations="required,email" />
                                        <label for="writer">Password</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    
                                    
                                    
                                   
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form>
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