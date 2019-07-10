<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

    <head>
	<base href="<%=basePath%>">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

        <title>Bootstrap Modal Registration Form Template</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                        	<a class="logo" target="_self" href="index.jsp"></a>
                            <h1><strong>TEAM_10</strong> 注册澳猫团</h1>
                            <div class="description">
                            	<p>
	                            	这是一个免费的响应模式注册表与引导。你可以随意使用它!
                            	</p>
                            </div>
                            <div class="top-big-link">
                            	<a class="btn btn-link-1 launch-modal" target="_self" href="#" data-modal-id="modal-register">注册</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>

        <!-- MODAL -->
        <div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-register-label">立即注册</h3>
        				<p>请填写下面的表格以获得即时访问权限:</p>
        			</div>
        			
        			<div class="modal-body">
        				
        				
	                    <form name="forms" onsubmit="return check(this)" role="form" action="user/register" method="post" class="registration-form">
	                    	<div class="form-group">
	                    		
	                        	<input type="text" name="username" placeholder="Username..." class="form-first-name form-control" id="form-first-name">
	                        </div>
	                        <div class="form-group">
	                        	
	                        	<input type="text" name="nickname" placeholder="Nickname..." class="form-last-name form-control" id="form-last-name">
	                        </div>
	                        <div class="form-group">
	                        	
	                        	<input id="pwd" type="password" name="password" placeholder="Password..." class="form-email form-control" id="form-email">
	                        </div>
	                         <span class="box" id="btn"><a href="javascript:showPsw();">显示密码</a></span>
	                        <button type="submit" class="btn">Sign me up!</button>
	                        
	                        <script type="text/javascript">
	                        	function check(form) {
	                        		if(!form.username.value || !form.nickname || !form.password.value) {
	                        			alert("error");
	                        			return false;
	                        		}
	                        	}
	                        	 		var ele = {
	                        	            pwd : document.getElementById('pwd'),
	                        	            btn : document.getElementById('btn'),
	                        	            showP : '<a href="javascript:showPsw();">显示密码</a>',
	                        	            hideP : '<a href="javascript:hidePsw();">隐藏密码</a>'
	                        	        }
	                        	        function showPsw(){
	                        	            if(ele.pwd.type==='password'){
	                        	                ele.pwd.type = 'text';
	                        	                ele.btn.innerHTML = ele.hideP;
	                        	            }
	                        	        }
	                        	        function hidePsw(){
	                        	            if(ele.pwd.type==='text'){
	                        	                ele.pwd.type = 'password';
	                        	                ele.btn.innerHTML = ele.showP;
	                        	            }
	                        	        }
	                        	
	                        </script>
	                    </form>
	                    
        			</div>
        			
        		</div>
        	</div>
        </div>


        <!-- javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>