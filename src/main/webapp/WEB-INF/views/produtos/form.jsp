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
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto">
		<div>
			<label>Titulo</label> <input type="text" name="titulo">
			<form:errors path="titulo"></form:errors>
		</div>

		<div>
			<label>Descricao</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
			<form:errors path="descricao"></form:errors>
		</div>

		<div>
			<label>P&aacute;ginas</label> <input type="text" name="paginas">
			<form:errors path="paginas"></form:errors>
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor">
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco }">
			</div>
		</c:forEach>

		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>