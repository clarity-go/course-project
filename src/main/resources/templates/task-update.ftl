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
        <legend>Update Task</legend>
        <form name="item" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text"/>
            <br>
            TaskType:<@spring.formInput "form.taskType" "" "text"/>
            <br>
            StartDate:<@spring.formInput "form.startDate" "" "number"/>
            <br>
            FinishDate:<@spring.formInput "form.finishDate" "" "number"/>
            <br>
            NumberOfEmployees:<@spring.formInput "form.numberOfEmployees" "" "number"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>