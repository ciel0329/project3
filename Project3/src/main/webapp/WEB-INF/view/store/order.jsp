<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<!-- Bootstrap core CSS -->
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.1/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

label {
	display: inline-block;
	width: 120px;
}

input {
	width: 800px;
	padding: 10px 20px;
	margin: 10px 0;
	box-sizing: border-box;
	border: none;
	color: #0A6EFF;
}

#body-content {
	background-color: #F3F3F3;
	margin-top: 100px;
	padding-bottom: 170px; /* footer의 높이 */
	padding-left: 300px;
	padding-right: 300px;
}
</style>


<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
<title>결제정보 입력</title>
<!-- css 스크립트 삽입 -->
<link href="common/styles.css" rel="stylesheet">
<!-- kakao -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>

<body>
	<!-- header -->
	<header>
		<jsp:include page="../common/header.jsp"></jsp:include>
	</header>
	<div class="container">
		<%-- <h1>map</h1>
		${map }
		<h2>${map.coupon}</h2>
		${user }
		<hr> --%>
		<!--Content-->
		<div id="body-wrapper">
			<div id="body-content" class="container">
				<br /></br>
					<br />
					<div class="container-fluid text-center" style="margin-top: 10pt">
						<h1>주문 정보 입력</h1>
						<img src="../img/fast.png" class="img-title" alt="no title"
							width="200" />
					</div>
					<br> <br>
					<hr>
					<h4>[ 배송지 정보 ]</h4><br>
					
					<script type="text/javascript">
					function clearInput(){

						/* 텍스트박스 지우는 부분 */
						var el = document.getElementsByClassName('input-text');
						for(var i=0; i<el.length; i++){	el[i].value = '';}

						/* 체크(라디오)박스 지우는 부분 */
						var el = document.getElementsByClassName('input-radio');
						for(var i=0; i<el.length; i++){	el[i].checked = false;}

						}
					</script>
					<form action="order.do" method="post">
					<button class = "erase" onclick="clearInput()"> 직접 입력하기</button>
					<button type='reset' >내 정보 다시 가져오기</button>
					<br><br>
					<div class="col-md-3">
						<div class="col-md-3">
							<label for="username" class="form-label">수령인</label>
							<div class="input-group has-validation">
								<input type="text" class= "input-text" name="order_receiver" maxlength="20"
									placeholder="수령인 이름" value="${user.user_name}" required><br />
								<input type="hidden" id="order_total" name="order_total"
									value="${map.allSum}">
							</div>
							<div class="invalid-feedback">필수입력 항목입니다.</div>
						</div>

						<div class="col-md-3">
							<label for="username" class="form-label"> 수령인 연락처 </label>
							<div class="input-group has-validation">
								<input type="text" name="order_phone" class= "input-text"value="${user.user_phone}"
									placeholder="핸드폰번호 입력" oninput="orderPhone(this)"
									maxlength="13" required /><br />
							</div>
							<div class="invalid-feedback">필수입력 항목입니다.</div>
						</div>

						<div class="col-md-3">
							<label for="username" class="form-label">우편번호 </label>
							<div class="input-group has-validation">
								<input id="member_post" maxlength="20" class= "input-text" name="order_zipcode" value="${user.user_zipcode}"
									type="text" placeholder="우편번호 찾기" readonly onclick="findAddr()"
									required> <br>
							</div>
							<div class="invalid-feedback">필수입력 항목입니다.</div>
						</div>

						<div class="col-md-3">
							<label for="username" class="form-label"> 도로명 주소 </label>
							<div class="input-group has-validation">
								<input id="member_addr" class= "input-text" maxlength="20" name="order_addr"
									type="text" value="${user.user_addr}" placeholder="도로명주소" readonly>
							</div>
							<div class="invalid-feedback">필수입력 항목입니다.</div>
						</div>
					</div>
					<div class="col-md-3">
						<br> <label for="username" class="form-label"> 상세 주소</label>
						<div class="input-group has-validation">
							<input type="text" class= "input-text" name="order_addr_d" maxlength="50"
								placeholder="상품을 수령받을 상세 주소 입력" value="${user.user_addr_d}" required><br />
						</div>
						<div class="invalid-feedback">필수입력 항목입니다.</div>
					</div>
					<%-- <hr>
					<h4>[ 쿠폰 ]</h4>
					<br>
					<div class="input-group mb-3">
						<div class="input-group-text">
							<input class="form-check-input mt-0" type="checkbox"
								name="coupon" value="${map.coupon}">
						</div>
						<input type="text" class="form-control"
							value="[웰컴 쿠폰] 첫 구매 10% 할인받기! " readonly="readonly">
					</div> --%>

					<br> <br> <input type="submit"
						class="w-100 btn btn-primary btn-lg" value="결제 하러가기 ">

				</form>

			</div>

		</div>
	</div>



	<div class="last_block"></div>
</body>

<!-- footer -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<div class="last_block"></div>
<script>
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {

				console.log(data);

				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var jibunAddr = data.jibunAddress; // 지번 주소 변수
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}
		}).open();
	}

	const orderPhone = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		}
</script>
</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>