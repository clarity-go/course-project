<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1> Table of employees </h1>

<div>
    <table border="3" bgcolor="#f0f8ff" style="text-align: center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
        </tr>

        <#list employees as employee>
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.description}</td>
                <td>${employee.createdAt}</td>
                <td>${employee.updatedAt}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>