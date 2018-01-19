package com.iesemilidarder.restaurants.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


//En aquesta classe definim la connexió a la BD

public class LlegirBD {

    public ArrayList MostrarRes(String consulta) {
        //Creació d'una array list
        ArrayList ar = new ArrayList();

        //Intentam la connexió i sinó gestionam els errors
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();

            //Si el paràmetre consulta de la ArrayList MostrarRes ens dona null, executarà la consulta sql establerta. Per poder fer una cerca al formulari, transformam els valors en minúscula
            ResultSet rs;
            if (consulta == null) {
                rs = stmt.executeQuery("SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI AND ROWNUM <=5 ORDER BY RES_MITJANA DESC ");
            } else {
                rs = stmt.executeQuery("SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI WHERE lower(res.RES_NOM) LIKE '%" + consulta.toLowerCase() + "%'");

            }

            //Amb aquest loop mostrarem tots els paràmetres de les taules fins que no n'hi hagi
            while (rs.next()) {
                Restaurant res = new Restaurant();
                res.setCodi(rs.getString("RES_CODI"));
                res.setNom(rs.getString("RES_NOM"));
                res.setAdressa(rs.getString("RES_ADRECA"));
                res.setLlocweb(rs.getString("RES_WEB"));
                res.setTelefon(rs.getString("RES_TELEFON"));
                res.setTipus(rs.getString("TRS_DESCRIPCIO"));
                res.setImatge(rs.getString("RES_URL_IMG"));
                res.setMitjana(rs.getString("RES_MITJANA"));


                ar.add(res);
            }


            stmt.close(); //tancam connexions
            con.close();


        } catch (
                Exception e)

        {
            System.out.println((e.toString()));

        }
        return ar;

    }


    public Restaurant MostrarResInfo(String id) {
        Restaurant res = null;
        ArrayList<Opinions> opi = new ArrayList<Opinions>();

        //Intentam la connexió i sinó gestionam els errors
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();

            ResultSet rs;
            /*final String myQuery = String.format("SELECT * FROM restaurants res " +
                    "JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI " +
                    "LEFT JOIN opinions opi ON opi.OPI_RES_CODI = res.RES_CODI WHERE RES_CODI = %i",id);
           */

            rs = stmt.executeQuery("SELECT * FROM restaurants res " +
                    "JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI " +
                    "LEFT JOIN opinions opi ON opi.OPI_RES_CODI = res.RES_CODI WHERE RES_CODI = " + id);

            //Amb aquest loop mostrarem tots els paràmetres de les taules fins que no n'hi hagi
            while (rs.next()) {
//                if (res == null) {
                res = new Restaurant();
                res.setCodi(rs.getString("RES_CODI"));
                res.setNom(rs.getString("RES_NOM"));
                res.setAdressa(rs.getString("RES_ADRECA"));
                res.setLlocweb(rs.getString("RES_WEB"));
                res.setTelefon(rs.getString("RES_TELEFON"));
                res.setTipus(rs.getString("TRS_DESCRIPCIO"));
                res.setImatge(rs.getString("RES_URL_IMG"));
                res.setMitjana(rs.getString("RES_MITJANA"));
                res.setLatitud(rs.getString("RES_LATITUD"));
                res.setLongitud(rs.getString("RES_LONGITUD"));

//                }

                Opinions opinio = new Opinions();
                opinio.setOpicodi(rs.getString("OPI_CODI"));
                opinio.setObservacio(rs.getString("OPI_OBSERVACIO"));
                opinio.setPuntuacio(rs.getString("OPI_PUNTUACIO"));
                opinio.setOpirevisada(rs.getString("OPI_OPINIO_REVISADA"));

                opi.add(opinio);
            }

            res.setOpinions(opi);


            stmt.close(); //tancam connexions
            con.close();


        } catch (Exception e)

        {
            System.out.println((e.toString()));

        }
        return res;

    }


}