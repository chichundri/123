<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<%
String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + request.getContextPath();
/* out.println(basePath); */
String CONTEXT_PATH = request.getContextPath();

%>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="js/dropdown.js"></script>
	<script src="js/bootstrap-3.3.7.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/AjaxJson.js"></script>
	
	<link rel="stylesheet" href="css/dropdown.css">
	<link rel="stylesheet" href="css/bootstrap-3.3.7.min.css">
	<link rel="stylesheet" href="css/font-awesome.css">
	<link rel="stylesheet" href="css/style.css">
	<%-- <link type="text/css" href="<%=basePath%>/resources/css/bootstrap-3.3.7.min.css" rel="stylesheet"/> --%>
</head>
<body>
<div class="container-fluid bg-primary" style="margin-bottom:1px">
	<div class="row" style="border-radius: 4px; height: 40px; ">
	  <div class="col-sm-10"></div>
	  <div class="col-sm-2" style="padding-top:8px;color:white;">
	  	<a href="" class="whiteFontWithpaddingLeft" data-toggle="modal" data-target="#signUpModel">SignUp</a>
	  	<a href="" class="whiteFontWithpaddingLeft" data-toggle="modal" data-target="#loginModel">Login</a>
	  </div>
	</div>
</div>
<ul id="nav">
<li class="site-name"><a href="#">Site Name </a></li>
	<c:forEach items="${productCategory}" var="category">
    <li class=""><a href="">${category.categoryName}</a>
        <ul>
        <c:if test="${not empty category.prodSubcategories}">
        <c:forEach items="${category.prodSubcategories}" var="subcategories">
        <li><a href="#">${ subcategories.subcategoryName }</a>           
            <ul>
            <c:if test="${not empty subcategories.products}">
            <c:forEach items="${subcategories.products}" var="product">
                <li><a href="#">${ product.productOwner }</a></li>
            </c:forEach>
            </c:if>
            </ul>
		</li>
		</c:forEach>
		</c:if>
        </ul>
    </li> 
    </c:forEach>
</ul>
<hr>

 <!-- Trigger the modal with a button 
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
 -->
 
 <!-- signUpModel -->
  <div class="modal fade" id="signUpModel" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:10px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class=""></span> Sign Up</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action="./signUp" name="signUpForm" id="signUpForm" method="POST">
            <div class="form-group">
              <label for="userEmail"><span class=""></span> Enter Email Id :</label>
              <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="userPassword"><span class=""></span> Password : </label>
              <input type="text" class="form-control" id="userPassword" name="userPassword" placeholder="Enter password">
            </div>
            <div class="form-group">
              <label for="confirmPassword"><span class=""></span>Confirm Password : </label>
              <input type="text" class="form-control" id="confirmPassword" placeholder="ReEnter password">
            </div>
            <div class="">
              <button type="submit" class="btn btn-success signUp"><span class=""></span> Submit</button>
              <button type="submit" class="btn btn-danger btn-default pull-right " data-dismiss="modal"><span class=""></span> Cancel</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Login Model -->
  <div class="modal fade" id="loginModel" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:10px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class=""></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="usrname"><span class=""></span> Enter Email</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw"><span class=""></span>Enter Password</label>
              <input type="text" class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="">
              <button type="submit" class="btn btn-success "><span class=""></span> Login</button>
              <button type="submit" class="btn btn-danger btn-default pull-right " data-dismiss="modal"><span class=""></span> Cancel</button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <p class="pull-left">Not a member? <a href="#">Sign Up</a></p>
          Forgot <a href="#">Password?</a>
        </div>
      </div>
    </div>
  </div>

</body>
</html>
