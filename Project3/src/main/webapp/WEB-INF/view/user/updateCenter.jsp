<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 문의 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
	#container { width: 700px; margin: auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	.center { text-align: center; }
	
	.border-none, .border-none td { border: none; }
</style>
<script>
	//내용이 비어있으면 alert를 띄우는 함수
	function go_nullCheck() {
		var titleN = $("#center_qna_title").val().trim();
		var contentN = $("#center_qna_content").val().trim();
		if (titleN == "") {
			alert("제목을 입력하세요.");
			document.insertCenterQna.center_qna_title.focus();
		} else {
			if (contentN == "") {
				alert("내용을 입력하세요.");
				document.insertCenterQna.center_qna_content.focus();
			} else {
				$("#center_qna_id").submit();
			}
		}
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="../common/header.jsp"></jsp:include>
	</header>
<div id="container">
	
	<form action="updateCenterQnaWrite.do" method="post" id="center_qna_id">
	<input type="hidden" id="center_qna_id" name="center_qna_id" value="${getCenter.CENTER_QNA_ID }" >
	<table class="table table-hover">
		<tr>
			<th class="center">문의제목</th>
			<td>
				<input type="text" name="center_qna_title" value="${getCenter.CENTER_QNA_TITLE }" id="center_qna_title">
			</td>
		</tr>
		<tr>
			<th class="center">문의내용</th>
			<td>
				<textarea name="center_qna_content" rows="10" cols="40" id="center_qna_content">${getCenter.CENTER_QNA_CONTENT }</textarea>
			</td>
		</tr>
	</table>
	
	<br>
	<p>
		<button type="button" class="btn btn-outline-secondary btn-sm" onclick="go_nullCheck()">문의 수정</button>
		<button type="reset" class="btn btn-outline-secondary btn-sm">초기화</button>
	</p>
	</form>
</div>	
	<!-- footer -->
	<footer>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</footer>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>






