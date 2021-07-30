<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<style>
    h1 {text-align: center;}
</style>

<body>
<h1> Table of Employees </h1>
<div class="container">
    <div class="center">
        <table border="3" bgcolor="#f0f8ff" style="text-align: center">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Salary</th>
                <th>Created</th>
                <th>Updated</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <#list employees as employee>
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.description}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.createdAt}</td>
                    <td>${employee.updatedAt}</td>
                    <td> <a href="/gui/employee/update/${employee.id}" > <input type="button" class="btn btn-secondary" value="Edit"> </a> </td>
                    <td> <a href="/gui/employee/delete/${employee.id}" > <input type="button" class="btn btn-danger" value="Delete"> </a> </td>
                </tr>
            </#list>
        </table>
    </div>
</div>

<p style="text-align: center;">
<td> <a href="/gui/employee/create" > <input type="button" class="btn btn-warning" value="Create"> </a>
</p>

</body>
</html>