<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="JdbcSMelodyRepository" %>
<%@ page import="JpaMelodyRepository" %>
<%@ page import="Melody" %>

<html>

<head>
    <!-- This will make the table look nicer -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Very nice student list</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.21.4/dist/bootstrap-table.min.css">

  </head>
<body>




<h2>Melody List from the index.jsp file </h2>

    <table border="1" class="table table-striped table-hover w-50 p-3">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>AudioLink</th>

        </tr>
        <%

            JdbcMelodyRepository repository = new JdbcMelodyRepository();
            List<Melody> melodys = repository.getAllMelody();
            for (Melody melody : melodys) {
        %>
            <tr>
                <td><%= melody.getId() %></td>
                <td><%= melody.getName() %></td>
                <td><%= melody.getAudioLink() %></td>


            </tr>
        <% } %>
    </table>

<br/>
<br/>






</body>
</html>

