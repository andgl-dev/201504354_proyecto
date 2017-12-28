<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="RedProyectos.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            color: #FFFFFF;
        }
        .auto-style2 {
            text-align: justify;
        }
    </style>
</head>
<body style="background-color: #FF0000" >
    
    <form id="form1" runat="server" >
        <div>
            <h1 class="auto-style2" style="margin-left: 280px">
                <asp:Label ID="Label1" runat="server" ForeColor="White" style="font-weight: 700; text-decoration: underline" Text="Red de Proyectos 2.0"></asp:Label>
            </h1>
        </div>
        <p class="auto-style2">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </p>
        <div class="auto-style2" style="margin-left: 280px">
            <asp:Label ID="Label2" runat="server" ForeColor="White" Text="Usuario"></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="TUserName" runat="server" OnTextChanged="TUserName_TextChanged" Width="214px"></asp:TextBox>
        </div>
        <p class="auto-style2" style="margin-left: 280px">
            <span class="auto-style1">Clave </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="TClave" runat="server" OnTextChanged="TClave_TextChanged" TextMode="Password" Width="214px"></asp:TextBox>
        </p>
        <p class="auto-style2" style="color: #FFFFFF; margin-left: 280px">
            Tipo Usuario&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:DropDownList ID="DTipo" runat="server">
                <asp:ListItem>comun</asp:ListItem>
                <asp:ListItem>Administrador</asp:ListItem>
            </asp:DropDownList>
        </p>
        <p class="auto-style2" style="color: #FFFFFF; margin-left: 280px">
            &nbsp;</p>
        <p class="auto-style2" style="color: #FFFFFF; margin-left: 280px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="BEntrar" runat="server" Text="Entrar" BackColor="White" OnClick="BEntrar_Click" />
        </p>
        <p class="auto-style2" style="color: #FFFFFF; margin-left: 280px">
            &nbsp;</p>
        <p class="auto-style2" style="color: #FFFFFF; margin-left: 2px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:HyperLink ID="HLClave" runat="server" ForeColor="Blue" NavigateUrl="~/RecuperarClave.aspx">Olvido su Clave?</asp:HyperLink>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:HyperLink ID="HLRegistrarse" runat="server" ForeColor="Blue" NavigateUrl="~/Registro.aspx">Registrarme !</asp:HyperLink>
        </p>
        <p style="color: #FFFFFF; margin-left: 2px">
            <asp:Label ID="LError" runat="server"></asp:Label>
        </p>
        <p style="color: #FFFFFF; margin-left: 280px">
            &nbsp;</p>
        <p style="color: #FFFFFF; margin-left: 280px">
            &nbsp;</p>
        <p style="color: #FFFFFF; margin-left: 280px">
            &nbsp;</p>
    </form>
</body>
</html>
