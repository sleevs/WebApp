<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.unicarioca.aps.webapp.model.QuestionarioModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<body>

<!-- Side Navigation -->
<nav class="w3-sidebar w3-bar-block w3-card w3-animate-left w3-center" style="display:none" id="mySidebar">
  <h1 class="w3-xxxlarge w3-text-theme">Side Navigation</h1>
  <button class="w3-bar-item w3-button" onclick="w3_close()">Close <i class="fa fa-remove"></i></button>
  <a href="#" class="w3-bar-item w3-button">Questionário</a>

</nav>

<!-- Header -->
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i> 
  <div class="w3-center">
  <h4>UNICARIOCA</h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">Atividade Supervisionada</h1>
    <div class="w3-padding-32">
  
    </div>
  </div>
</header>


<jsp:useBean id="obj" class="br.com.unicarioca.aps.webapp.controle.ProfessorControleBean"/>

<%-- 
	<%
		ProfessorModel p = new ProfessorModel();

		List<Anuncio> m = obj.analisarRespostas(id);
		request.setAttribute("myJSPBean", m);
	%> --%>
<div>


 <h2>MEUS QUESTIONÁRIOS </h2>

<br>
<hr>
 <form action="InserirQuestionario" method="get">
  <input type="text" name="id_professor" placeholder="Informe o Id Do(a) Professor(a)" ><br>
   <input type="submit" value="BUSCAR" /><br/>
 <%

 //String ID = request.getParameter("id_professor");
 //List<QuestionarioModel> q = obj.analisarRespostas(Integer.valueOf(ID));

 String resultado = (String) session.getAttribute("MEUS_QUESTIONARIOS");
 out.println(resultado);
 %>
</form>

</div>

 <h2>INSERIR QUESTIONÁRIO </h2>
 
<br>
<hr>
 <form action="InserirQuestionario" method="post">
  <input type="text" name="id_professor" placeholder="Informe o Id Do(a) Professor(a)" ><br>
   <input type="submit" value="REGISTRAR" /><br/>
   

   
</form>

<%-- <c:forEach items="${MEUS_QUESTIONARIOS}" var="a">
    <c:out value="${a}"/><br />
  </c:forEach>
 --%>


<div>
 <h2>INSERIR PERGUNTA</h2>
 
<br>
<hr>
 <form action="PerguntaControle" method="post">
  <input type="text" name="pergunta_descricao" placeholder="Descreva  a perguunta" ><br>
   <input type="text" name="id_questionario" placeholder="Informe o id do questionário" ><br>
 
   <input type="submit" value="REGISTRAR PERGUNTA" /><br/>
</form>
</div>


<div>
 <h2>INSERIR FEEDBACK</h2>
 
<br>
<hr>
 <form action="FeedbeckControle" method="post">
  <input type="text" name="id_professor" placeholder="Informe o Id Do(a) Professor(a)" ><br>
  <input type="text" name="id_resposta" placeholder="Informe o Id Da Resposta" ><br>
  <input type="text" name="fb_descricao" placeholder="Descreva  a perguunta" ><br>
 
    <input type="submit" value="REGISTRAR FEEDBACK" /><br/>
 
</form>
</div>

<!-- Modal -->
<div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-top">
      <header class="w3-container w3-theme-l1"> 
        <span onclick="document.getElementById('id01').style.display='none'"
        class="w3-button w3-display-topright">×</span>
        <h4>Oh snap! We just showed you a modal..</h4>
        <h5>Because we can <i class="fa fa-smile-o"></i></h5>
      </header>
      <div class="w3-padding">
        <p>Cool huh? Ok, enough teasing around..</p>
        <p>Go to our <a class="w3-btn" href="/w3css/default.asp">W3.CSS Tutorial</a> to learn more!</p>
      </div>
      <footer class="w3-container w3-theme-l1">
        <p>Modal footer</p>
      </footer>
    </div>
</div>




<hr>

<hr>


<hr>

<br>

<!-- Footer -->
<footer class="w3-container w3-theme-dark w3-padding-16">
  <h3>UNICARIOCA</h3>
  <p>Desenvolvido por <a target="_blank">Jeison Muniz</a></p>
  <div style="position:relative;bottom:55px;" class="w3-tooltip w3-right">
   
  </div>

</footer>

<!-- Script for Sidebar, Tabs, Accordions, Progress bars and slideshows -->
<script>
// Side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "100%";
  x.style.fontSize = "40px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Tabs
function openCity(evt, cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  var activebtn = document.getElementsByClassName("testbtn");
  for (i = 0; i < x.length; i++) {
    activebtn[i].className = activebtn[i].className.replace(" w3-dark-grey", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-dark-grey";
}

var mybtn = document.getElementsByClassName("testbtn")[0];
mybtn.click();

// Accordions
function myAccFunc(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

// Slideshows
var slideIndex = 1;

function plusDivs(n) {
  slideIndex = slideIndex + n;
  showDivs(slideIndex);
}

function showDivs(n) {
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

showDivs(1);

// Progress Bars
function move() {
  var elem = document.getElementById("myBar");   
  var width = 5;
  var id = setInterval(frame, 10);
  function frame() {
    if (width == 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
      elem.innerHTML = width * 1  + '%';
    }
  }
}
</script>

</body>
</html>
