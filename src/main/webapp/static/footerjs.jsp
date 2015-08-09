<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='${ctx}/static/assets/js/jquery-2.0.3.min.js'>"
							+ "<"+"/script>");
</script>

<!-- <![endif]-->


<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='${ctx}/static/assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
<script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="${ctx}/static/assets/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="${ctx}/static/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/static/assets/js/ace.min.js"></script>
