package com.sotre.repos;

import com.sotre.entities.*;
import com.store.managers.DBManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product_Country_Repo {

    public void insert(Product_Country productCountry) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO product_country (`PRODUCT_ID`,`PRODUCT_ID_FK`, `COUNTRY_NAME`, `PRODUCT_MODEL`, PRODUCT_COUNTRY_QTY) VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, productCountry.getProductId());
            stmt.setInt(2, productCountry.getProductIdFK());
            stmt.setString(3, productCountry.getCountryName());
            stmt.setInt(4, productCountry.getProductModel());
            stmt.setInt(5, productCountry.getProductCountryQty());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public Product_Country getProductCountryByFK(int productIdFk) {
        Product_Country productCountry = null;

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `PRODUCT_ID`, `PRODUCT_ID_FK`, `COUNTRY_NAME`, `PRODUCT_MODEL` , `PRODUCT_COUNTRY_QTY` FROM product_country Where PRODUCT_ID = ?");
            stmt.setInt(1, productIdFk);

            rs = stmt.executeQuery();

            if (rs.next()) {
                productCountry = new Product_Country();

                productCountry.setProductId(rs.getInt("PRODUCT_ID")); //
                productCountry.setProductIdFK(rs.getInt("PRODUCT_ID_FK")); //
                productCountry.setCountryName(rs.getString("COUNTRY_NAME"));
                productCountry.setProductModel(rs.getInt("PRODUCT_MODEL"));
                productCountry.setProductCountryQty(rs.getInt("PRODUCT_COUNTRY_QTY"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

            return productCountry;
        }

    }

    public void delete(int productIdFk) {

        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("DELETE FROM product_country Where PRODUCT_ID_FK = ? ");

            stmt.setInt(1, productIdFk);

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public void update(Product_Country Productcountry) {

        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE product_country SET COUNTRY_NAME = ? , PRODUCT_MODEL = ? , PRODUCT_COUNTRY_QTY = ? WHERE PRODUCT_ID_FK = ?");

            stmt.setString(1, Productcountry.getCountryName());
            stmt.setInt(2, Productcountry.getProductModel());
            stmt.setInt(3, Productcountry.getProductCountryQty());
            stmt.setInt(4, Productcountry.getProductIdFK());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public List<Product_Country> getAllProductCountry() {

        List<Product_Country> list = new ArrayList<Product_Country>();

        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            // JDBC
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `PRODUCT_ID`, `PRODUCT_ID_FK`, `COUNTRY_NAME`, `PRODUCT_MODEL` , `PRODUCT_COUNTRY_QTY` FROM product_country  ");
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                System.out.println("Product ID : " + rs.getInt("PRODUCT_ID") + " Product ID FK : " + rs.getInt("PRODUCT_ID_FK") + " Country Name : " + rs.getString("COUNTRY_NAME") + " Product Model : " + rs.getInt("PRODUCT_MODEL") + " Product Country QTY : " + rs.getInt("PRODUCT_COUNTRY_QTY"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }
        return list;

    }

}
