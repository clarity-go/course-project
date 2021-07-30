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
        <legend>Add Employee</legend>
        <form name="employee" action="" method="POST">
            DailyPayment:<@spring.formInput "form.dailyPayment" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>


