<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Tasks</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<style>
    h1 {text-align: center;}
</style>

<body>
<h1> Table of Tasks </h1>
<div class="container">
    <div class="center">
<#--        <table border="3" bgcolor="#f0f8ff" style="text-align: center">-->
        <table class="table table-dark">
            <tr>
                <th>ID</th>
                <th>Task Type</th>
                <th>Start Date</th>
                <th>Finish Date</th>
                <th>Number of Employees</th>
                <th>Description</th>
                <th>Created</th>
                <th>Updated</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <#list tasks as task>
                <tr>
                    <td>${task.id}</td>
                    <td>${task.taskType.type}</td>
                    <td>${task.startDate}</td>
                    <td>${task.finishDate}</td>
                    <td>${task.numberOfEmployees}</td>
                    <td>${task.description}</td>
                    <td>${task.createdAt}</td>
                    <td>${task.updatedAt}</td>
                    <td> <a href="/gui/task/update/${task.id}" > <input type="button" class="btn btn-secondary" value="Edit"> </a> </td>
                    <td> <a href="/gui/task/delete/${task.id}" > <input type="button" class="btn btn-danger" value="Delete"> </a> </td>
                </tr>
            </#list>
        </table>
    </div>
</div>

<p style="text-align: center;">
<td> <a href="/gui/task/create" > <input type="button" class="btn btn-warning" value="Create"> </a>
</p>

</body>
</html>