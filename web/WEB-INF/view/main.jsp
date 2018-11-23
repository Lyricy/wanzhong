<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/common/common.jsp"%>
<title>万众主页</title>
</head>
<
<style>
    .thumbnail:hover{
        background-color:grey
    }
    .dn{
        display:none;
    }
</style>
<body>
	<div class="container" style="width: auto;margin: 0px 20px;">
        <div class="row" style="">
            <div class="col-md-1 col-xs-1" style="">
                <div class="row pull-right"></div>
            </div>
            <div class="col-md-10 col-xs-10" style="">
                <div class="row">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid" style="">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">万众主页欢迎您！</a>
                            </div>
                            <div>
                                <ul class="nav navbar-nav">
                                    <li><a href="<%=path%>/mainkind/to_main.do">主页</a></li>
                                </ul>
                                <c:forEach items="${menuList}" var="menu">
                                    <c:if test="${menu.function_name eq '操作'}" var="flag">
                                        <ul class="nav navbar-nav pull-right">
                                            <li class="dropdown pull-right">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                    ${menu.function_name}
                                                    <b class="caret"></b>
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <c:forEach items="${menu.childrenList}" var="child">
                                                        <c:if test="${child.function_name eq '注销'}" var="childflag">
                                                            <li class="divider"></li>
                                                        </c:if>
                                                        <li><a href="<%=path%>${child.function_url}">${child.function_name}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </li>
                                        </ul>
                                    </c:if>
                                    <c:if test="${not flag}">
                                        <ul class="nav navbar-nav">
                                            <li class="dropdown pull-right">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        ${menu.function_name}
                                                    <b class="caret"></b>
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <c:forEach items="${menu.childrenList}" var="child">
                                                        <li><a href="<%=path%>${child.function_url}">${child.function_name}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </li>
                                        </ul>
                                    </c:if>
                                </c:forEach>
                                <%--<ul class="nav navbar-nav pull-right">
                                    &lt;%&ndash;导航栏菜单部分&ndash;%&gt;
                                    &lt;%&ndash;<li><a href="javascript:logout()" class="pull-right">注销</a></li>&ndash;%&gt;
                                    &lt;%&ndash;系统操作部分&ndash;%&gt;
                                    <li class="dropdown pull-right">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            操作
                                            <b class="caret"></b>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a href="<%=path%>/mainkind/personInfo.do">个人信息</a></li>
                                            <li><a href="<%=path%>/mainkind/to_manager.do">系统管理</a></li>
                                            <li class="divider"></li>
                                            <li><a href="<%=path%>/mainkind/loginout.do">注销</a></li>
                                            &lt;%&ndash;<li><a href="#">EJB</a></li>
                                            <li><a href="#">Jasper Report</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">分离的链接</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">另一个分离的链接</a></li>&ndash;%&gt;
                                        </ul>
                                    </li>
                                </ul>--%>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="col-md-1 col-xs-1" style="">
                <div class="row"></div>
            </div>
        </div>
        <div class="row">
			<div class="col-md-1 col-xs-1" style="">
				<div class="dn row" style="background-color: #5e5e5e;height:250px;margin-top: 300px;">
					广告区
				</div>
			</div>
			<div class="col-md-10 col-xs-10" style="">
				&nbsp;
				<div class="row">
					<div class="col-md-2 col-xs-2" style="">
						<div class="row">
                            <div class="list-group">
                                <a href="#" class="list-group-item active">
                                    <h4 class="list-group-item-heading">
                                        主页资讯
                                    </h4>
                                </a>
                                <a href="#" class="list-group-item">
                                    <h4 class="list-group-item-heading">
                                        万众之家
                                    </h4>
                                    <p class="list-group-item-text">
                                        万众家庭信息
                                    </p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <h4 class="list-group-item-heading">
                                        进德村
                                    </h4>
                                    <p class="list-group-item-text">
                                        福建省泉州市安溪县蓝田乡进德村
                                    </p>
                                </a>
                            </div>
                        </div>
					</div>
					<div class="col-md-8 col-xs-8" style="">
                        <div class="row" style="margin: 0px 2px 20px;height: 70%">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel" >
                                <!-- 轮播（Carousel）指标 -->
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                </ol>
                                <!-- 轮播（Carousel）项目 -->
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img src="<%=path%>/img/1.jpg" alt="First slide" class="img-responsive img-rounded">
                                    </div>
                                    <div class="item">
                                        <img src="<%=path%>/img/2.jpg" alt="Second slide" class="img-responsive img-rounded">
                                    </div>
                                    <div class="item">
                                        <img src="<%=path%>/img/3.jpg" alt="Third slide"  class="img-responsive img-rounded">
                                    </div>
                                </div>
                            </div>
                        </div>
						<div class="row">
							<div class="col-xs-6 col-md-3">
								<div class="thumbnail">
									<img src="<%=path%>/img/25.jpg"
										 alt="通用的占位符缩略图">
									<div class="caption">
										<p>一些示例文本。一些示例文本。</p>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-md-3">
								<div class="thumbnail">
									<img src="<%=path%>/img/25.jpg"
										 alt="通用的占位符缩略图">
									<div class="caption">
										<p>一些示例文本。一些示例文本。</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-2 col-xs-2" style="">
                        <div class="row">
                            <div class="list-group">
                                <a href="#" class="list-group-item active">
                                    <h4 class="list-group-item-heading">
                                        最新动态
                                    </h4>
                                </a>
                                <a href="#" class="list-group-item">
                                    <h4 class="list-group-item-heading">
                                        进德村入驻万众主页
                                    </h4>
                                    <p class="list-group-item-text">
                                        2018年11月23号
                                    </p>
                                </a>
                            </div>
                        </div>
					</div>
				</div>
			</div>
			<div class="col-md-1 col-xs-1" style="">
				<div class="dn row" style="background-color: #5e5e5e;height:250px;margin-top: 300px">
					广告区
				</div>
			</div>
		</div>
        <div class="row navbar-fixed-bottom">
            <div class="col-md-12 col-xs-12 center-block" style="text-align: center;color: grey">
                <%@include file="register.jsp"%>
            </div>
        </div>
	</div>
</body>
<script>

</script>
</html>