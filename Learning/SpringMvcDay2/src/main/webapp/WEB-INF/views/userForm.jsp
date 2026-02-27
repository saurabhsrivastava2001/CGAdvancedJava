<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>

<style>

body{
    font-family: Arial;
    background:#f2f4f7;
}

.container{
    width:650px;
    margin:40px auto;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h1{
    text-align:center;
    color:#2c3e50;
}

.section{
    margin-top:20px;
}

label{
    font-weight:bold;
}

input{
    width:100%;
    padding:8px;
    margin-top:5px;
    margin-bottom:15px;
    border-radius:5px;
    border:1px solid #ccc;
}

button{
    width:100%;
    padding:12px;
    background:#2c3e50;
    color:white;
    border:none;
    border-radius:5px;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#34495e;
}

</style>

</head>

<body>

<div class="container">

<h1>Employee Registration Form</h1>

<form action="submitForm" method="post">

<div class="section">
<h3>Personal Details</h3>

<label>First Name</label>
<input type="text" name="first_name" required/>

<label>Last Name</label>
<input type="text" name="last_name" required/>

<label>Date Of Joining</label>
<input type="date" name="doj"/>

</div>

<div class="section">
<h3>Address Details</h3>

<label>Street Name</label>
<input type="text" name="street_name"/>

<label>City</label>
<input type="text" name="city"/>

<label>Pincode</label>
<input type="number" name="pincode"/>

<label>Country</label>
<input type="text" name="country"/>

</div>

<div class="section">
<h3>Work Details</h3>

<label>Designation</label>
<input type="text" name="designation"/>

<label>Organization</label>
<input type="text" name="org"/>

<label>Manager Name</label>
<input type="text" name="manager"/>

</div>

<button type="submit">Confirm Data</button>

</form>

</div>

</body>
</html>