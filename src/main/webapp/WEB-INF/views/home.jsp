<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC test</title>
</head>
<div id="header">
  <h2>FreeMarker Spring MVC Hello World</h2>
</div>
<div id="content">
  <br/>
  <table class="datatable">
    <tr>
      <th>Make</th>
      <th>Model</th>
    </tr>
    <#list carList as car>
      <tr>
        <td>${car.make}</td>
        <td>${car.model}</td>
      </tr>
    </#list>
  </table>
</div>
</html>