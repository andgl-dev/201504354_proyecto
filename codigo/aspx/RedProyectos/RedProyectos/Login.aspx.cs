using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RedProyectos
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void TUserName_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TClave_TextChanged(object sender, EventArgs e)
        {

        }

        protected void BEntrar_Click(object sender, EventArgs e)
        {
            ServicioUsuario.UsuariosClient su = new ServicioUsuario.UsuariosClient();


            String[] datos = su.getDatos(TUserName.Text);

            if (TClave.Text.Equals("") || TUserName.Text.Equals(""))
            {
                Response.Write("<script>window.alert('por favor llene todos los campos'); </script>");

            }
            else
            {
                if (datos[4].Equals(TUserName.Text))
                {
                    if (datos[5].Equals(TClave.Text))
                    {
                        if (datos[7].Equals(DTipo.Text))
                        {
                            Response.Write("<script>window.alert('todos los datos son correctos'); </script>");

                        }
                        else
                        {
                            Response.Write("<script>window.alert('el tipo seleccionado no corresponde al usaurio'); </script>");
                        }

                    }
                    else
                    {
                        Response.Write("<script>window.alert('contrasenia incorrecta'); </script>");

                    }

                }
                else
                {
                    Response.Write("<script>window.alert('el usuario no existe'); </script>");
                }

            }


        }
    }
}