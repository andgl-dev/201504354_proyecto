using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RedProyectos
{
    public partial class Registro : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BEnviar_Click(object sender, EventArgs e)
        {
            if (TNombre.Text.Equals("") || TCorreo.Text.Equals("") || TClave.Text.Equals("") || TClave2.Text.Equals("") || TUsuario.Text.Equals(""))
            {
                
                Response.Write("<script>window.alert('Por favor llene todos los campos'); </script>");

            }
            else
            {
                if (TClave.Text.Equals(TClave2.Text))
                {

                    string fecha = Calendar1.SelectedDate.Year.ToString() + "/" + Calendar1.SelectedDate.Month.ToString() + "/" + Calendar1.SelectedDate.Day.ToString();

                    ServicioUsuario.UsuariosClient su = new ServicioUsuario.UsuariosClient();

                    if (su.Existente(TUsuario.Text).Equals("no"))
                    {
                        su.AgregarUsuario(TNombre.Text, TCorreo.Text, fecha, TUsuario.Text, TClave.Text, 0, "ordinario");

                    }
                    else
                    {
                        Response.Write("<script>window.alert('El usuario ya exite, proponga uno nuevo'); </script>");

                    }



                }
                else
                {
                    Response.Write("<script>window.alert('las contrasenias no coinciden'); </script>");
                    Response.Redirect("Login.aspx");
                }


            }
        }
    }
}