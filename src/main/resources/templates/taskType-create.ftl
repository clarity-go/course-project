<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Task Type</title>
</head>
<body>

<h1>  Creation </h1>

<div>
    <fieldset>
        <legend>Add Task Type</legend>
        <form name="taskType" action="" method="POST">
            Type:<@spring.formInput "form.type" "" "text"/>
            <br>
            DailyPayment:<@spring.formInput "form.dailyPayment" "" "number"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>


