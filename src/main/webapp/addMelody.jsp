
<%@ page import="model.Melody, repository.JpaMelodyRepository" %>


<%
  String name = request.getParameter("name");
  String email = request.getParameter("audioLink");

  Melody melody= new Melody(name, audioLink);

  JpaMelodyRepository melodyRepo = new JpaMelodyRepository();

  melodyRepo.addMelody(melody);

%>

  <meta http-equiv="Refresh" content="0; url='/world" />