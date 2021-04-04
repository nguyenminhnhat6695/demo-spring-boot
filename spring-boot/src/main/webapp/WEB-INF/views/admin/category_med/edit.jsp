<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="listCtgMed" value="/admin/categoryMed-list"/>
<c:url var="addNewCtgMed" value="/admin/categoryMed-new"/>
<c:url var="modifyCtgMed" value="/admin/categoryMed-update"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="row">
						 <form:form class="form-horizontal" enctype="multipart/form-data" role="form" id="formSubmitModal" modelAttribute="categoryMedicineDTO">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1">Tên Loại thuốc</label>
								<div class="col-sm-6">
									<form:input path="description" id="form-field-1"
										cssClass="col-xs-10 col-sm-12" placeholder="Tên Loại thuốc" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1">Định danh</label>
								<div class="col-sm-6">
									<form:input path="name" id="form-field-1"
										cssClass="col-xs-10 col-sm-12" placeholder="Định danh" />
								</div>
							</div>
							<form:hidden path="id" id="categoryMedicineId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<a type="button" class="btn btn-sm btn-secondary" href="${listCtgMed}">Back</a>
									<c:if test="${not empty categoryMedicineDTO.id}">
										<button type="button" id="btnAddOrUpdateNew"class="btn btn-sm btn-primary">Update changes</button>
									</c:if>
									<c:if test="${empty categoryMedicineDTO.id}">
									<button type="button" id="btnAddOrUpdateNew"class="btn btn-sm btn-primary">Add New</button>
									</c:if>
								</div>
							</div>
						</form:form> 
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$('#btnAddOrUpdateNew').click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmitModal').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});

		var id = $('#categoryMedicineId').val();
		if (id == "") {
			addNew(data);
		} else {
			updateNew(data);
		}
	});

	function addNew(formData) {
		$.ajax({
				processData: false,
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(formData),
				url : '${addNewCtgMed}',
				dataType: 'json',
				type : 'POST',
				success : function(result) {
					window.location.href = "${listCtgMed}?message=insert_success";
				},
				error : function(error) {
					window.location.href = "${listCtgMed}?message=error_system";
				}
				});
			}

		function updateNew(formData) {
		$.ajax({
				processData: false,
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(formData),
				url : '${modifyCtgMed}',
				type : 'PUT',
				dataType: 'json',
				success : function(result) {
					window.location.href = "${listCtgMed}?message=update_success";
				},
				error : function(error) {
					window.location.href = "${listCtgMed}?message=error_system";
				}
				});
			} 
	</script>
	
	
</body>
</html>