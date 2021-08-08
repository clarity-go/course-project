<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
</head>
<body>

<h1>  Creation </h1>

<div>
    <fieldset>
        <legend>Add Task</legend>
        <form name="task" action="" method="POST">
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
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>
</body>
</html>
