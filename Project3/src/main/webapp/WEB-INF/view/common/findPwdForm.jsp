<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<!-- 헤더 관련 링크는 아래 4개 -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
   crossorigin="anonymous">

<link rel="canonical"
   href="https://getbootstrap.kr/docs/5.1/examples/album/">
<!-- Bootstrap core CSS -->
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet"
   integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
   crossorigin="anonymous">
<link href="common/styles.css" rel="stylesheet">
<!-- 여기까지 헤더링크 -->

<style>
.form-control{
   margin: auto;
}

.container{
   text-align: center;
    margin:0 auto;
}
.text-center{
   text-align: center;
}

</style>
</head>
<body>
   <!-- header -->
   <header>
      <jsp:include page="../common/header.jsp"></jsp:include>
   </header>
   <script type="text/javascript">
</script>

   <div class="container">
         <a href="#"><img src="./img/비밀번호찾기.png" alt="비밀번호찾기로고" width="450"></a>
         <div class="h5"><strong>암호를 모르시나요?</strong></div>
         <p><small>아이디와 메일을 입력해주세요!</small></p>
      <div class="card border-success mb-3" style="max-width: 30rem; max-width: 600px; margin-left: 350px;">
        <div class="card-header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
        <div class="text-center">
        <form class="user" action="findPwdAction.do" method="POST">
           <fieldset>
                <div class="form-group">
                  <label for="exampleInputEmail1" class="form-label mt-4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">아이디</font></font></label>
                  <input type="text" class="form-control form-control-user" id="user_id" name="user_id" aria-describedby="emailHelp" placeholder="아이디를 입력해주세요." style="width: 500px">
                  <label for="exampleInputEmail1" class="form-label mt-4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">이메일 주소</font></font></label>
                  <input type="email" class="form-control form-control-user" id="user_email" name="user_email" aria-describedby="emailHelp" placeholder="이메일 주소 전체를 입력해주세요." style="width: 500px">
                  <small id="emailHelp" class="form-text text-muted"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">귀하의 이메일을 다른 사람과 공유하지 않습니다.</font></font></small>
                </div>
         </fieldset>
        <hr>
           <input type="submit" class="btn btn-outline-success"
            value="비밀번호 찾기">
        </form>
        </div>
        </font></font></div>
      </div>
      <p>아이디가 기억나지 않는다면? <a href="findIdView.do" class="text-success">아이디 찾기 바로가기</a></p>
      </div>
   
   
   
   <!-- footer -->
   <footer>
      <jsp:include page="../common/footer.jsp"></jsp:include>
   </footer>
</body>
</html>