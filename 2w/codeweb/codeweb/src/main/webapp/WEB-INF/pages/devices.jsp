<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Application</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>mdm-server</h1>
            <form:form method="get" action="download_profile">
                <button type="submit" class="btn btn-default">
                    Get proflile
                </button>
            </form:form>
            <form:form method="get" action="download_certificate">
                <button type="submit" class="btn btn-default">
                    Get certificate
                </button>
            </form:form>
            <form:form method="post" action="add" commandName="device" role="form">
                <table>
                    <tr>
                        <td>
                            <div >
                                <form:input path="name" class="form-control" placeholder="Name"/>
                            </div>
                        </td>
                        <td>
                            <form:input path="platform" class="form-control" placeholder="Platform"/>
                        </td>
                        <td>
                            <button type="submit" class = "btn btn-default">
                                Add Device
                            </button>
                        </td>
                    </tr>
                </table>
            </form:form>

            <c:if test="${!empty devices}">
                <h3>Devices</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Platform</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${devices}" var="device">
                            <tr>
                                <td>${device.id}</td>
                                <td>${device.name}</td>
                                <td>${device.platform}</td>
                                <td>
                                    <form:form action="delete/${device.id}" method="post"><input type="submit"
                                                                                               class="btn btn-danger btn-mini"
                                                                                               value="Delete"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>


    </body>
</html>