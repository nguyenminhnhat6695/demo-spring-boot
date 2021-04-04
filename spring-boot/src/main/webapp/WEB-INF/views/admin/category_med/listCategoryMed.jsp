<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="categoryMedEidt" value="/admin/categoryMed-edit" />
<c:url var="categoryMedList" value="/admin/categoryMed-list" />
<c:url var="categoryMedDel" value="/admin/categoryMed-delete"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<!-- Button add new -->
			<div align="right">
				<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
					class="btn btn-sm btn-danger" data-toggle="tooltip"
					title='Delete medicines'>
					<span> <i
						class="ace-icon fa fa-trash-o  bigger-100 icon-on-right"></i>
						Delete Medicines
					</span>
				</button>
				<a type="button" class="btn btn-sm btn-primary"
					href="${categoryMedEidt}"> <i
					class="ace-icon glyphicon glyphicon-plus align-top bigger-100 icon-on-right"></i>
					Thêm mới
				</a>
			</div>
			<!-- End Button add new -->
			<div class="page-content">
				 <table class="table">
				    <thead>
				      <tr>
						<th class="center">
							<label class="pos-rel"> 
							<input type="checkbox" id="checkAll" class="ace"> 
							<span class="lbl"></span>
							</label>
						</th>
						<th>Tên Loại thuốc</th>
				        <th>Định danh</th>
				        <th>Thao tác</th>
				      </tr>
				    </thead>
				    <tbody>
				    <c:forEach var="itemCtgMed" items="${ctgMedList.listResult}">
					      <tr>
							<td class="center">
								<label class="pos-rel"> <input
										type="checkbox" id="checkbox_${itemCtgMed.id}" value="${itemCtgMed.id}"
										class="ace"> <span class="lbl"></span>
								</label>
							</td>
							<td>${itemCtgMed.description}</td>
					        <td>${itemCtgMed.name}</td>
					         <td>
					         		<c:url var="updateCategoryMed" value="/admin/categoryMed-edit">
										<c:param name="id" value="${itemCtgMed.id}" />
									</c:url>
									<div class="hidden-sm hidden-xs btn-group">
									<a class="btn btn-xs btn-info" href="${updateCategoryMed}"> <i
											class="ace-icon fa fa-pencil bigger-120"></i>
									</a>
								</div>
							</td>
					      </tr>
				      </c:forEach>
				    </tbody>
				  </table>
			  </div>
		</div>
	</div>
	<script type="text/javascript">
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
			        	window.location.href = "${categoryMedList}";
			        }
	
			    });
			}
		}

		function deleteNew(data) {
	        $.ajax({
	            url: '${categoryMedDel}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${categoryMedList}?message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${categoryMedList}?message=error_system";
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
	</script>
</body>
</html>