<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/admin/medicine-list" />
<c:url var="editURL" value="/admin/medicine-update" />
<c:url var="addNewAdd" value="/admin/medicine-new" />
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
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Tables</a></li>
					<li class="active">Simple &amp; Dynamic</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off"> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form:form class="form-horizontal" enctype="multipart/form-data" role="form" id="formSubmitModal" modelAttribute="medicinesDTO">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1">Name</label>
								<div class="col-sm-6">
									<form:input path="name" id="form-field-1"
										cssClass="col-xs-10 col-sm-12" placeholder="Tên thuốc" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2">Cost</label>
								<div class="col-sm-6">
									<form:input path="cost" id="form-field-2"
										cssClass="col-xs-10 col-sm-12" placeholder="Giá" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-3">Unit</label>
								<div class="col-sm-6">
									<form:input path="unit" id="form-field-3"
										cssClass="col-xs-10 col-sm-12" placeholder="Đơn vị" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-4">Lot number</label>
								<div class="col-sm-6">
									<form:input path="lotNumber" id="form-field-4"
										cssClass="col-xs-10 col-sm-12" placeholder="Mã số lô" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-5">Composition</label>
								<div class="col-sm-6">
									<form:textarea path="composition" rows="4" cols="8"
										cssClass="form-control" id="form-field-5"
										placeholder="Thành phần" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-6">Description</label>
								<div class="col-sm-6">
									<form:textarea path="description" rows="4" cols="8"
										cssClass="form-control" id="form-field-6" placeholder="Mô tả" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="id-date-picker-1">Manufacture Of Date</label>
								<div class="col-sm-4">
									<div class="input-group date" data-provide="datepicker">
										<input class="form-control date-picker" id="id-date-picker-1"
											name="manufactureOfDate" type="text"
											data-date-format="dd/mm/yyyy"
											value="${medicinesDTO.manufactureOfDate}"> <span
											class="input-group-addon"> <i
											class="fa fa-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="id-date-picker-2">Expiry date</label>
								<div class="col-sm-4">
									<div class="input-group date" data-provide="datepicker">
										<input class="form-control date-picker" id="id-date-picker-2"
											name="expiryDate" type="text" data-date-format="dd/mm/yyyy"
											value="${medicinesDTO.expiryDate}">
										<span class="input-group-addon"> <i
											class="fa fa-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="id-input-file-1">Image</label>
								<div class="col-sm-4">
									<input type="file" name="files" id="files" value="${medicinesDTO.files}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-select-1">Company name</label>
								<div class="col-sm-4">
									<form:select path="company_name" cssClass="form-control"
										id="form-field-select-1">
										<form:option value="" label="-- Chọn công ty --" />
										<form:options items="${companyList}" />
									</form:select>
								</div>
							</div>	
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-select-2">Category name</label>
								<div class="col-sm-4">
									<form:select path="category_medicine_name"
										cssClass="form-control" id="form-field-select-2">
										<form:option value="" label="-- Chọn loại thuốc --" />
										<form:options items="${categoryMedicineList}" />
									</form:select>
								</div>
							</div>
							<form:hidden path="id" id="medicineId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<a type="button" class="btn btn-sm btn-secondary" href="${newURL}?page=1">Back</a>
									<c:if test="${not empty medicinesDTO.id}">
										<button type="button" id="btnAddOrUpdateNew"class="btn btn-sm btn-primary">Update changes</button>
									</c:if>
									<c:if test="${empty medicinesDTO.id}">
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
	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
 			var data = {};
			var formData = $('#formSubmitModal').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

 			// Get form
/* 		    var form = $('#formSubmitModal')[0];

		    var formData = new FormData(form); */
			
			var id = $('#medicineId').val();
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
					url : '${addNewAdd}',
					dataType: 'json',
					type : 'POST',
					success : function(result) {
						window.location.href = "${newURL}?page=1&message=insert_success";
					},
					error : function(error) {
						window.location.href = "${newURL}?page=1&message=error_system";
					}
				});
		}

 		function updateNew(formData) {
			$.ajax({
					processData: false,
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(formData),
					url : '${editURL}',
					type : 'PUT',
					dataType: 'json',
					success : function(result) {
						window.location.href = "${newURL}?page=1&message=update_success";
					},
					error : function(error) {
						window.location.href = "${newURL}?page=1&message=error_system";
					}
					});
		} 
	</script>
</body>
</html>