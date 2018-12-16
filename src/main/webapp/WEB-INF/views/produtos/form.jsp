<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais -
	Casa do Código</title>
</head>
<body>
<!-- o metodo mvc URL configura a action automaticamente fazendo com que o spring preencha a URL -->
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Título</label>
			<form:input path="titulo" />
			<form:errors path="titulo"></form:errors>
		</div>

		<div>
			<label>Descricao</label>
			<form:textarea path="descricao" rows="10" cols="20"/>
			<form:errors path="descricao"></form:errors>
		</div>

		<div>
			<label>P&aacute;ginas</label>
			<form:input path="paginas"/>
			<form:errors path="paginas"></form:errors>
		</div>
		
		<div>
   		 <label>Data de Lançamento</label>
   		 	<form:input path="dataLancamento"/>
    			<form:errors path="dataLancamento" />
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index}].valor"/>
				<form:hidden path="precos[${status.index }].tipo" value="${tipoPreco }"/>
			</div>
		</c:forEach>
		<div>
			<label>Sumário</label>
			<input name="sumario" type="file">
		</div>

		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>