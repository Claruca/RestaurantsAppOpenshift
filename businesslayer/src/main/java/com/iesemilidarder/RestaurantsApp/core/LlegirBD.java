
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
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Restaurant> MostrarRes(String consulta) {

        //VERSION GENERICS
        List<Restaurant> ar = new ArrayList<>();
        try {
            String query = StringUtils.EMPTY;
            if (StringUtils.isEmpty(consulta)) {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI AND ROWNUM <=5 ORDER BY RES_MITJANA DESC ";

            } else {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI WHERE lower(res.RES_NOM) LIKE '%\" + consulta.toLowerCase() + \"%'";

            }
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMapper<Restaurant> mapper = new ResultSetMapper<>();
            ar = mapper.mapRersultSetToObject(rs, Restaurant.class);
            stmt.close();
            con.close();

//           VERSION FUNCTIONAL

          /*  ar = new ArrayList<>();
            Function<ResultSet, Object> func = new Function<ResultSet, Object>() {
                public Object apply(ResultSet rs) {
                    return mapper.mapRersultSetToObject(rs, Restaurant.class);
                }
            };
            ar = (ArrayList) searchDB(query, func);*/

        } catch (Exception e) {
            System.out.println((e.toString()));
        }
        return ar;
    }

//Un altre mètode per treure més informació de la BD a través d'un string anomenat id

    public Restaurant MostrarResInfo(String id) {
        Restaurant res = null;
        //Cream l'arraylist d'opinions
        ArrayList<Opinions> opi = new ArrayList<Opinions>();

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

                //Ficam els camps dins l'array
                opi.add(opinio);
            }

            //Afegim al restaurant l'array creada amb els camps

            res.setOpinions(opi);


            stmt.close(); //tancam connexions
            con.close();


        } catch (Exception e)

        {
            System.out.println((e.toString()));

        }
        return res;

    }

    public static void add_comment(String usuari, String comment, String score, String id) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
            //            String query = "INSERT INTO OPINIONS(OPI_OBSERVACIO,OPI_PUNTUACIO) VALUES (" + comment + score + " )WHERE RES_CODI="+id;
//


            String query = "INSERT INTO OPINIONS(OPI_RES_CODI,OPI_OBSERVACIO,OPI_PUNTUACIO,OPI_USU_CODI) VALUES ('" + id + "','" + comment + "'," + score + ",'" + usuari + "' )WHERE RES_CODI='" + id + "'";
//            PreparedStatement pstmt = con.prepareStatement(query);

            stmt.executeUpdate(query);

//            ResultSet statquery = null;
//
//            pstmt.setString(1, id);
//            pstmt.executeUpdate(query);


        } catch (Exception ex) {
            System.out.println("error comentari");
        }
    }


}