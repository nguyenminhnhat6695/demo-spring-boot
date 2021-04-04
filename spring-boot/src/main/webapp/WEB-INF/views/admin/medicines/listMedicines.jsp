<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="deleteAPI" value="/admin/medicine-delete"/>
<c:url var="listAPI" value="/admin/medicine-list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thuốc</title>
</head>
<body>
<div class="main-content">
	
	<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Tables</a>
							</li>
							<li class="active">Simple &amp; Dynamic</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." onkeyup="myFunction()" 
									class="nav-search-input" id="nav-search-input" autocomplete="off">
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>
					<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
					</c:if>
					<!-- Button add new -->
					<div align="right">
						<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
							class="btn btn-sm btn-danger"
							data-toggle="tooltip" title='Delete medicines'>
							<span> <i class="ace-icon fa fa-trash-o  bigger-100 icon-on-right"></i>  Delete Medicines
							</span>
						</button>
						<c:url var="addNewMedicines" value="/admin/medicine-edit" />
						<a type="button" class="btn btn-sm btn-primary" href="${addNewMedicines}">
							<i class="ace-icon glyphicon glyphicon-plus align-top bigger-100 icon-on-right"></i>  Add new Medicine
						</a>
					</div>
					<!-- End Button add new -->
					<!-- Table -->
					<form action="${listAPI}" id="formSubmit" method="get">
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12">
										<div align="right">
											<input type="text" placeholder="Search ..." name="medicine_name" value="${medicinesDTO.name_search}">
											<a href="javascript:document.getElementById('formSubmit').submit();">
												<i class="ace-icon fa fa-search nav-search-icon"></i>
											</a>
										</div>
										<br/>
										<c:if test="${empty medicinesDTO.listResult}">
											<b>Don't exists medicines !!!</b>
										</c:if>
										<c:if test="${not empty medicinesDTO.listResult}">
										<table id="simple-table" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">
														<label class="pos-rel">
															<input type="checkbox" id="checkAll" class="ace">
															<span class="lbl"></span>
														</label>
													</th>
													<th>Name</th>
													<th>Cost / unit</th>
													<th>Company Name</th>
													<th>Category Medicine Name</th>
													<th>Action</th>
												</tr>
											</thead>

											<tbody id="myTable">
												<c:forEach var="item" items="${medicinesDTO.listResult}">
												<tr>
													<td class="center">
														<label class="pos-rel">
															<input type="checkbox" id="checkbox_${item.id}" value="${item.id}" class="ace">
															<span class="lbl"></span>
														</label>
													</td>
													<td>
														<a href="#Modal${item.id}" data-toggle="modal">${item.name}</a>
													</td>
													<td>${item.cost} / ${item.unit}</td>
													<td>${item.company_description}</td>
													<td>${item.category_medicine_description}</td>
													<td>
														<c:url var="updateMedicine" value="/admin/medicine-edit">
															<c:param name="id" value="${item.id}"/>															
														</c:url>
														<div class="hidden-sm hidden-xs btn-group">
															<a class="btn btn-xs btn-info" href="${updateMedicine}">
																<i class="ace-icon fa fa-pencil bigger-120"></i>
															</a>
														</div>
													</td>
												</tr>
												<!-- Modal -->
													<div id="Modal${item.id}" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
														<div class="modal-dialog modal-lg">
															<!-- Modal content-->
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal">&times;</button>
																	<h4 class="modal-title">
																		Detail medicine: <b>${item.name}</b>
																	</h4>
																</div>
																<div class="modal-body">
																	<div class="widget-main">
																		<dl id="dt-list-1" class="dl-horizontal">
																			<dt>Thành phần :</dt><dd>${item.composition}</dd>
																			<dt>Hạn sử dụng: </dt><dd>${item.manufactureOfDate} - ${item.expiryDate}</dd>
																			<dt>Số lô :</dt><dd>${item.lotNumber}</dd>
																			<dt>Mô tả thêm :</dt><dd>${item.description}</dd>
																		</dl>
																	</div>
															</div>
																<div class="modal-footer" style="background-color:#ffffff;">
																	<button type="button" class="btn btn-warning btn-sm"
																		data-dismiss="modal">Close</button>
																</div>
															</div>

														</div>
													</div>
													<!--End Modal -->
												</c:forEach>
											</tbody>
										</table>
										<div align="center">
											<ul class="pagination" id="pagination"></ul>	
										</div>
										</c:if>
											<input type="hidden" id="page" name="page" value="${medicinesDTO.page}"/>
											<input type="hidden" value="" id="limit" name="limit"/>
									</div><!-- /.span -->
								</div><!-- /.row -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					</form>
					<!--End Table -->
				</div>
	</div>
	<script>
			var totalPages = ${medicinesDTO.totalPage};
			var currentPage = ${medicinesDTO.page};
			$(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPages,
		            visiblePages: 10,
		            startPage: currentPage,
		            onPageClick: function (event, page) {
		            	if (currentPage != page) {
		            		$('#limit').val(${medicinesDTO.limit});
							$('#page').val(page);
							$('#formSubmit').submit();
						}
		            }
		        });
		    });
		    
			function warningBeforeDelete() { 
			var n = $( "input:checked" ).length;
			if (n > 0) {
 			 swal({
				  title: 'Are you sure?',
				  text: 'Bạn có chắc chắn muốn xóa hay không !!!',
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonClass: "btn-success",
				  cancelButtonClass: "btn-danger",
				  confirmButtonText: "Xác nhận",
				  cancelButtonText: "Hủy bỏ"
			    }).then(function(result){
			        if(result.value){
			        	var ids = $('tbody input[type=checkbox]:checked').map(function () {
				            return $(this).val();
				        }).get();
						deleteNew(ids);
			        }else if(result.dismiss == 'cancel'){
			        	window.location.href = "${listAPI}?page=${medicinesDTO.page}";
			        }

			    });
			}
		}

		function deleteNew(data) {
	        $.ajax({
	            url: '${deleteAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${listAPI}?page=1&message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${listAPI}?page=1&message=error_system";
	            }
	        });
	    }

		// Listen for click on toggle checkbox
		$('#checkAll').click(function(event) {   
			if(this.checked) {
				// Iterate each checkbox
				$(':checkbox').each(function() {
					this.checked = true;                        
				});
			} else {
				$(':checkbox').each(function() {
					this.checked = false;                       
				});
			}
		});

/* 		$('a[href$="#Modal"]').on( "click", function() {
			   $('#Modal').modal('show');
			}); */
	</script>
	<script>
	$(document).ready(function(){
	  $("#nav-search-input").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	</script>
</body>
</html>