<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>

<h1>  Updating </h1>

<div>
    <fieldset>
        <legend>Update Employee</legend>
        <form name="employee" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text"/>
            <br>
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Task:<@spring.formInput "form.task" "" "text"/>
            <br>
            salary:<@spring.formInput "form.salary" "" "number"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>