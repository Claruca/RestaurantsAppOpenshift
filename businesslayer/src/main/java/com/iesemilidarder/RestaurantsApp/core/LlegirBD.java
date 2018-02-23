
package com.iesemilidarder.RestaurantsApp.core;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LlegirBD {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String THIN_URL = "jdbc:oracle:thin:@35.205.41.45:1521:XE";
    private static final String USER = "usuari ";
    private static final String PASSWORD = "usuari";

    private Object searchDB(String query, Function<ResultSet, Object> f) {
        Connection con;
        Statement stmt;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Object o = f.apply(rs);
            stmt.close();
            con.close();
            return o;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Restaurant> mostrarRes(String consulta) {

        //VERSION GENERICS
        List<Restaurant> ar = new ArrayList<>();
        try {
            String query;
            if (StringUtils.isEmpty(consulta)) {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI AND ROWNUM <=5 ORDER BY RES_MITJANA DESC ";

            } else {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI WHERE lower(res.RES_NOM) LIKE '%" + consulta.toLowerCase() + "%'";

            }

            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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

        } catch (Exception e) {
            System.out.println((e.toString()));
        }
        return ar;
    }


//Mostra més info del restaurant

    public Restaurant mostrarResInfo(String id) {
        Restaurant res = null;
        ArrayList<Opinions> opi = new ArrayList<>();

        try {
            String query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI LEFT JOIN opinions opi ON opi.OPI_RES_CODI = res.RES_CODI WHERE RES_CODI ='" + id + "'";
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (res == null) {
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

                }
                Opinions opinio = new Opinions();
                opinio.setOpicodi(rs.getString("OPI_CODI"));
                opinio.setObservacio(rs.getString("OPI_OBSERVACIO"));
                opinio.setPuntuacio(rs.getString("OPI_PUNTUACIO"));
                opinio.setOpirevisada(rs.getString("OPI_OPINIO_REVISADA"));

                opi.add(opinio);
            }


            res.setOpinions(opi);


            stmt.close();
            con.close();


        } catch (Exception e)

        {
            System.out.println((e.toString()));

        }
        return res;

    }

    //Mètode per afegir comentaris si l'usuari està loggejat

    public static void add_comment(String usuari, String comment, String score, String id) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
            String query = "INSERT INTO OPINIONS(OPI_RES_CODI,OPI_OBSERVACIO,OPI_PUNTUACIO,OPI_USU_CODI) VALUES ('" + id + "','" + comment + "'," + score + ",'" + usuari + "' )WHERE RES_CODI='" + id + "'";

            stmt.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println("error comentari");
        }
    }

    //Mètode per mostrar els restaurants per la api-rest

    public List getRestaurants(boolean search) {

        List<Restaurant> arrayRes = new ArrayList<>();
        ResultSetMapper<Restaurant> mapper = new ResultSetMapper<>();
        try {
            final String query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                    "RESTAURANTS R,TRESTAURANTS TR WHERE  R.RES_TRS_CODI = TR.TRS_CODI";
            if (search) {
                //VERSION GENERICS
                Class.forName(DRIVER);
                Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                arrayRes = mapper.mapResultSetToObject(rs, Restaurant.class);
                stmt.close();
                con.close();

            } else {

                //VERSION FUNCTIONAL
                arrayRes = new ArrayList<>();
                Function<ResultSet, Object> func = rs -> mapper.mapResultSetToObject(rs, Restaurant.class); //Lo he sustituido por lambdas

                arrayRes = (ArrayList) searchDB(query, func);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRes;
    }

}