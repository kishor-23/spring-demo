<!DOCTYPE html>
<html>
<head>
    <title>Add Contact</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        form label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        form input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        form input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            border: none;
            color: white;
            cursor: pointer;
            border-radius: 4px;
        }
        form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .center {
            text-align: center;
            margin-top: 20px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h1>Add Contact</h1>
    <form action="save-contact" method="post">
        <label for="name">Name:</label>
       <input type="text"  name="name" required pattern="[ A-Za-z]+" title="Please enter a valid name (letters only)"/>
        <br><br>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required pattern="[1-9][0-9]{9}" title="Please enter a valid 10-digit phone number without leading zeros"/>
        <input type="submit" value="Save">
    </form>
    <div class="center">
        <a href="contacts">Back to Contact List</a>
    </div>
</body>
</html>
