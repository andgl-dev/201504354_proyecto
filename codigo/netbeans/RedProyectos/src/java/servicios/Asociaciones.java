/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import bdd.Asociacion;
import bdd.Mensaje;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Osman Lima
 */
@WebService(serviceName = "Asociaciones")
public class Asociaciones {

    /**
     * This is a sample web service operation
     */
       @WebMethod(operationName = "crearAsociacion")

public boolean crearAsociacion(@WebParam(name = "nombre") String nombre,@WebParam(name = "descripcion") String descripcion,@WebParam(name = "usuario") String usuario)
{

Asociacion as= new Asociacion();
        try 
        {
        return as.crearAsociacion(nombre, descripcion, usuario);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}
}
