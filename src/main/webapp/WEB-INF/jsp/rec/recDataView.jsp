<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/js/jquery.form.min.js"></script>
    <style>
        body {
            font: 400 15px Lato, sans-serif;
            line-height: 1.8;
            color: #818181;
        }
        h2 {
            font-size: 24px;
            text-transform: uppercase;
            color: #303030;
            font-weight: 600;
            margin-bottom: 30px;
        }
        h4 {
            font-size: 19px;
            line-height: 1.375em;
            color: #303030;
            font-weight: 400;
            margin-bottom: 30px;
        }
        .jumbotron {
            background-color: #f4511e;
            color: #fff;
            padding: 100px 25px;
            font-family: Montserrat, sans-serif;
        }
        .container-fluid {
            padding: 60px 50px;
        }
        .bg-grey {
            background-color: #f6f6f6;
        }
        .logo-small {
            color: #f4511e;
            font-size: 50px;
        }
        .logo {
            color: #f4511e;
            font-size: 200px;
        }
    </style>
</head>
<body>

<div class="container-fluid" style="padding:0">
    <div class="row">
        <div class="col-sm-12">
            <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                <!-- Brand -->
                <a class="navbar-brand" href="#">관리자 페이지</a>

                <!-- Toggler/collapsibe Button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
        </div>
    </div>
</div>
<!-- Container (Services Section) -->
<div class="container-fluid text-center">
    <div class="row">
        <div class="col-sm-3">
            <div class="card bg-light text-dark">
                <div class="card-body">
                    <p>Rec 정보 파일 업로드</p>
                    <hr/>
                    <input class="form-control" type="file" id="excelFileUpload">
                    <input class="btn btn-info mt-2" type="button" id="btnFileUpload" value="파일업로드">
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <p>데이터 조회. </p>
        </div>
    </div>
</div>

    <script>
        $(document).ready(function(){
            $('#btnFileUpload').on("click", function(){
                // 원하는 것만 넘겨주는 방식
                var formData = new FormData();
                formData.append("file", $("#excelFileUpload")[0].files[0]);
                $.ajax(
                    {
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/adminData/recExcelUpload',
                        processData: false, // 필수
                        contentType: false, // 필수
                        data: formData,
                        success: function(data) {

                            alert('성공');
                            console.log(data);
                        }
                    }
                );
            });
        });
    </script>

</body>