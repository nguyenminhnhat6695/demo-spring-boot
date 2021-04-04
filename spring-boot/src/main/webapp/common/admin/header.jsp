<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                 	<c:if test="${pageContext.request.userPrincipal.name != null}">
                 		<form id="logoutForm" method="POST" action="${contextPath}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						</form>
							<a data-toggle="dropdown" href="#" class="dropdown-toggle" aria-expanded="false">
								<img class="nav-user-photo" src="<c:url value='/template/admin/assets/avatars/avatar.png' />" alt="Jason's Photo">
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="${contextPath}/registration">
										<i class="ace-icon fa fa-user"></i>
										Create an account
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a onclick="document.forms['logoutForm'].submit()">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
					</c:if>
				</li>
            </ul>
        </div>
    </div>
</div>
