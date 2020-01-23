<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
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
    <title>Werknemers</title>
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
    <!-- Image and text -->

    <div class="page">
     

      <div class="header py-4">
        <div class="container">
          <div class="d-flex">
            <a class="header-brand" href="/">
              <img src="./assets/images/logo.svg" class="header-brand-img" alt="TVH logo">
            </a>
            <div class="d-flex order-lg-2 ml-auto">
              <div class="nav-item d-none d-md-flex">
                <a href="https://github.com/sanderdms/java-interview" class="btn btn-sm btn-outline-primary" target="_blank">Source code</a>
              </div>
              </div>
            </div>
          </div>
        </div>
   


      <div class="flex-fill">
        <div class="my-3 my-md-5">
          <div class="container">
        
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header py-4">
                    <h3 class="card-title">Werknemers</h3>
                    <div class="card-options">
                      <a href="new" class="btn btn-primary btn"><i class="fe fe-plus"></i> Toevoegen</a>
                    </div>
                  </div>
                
                  <div class="table-responsive">
                    <table class="table card-table table-vcenter text-nowrap">
                      <thead>
                        <tr>
                          <th class="w-1">Id.</th>
                          <th>Beschikbaarheid</th>
                          <th>Voornaam</th>
                          <th>Naam</th>
                          <th>Email</th>
                          <th>Rijbewijs</th>
                          <th>Woonplaats</th>
                          <th>Afdeling</th>
                          <th> </th>
                          <th> </th>

                       
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${list}" var="employer">
                      
                        <tr>
                          <td><span class="text-muted">00${employer.id }</span></td>
                          <td><span class="status-icon ${employer.availability == 1 ? "bg-success" : "bg-warning"}"></span> ${employer.availability == 1 ? "Beschikbaar" : "Onbeschikbaar"}
                          </td>
                          <td>${employer.fname }</td>
                          <td>
                            ${employer.name }
                          </td>
                          <td>
                            ${employer.email }
                          </td>
                          <td>
                          ${fn:join(employer.license, ',')}
                      
                          </td>
                          <td>
                           ${employer.city }
                          </td>
                          <td>${employer.department }</td>
                          <td class="text-right">
                            <a href="edit?id=${employer.id}" class="btn btn-secondary btn-sm">wijzigen</a>
                          </td>
                          <td>
                            <a class="icon" href="delete?id=${employer.id}">
                              <i class="fe fe-trash"></i>
                            </a>
                          </td>
                        </tr>
</c:forEach>
                        
                        
                      </tbody>
                    </table>
                    <script>
                      require(['datatables', 'jquery'], function(datatable, $) {
                      	    $('.datatable').DataTable();
                      	  });
                    </script>
                   
                  </div>
                </div>
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