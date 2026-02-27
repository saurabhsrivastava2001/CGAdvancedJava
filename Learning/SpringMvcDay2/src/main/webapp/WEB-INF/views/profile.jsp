<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Profile</title>

<style>

body{
    font-family: Arial;
    background-color:#f4f6f8;
}

.container{
    width:600px;
    margin:40px auto;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h2{
    text-align:center;
    color:#2c3e50;
}

.section{
    margin-top:20px;
}

.label{
    font-weight:bold;
    color:#34495e;
}

.value{
    margin-left:10px;
}

hr{
    margin-top:15px;
}

</style>

</head>

<body>

<div class="container">

<h2>Employee Profile</h2>

<hr>

<div class="section">

<p><span class="label">First Name:</span>
<span class="value">${e.getFName()}</span></p>

<p><span class="label">Last Name:</span>
<span class="value">${e.getLName()}</span></p>

<p><span class="label">Manager:</span>
<span class="value">${e.getManager()}</span></p>

<p><span class="label">Date Of Joining:</span>
<span class="value">${e.getDoj()}</span></p>

<p><span class="label">Designation:</span>
<span class="value">${e.getDesignation()}</span></p>

<p><span class="label">Organization:</span>
<span class="value">${e.getOrganization()}</span></p>
</div>

<hr>

<h3>Address Details</h3>

<div class="section">

<p><span class="label">Street:</span>
<span class="value">${e.getAddress().getStreetName()}</span></p>

<p><span class="label">City:</span>
<span class="value">${e.getAddress().getCity()}</span></p>

<p><span class="label">Pincode:</span>
<span class="value">${e.getAddress().getPincode()}</span></p>

<p><span class="label">Country:</span>
<span class="value">${e.getAddress().getCountry()}</span></p>

</div>

</div>

</body>
</html>