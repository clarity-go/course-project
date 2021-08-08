<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Task Type</title>
</head>
<body>

<h1>  Updating </h1>

<div>
    <fieldset>
        <legend>Update Task Type</legend>
        <form name="taskType" action="" method="POST">
            id:<@spring.formInput "form.id" "" "hidden"/>
            Type:<@spring.formInput "form.type" "" "text"/>
            <br>
            DailyPayment:<@spring.formInput "form.dailyPayment" "" "number"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>