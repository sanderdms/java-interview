<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="nl">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Language" content="en" />
    <meta name="msapplication-TileColor" content="#2d89ef">
    <meta name="theme-color" content="#4188c9">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" type="image/x-icon" href="./favicon.ico" />
    <!-- Generated: 2019-04-04 16:55:45 +0200 -->
    <title>tabler.github.io - a responsive, flat and full featured admin template</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <script src="./assets/js/require.min.js"></script>
    <script>
      requirejs.config({
          baseUrl: '.'
      });
    </script>
    <!-- Dashboard Core -->
    <link href="./assets/css/dashboard.css" rel="stylesheet" />
    <script src="./assets/js/dashboard.js"></script>
    <!-- c3.js Charts Plugin -->
    <link href="./assets/plugins/charts-c3/plugin.css" rel="stylesheet" />
    <script src="./assets/plugins/charts-c3/plugin.js"></script>
    <!-- Google Maps Plugin -->
    <link href="./assets/plugins/maps-google/plugin.css" rel="stylesheet" />
    <script src="./assets/plugins/maps-google/plugin.js"></script>
    <!-- Input Mask Plugin -->
    <script src="./assets/plugins/input-mask/plugin.js"></script>
    <!-- Datatables Plugin -->
    <script src="./assets/plugins/datatables/plugin.js"></script>
  </head>
  <body class="">
    <div class="page">
      <div class="flex-fill">
        
       
        <div class="my-3 my-md-5">
          <div class="container">
        
            <div class="row">
              <div class="col-12">
				<form:form action="save" method="post" modelAttribute="employer" class="card">
				<form:hidden path="id"/>
                  <div class="card-header py-5">
                    <h3 class="card-title">Werknemer wijzigen (${employer.fname})</h3>
                    <div class="card-options">
                      <label class="custom-switch m-0">
                        <form:checkbox path="availability" value="1"  class="custom-switch-input"/>
                        <span class="custom-switch-indicator"></span>
                        <span class="custom-switch-description">Beschikbaar</span>
                      </label>
                    </div>
                   
                  </div>
                  <div class="card-alert alert alert-danger mb-0 d-none">
                    Adding action failed
                  </div>
                  <div class="card-body">
                    <div class="row">
                      
                      <div class="col-sm-12 col-md-6">
                        <div class="form-group">
                        <c:set var="errorFname">
							<form:errors path="fname"/>
						</c:set>
						<c:set var="errorFnameClass">
							<c:out value="${empty errorFname ? '' : 'is-invalid'}" />
						</c:set>					    
                          <label class="form-label">Voornaam</label>
                          <form:input path="fname" type="text" class="form-control ${errorFnameClass}" placeholder="Voornaam"/>
                         <div class="invalid-feedback">${errorFname}</div>
                         
                         
                       </div>
                      </div>
                      <div class="col-sm-12 col-md-6">
                        <div class="form-group">
                        <c:set var="errorName">
							<form:errors path="name"/>
						</c:set>
						<c:set var="errorNameClass">
							<c:out value="${empty errorName ? '' : 'is-invalid'}" />
						</c:set>
							
                          <label class="form-label">Naam</label>
                          <form:input path="name" type="text" class="form-control ${errorNameClass}" placeholder="Familienaam" />
                                                   <div class="invalid-feedback">${errorName}</div>
                          
                        </div>
                      </div>
                      <div class="col-sm-12 col-md-12">
                        <div class="form-group">
                        <c:set var="errorEmail">
							<form:errors path="email"/>
						</c:set>
						<c:set var="errorEmailClass">
							<c:out value="${empty errorEmail ? '' : 'is-invalid'}" />
						</c:set>
                          <label class="form-label">E-Mail</label>
                          <form:input path="email" type="email" class="form-control ${errorEmailClass}" placeholder="naam@privoder.be" value=""/>
                          <div class="invalid-feedback">${errorEmail}</div>
                        </div>
                      </div>
                      
                    
                      <div class="col-sm-6 col-md-4">
                        <div class="form-group">
                         <c:set var="errorCity">
							<form:errors path="city"/>
						</c:set>
						<c:set var="errorCityClass">
							<c:out value="${empty errorCity ? '' : 'is-invalid'}" />
						</c:set>
                          <label class="form-label">Woonplaats</label>
                          <form:input path="city" type="text" class="form-control ${errorCityClass}" placeholder="Waregem" value=""/>
                          <div class="invalid-feedback">${errorCity}</div>
                          
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-3">
                       <div class="form-group">
                        <label class="form-label">Rijbewijs</label>
                        <div class="selectgroup w-100">
                          <label class="p-2">
                            <form:checkbox path="license"  value="A" class=""/>
                            <span class="">A</span>
                          </label>
                           <label class="p-2">
                            <form:checkbox path="license"  value="B" class=""/>
                            <span class="">B</span>
                          </label>
                           <label class="p-2">
                            <form:checkbox path="license"  value="C" class=""/>
                            <span class="">C</span>
                          </label>
                           <label class="p-2">
                            <form:checkbox path="license"  value="D" class=""/>
                            <span class="">D</span>
                          </label>
                           <label class="p-2">
                            <form:checkbox path="license"  value="E" class=""/>
                            <span class="">E</span>
                          </label>
                         
                      
                        </div>
                      </div>
                      </div>
                      <div class="col-md-5">
                        <div class="form-group">
                          <label class="form-label">Afdeling</label>
                          <form:select path="department" class="form-control custom-select">
                            <form:option value="Production" />
                            <form:option value="Marketing"/>
                            <form:option value="R&D"/>
                            <form:option value="HR"/>
                            <form:option value="Support"/>
                            <form:option value="IT" />
                          </form:select>
                        </div>
                      </div>
                     
                    </div>
                  </div>
                  <div class="card-footer text-right">
                  
                    <a href="./" class="btn btn-secondary mr-2"> Annuleren</a>
                    <button type="submit" class="btn btn-primary">Bewaren</button>

                  </div>
                </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
     
      <footer class="footer d-none">
        <div class="container">
          <div class="row align-items-center flex-row-reverse">
            <div class="col-auto ml-lg-auto">
              <div class="row align-items-center">
                
                <div class="col-auto">
                  <a href="https://github.com/tabler/tabler" class="btn btn-outline-primary btn-sm">Source code</a>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-auto mt-3 mt-lg-0 text-center">
              Gemaakt door @sanderdms ter kennismaking met Spring framework in Java
            </div>
          </div>
        </div>
      </footer>
    </div>
  </body>
</html>