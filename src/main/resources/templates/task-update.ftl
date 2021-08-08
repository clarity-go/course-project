<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
</head>
<body>

<h1>  Updating </h1>

<div>
    <fieldset>
        <legend>Update Task</legend>
        <form name="task" action="" method="POST">
            <@spring.formInput "form.id" "" "hidden"/>
            Employees: <@spring.formMultiSelect "form.employees" allEmployees ""/>
            <br>
            Task type: <@spring.formSingleSelect "form.taskType" allTaskTypes ""/>
            <br>
            StartDate:<@spring.formInput "form.startDate" "" "date"/>
            <br>
            FinishDate:<@spring.formInput "form.finishDate" "" "date"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>