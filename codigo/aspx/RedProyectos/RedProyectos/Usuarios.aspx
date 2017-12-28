<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Usuarios.aspx.cs" Inherits="RedProyectos.Usuarios" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #form1 {
            color: #FFFFFF;
        }
    </style>
</head>
<body style="background-color: #FF0000">
    <form id="form1" runat="server">
        <div>
            <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Red de Proyectos 2.0</h1>
        </div>
        <h2 style="color: #FFFFFF">Apartado de usuarios...</h2>
        <p style="color: #FFFFFF">
            Seleccione a alguien para seguirlo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:DropDownList ID="DLUsuarios" runat="server">
            </asp:DropDownList>
        </p>
        <p style="color: #FFFFFF">
            &nbsp;</p>
        <asp:Button ID="BSeguir" runat="server" Text="Seguir" Width="69px" />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        Seleccione a alguien para dejar de seguir<br />
        <br />
        <asp:DropDownList ID="DLUsuarios2" runat="server">
        </asp:DropDownList>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="BDejar" runat="server" Text="Dejar de seguir" />
    </form>
</body>
</html>
