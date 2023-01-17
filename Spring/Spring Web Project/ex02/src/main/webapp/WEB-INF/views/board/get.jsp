<%--
  Created by IntelliJ IDEA.
  User: eunbin
  Date: 2023/01/11
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp"%>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Board Read Page
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label>Bno</label>
                            <input class="form-control" name="id" value=<c:out value="${board.id}" /> readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Title</label>
                            <input class="form-control" name="title" value=<c:out value="${board.title}"/> readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Content</label>
                            <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content}" /></textarea>
                        </div>
                        <div class="form-group">
                            <label>Writer</label>
                            <input class="form-control" name="writer" value=<c:out value="${board.writer}" /> readonly="readonly">
                        </div>
                        <button data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?id=<c:out value="${board.id}"/>'">Modify</button>
                        <button data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">List</button>

                        <form id="operForm" action="/board/modify" method="get">
                            <input type="hidden" id="id" name="id" value="<c:out value="${board.id}"/>">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ include file="../includes/footer.jsp"%>

<script type="text/javascript">
    $(document).ready(function () {

        var operForm = $('#operForm');

        $("button[data-oper='modify']").on("click", function (e) {
            operForm.attr("action", "/board/modify").submit();
        });

        $("button[data-oper='list']").on("click", function (e) {
            operForm.find("#id").remove();
            operForm.attr("action", "/board/list").submit();
        })

    });
</script>
