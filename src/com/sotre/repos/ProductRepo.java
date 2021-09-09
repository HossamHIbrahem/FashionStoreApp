package com.sotre.repos;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
import com.sotre.entities.Product;
import com.store.managers.DBManager;
import java.sql.*;
import java.util.*;
import static java.util.Collections.list;

public class ProductRepo {

    public void insert(Product product) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO product (`PRODUCT_ID`, `PRODUCT_NAME`, `PRODUCT_PRICE`, `PRODUCT_QTY`) VALUES (?, ?, ?, ?)");

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getProductPrice());
            stmt.setInt(4, product.getProductQty());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public Product getProductByPK(int productId) {
        Product product = null;

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `PRODUCT_ID`, `PRODUCT_NAME`, `PRODUCT_PRICE`, `PRODUCT_QTY` FROM product Where PRODUCT_ID = ?");
            stmt.setInt(1, productId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQty(rs.getInt("PRODUCT_QTY"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

            return product;
        }

    }

    public void delete(int productId) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("DELETE FROM product Where PRODUCT_ID = ? ");

            stmt.setInt(1, productId);

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public void update(Product Product) {

        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE product SET PRODUCT_QTY = ? , PRODUCT_PRICE = ? , PRODUCT_NAME = ? WHERE PRODUCT_ID = ?");
            stmt.setInt(1, Product.getProductQty());
            stmt.setInt(2, Product.getProductPrice());
            stmt.setString(3, Product.getProductName());
            stmt.setInt(4, Product.getProductId());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<Product>();

        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            // JDBC
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `PRODUCT_ID`, `PRODUCT_NAME`, `PRODUCT_PRICE`, `PRODUCT_QTY` FROM product ");
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                System.out.println("Product Name : " + rs.getString("PRODUCT_NAME") + " Product ID : " + rs.getInt("PRODUCT_ID") + " Product Price : " + rs.getInt("PRODUCT_PRICE") + " Product QTY : " + rs.getInt("PRODUCT_QTY"));
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
