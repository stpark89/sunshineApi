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
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <p>관리자 페이지</p>
            <input class="form-control" type="file" id="excelFileUpload">
            <input class="btn btn-info" type="button" id="btnFileUpload" value="파일업로드">
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
                    });
            });
        });

</script>

</body>
</html>