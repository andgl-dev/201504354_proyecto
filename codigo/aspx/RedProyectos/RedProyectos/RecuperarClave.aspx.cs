﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RedProyectos
{
    public partial class RecuperarClave : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BEnviar_Click(object sender, EventArgs e)
        {
            Response.Write("<script>window.alert('Aqui esta su clave'); </script>");
        }
    }
}