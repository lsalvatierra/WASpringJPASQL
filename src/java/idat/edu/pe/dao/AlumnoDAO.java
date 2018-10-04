/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.dao;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.idao.IAlumnoDAO;
import idat.edu.pe.model.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LuisAngel
 */
public class AlumnoDAO implements IAlumnoDAO {

    @Override
    public List<Alumno> ListarAlumnos() {
        List<Alumno> lista = new LinkedList<>();
        
        BDConnection objCon = new BDConnection();            
        Connection con = objCon.EstablecerConexion();
        try{
            //CallableStatement cstmt = con.prepareCall("{call dbo.sp_ListarAlumno}");
            Statement cstmt = con.createStatement();
            ResultSet rs =cstmt.executeQuery("{call dbo.sp_ListarAlumno}");
            while (rs.next()) {
                Alumno objAlumno = new Alumno();
                objAlumno.setIdAlumno(rs.getString(1));
                objAlumno.setNomAlumno(rs.getString(2));
                objAlumno.setApeAlumno(rs.getString(3));
                objAlumno.setIdEspecialidad(rs.getString(4));
                objAlumno.setProcedencia(rs.getString(5));
                lista.add(objAlumno);
               //lista.add(new Alumno( rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
            }
            rs.close();
            cstmt.close();
            objCon.Desconectar();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lista;
        
    }
    
}
