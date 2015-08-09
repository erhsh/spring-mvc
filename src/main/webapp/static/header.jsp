<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>${pageTile}</title>
<meta name="keywords" content="DMS" />
<meta name="description" content="Distributor management system" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->
<link href="${ctx}/static/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="${ctx}/static/assets/css/font-awesome.min.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${ctx }/static/assets/js/ace-extra.min.js"></script>
</head>
<body>