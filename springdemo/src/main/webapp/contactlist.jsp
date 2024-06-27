<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Contact" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact List</title>
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
            text-align: center;
            margin-bottom: 20px;
        }
        form input[type="text"] {
            padding: 5px;
            margin-right: 10px;
            width: 200px;
        }
        form input[type="submit"] {
            padding: 5px 10px;
            background-color: #007bff;
            border: none;
            color: white;
            cursor: pointer;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .actions a {
            margin: 0 5px;
        }
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Contact List</h1>
    
    <form action="search" method="get">
        <label for="name">Search by Name:</label>
        <input type="text" id="name" name="name">
        <input type="submit" value="Search">
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Actions</th>
        </tr>
        <% 
            List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
            if (contacts != null) {
                for (Contact contact : contacts) {
        %>
            <tr>
                <td><%= contact.getId() %></td>
                <td><%= contact.getName() %></td>
                <td><%= contact.getPhoneNumber() %></td>
                <td class="actions">
                    <a href="edit-contact?id=<%= contact.getId() %>">Edit</a>
                    <a href="delete-contact?id=<%= contact.getId() %>">Delete</a>
                </td>
            </tr>
        <% 
                }
            } 
        %>
    </table>

    <div class="center">
        <% 
            Boolean isSearch = (Boolean) request.getAttribute("isSearch");
            if (isSearch != null && isSearch) {
        %>
            <a href="contacts">Back to Contact List</a>
        <% } %>
        <a href="add-contact">Add New Contact</a>
    </div>
</body>
</html>
