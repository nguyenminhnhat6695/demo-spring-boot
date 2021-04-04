<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="listCtgMed" value="/admin/categoryMed-list"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text">Managerment</span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>  
            <ul class="submenu">
            	<li>
                    <a href="<c:url value='#' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Pharmacy
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/admin/medicine-list?page=1' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Medicines
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='${listCtgMed}' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Category Medicine
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='#' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Company
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='#' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Stocks
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='#' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Inventory
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='#' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Inventory
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
    <script>
	    $(document).ready(function() {
	    	  $('.dropdown-toggle').click(function() {
	    	    $(this).siblings(".submenu").toggle();
	    	  });
	    	});
    </script>
</div>