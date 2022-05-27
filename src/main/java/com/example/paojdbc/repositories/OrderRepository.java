package com.example.paojdbc.repositories;

import com.example.paojdbc.models.Deliver;
import com.example.paojdbc.models.Order;
import com.example.paojdbc.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void placeOrder(Order order){
        String sql = "insert into order values(NULL,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, order.getMIdUser());
            statement.setInt(2, order.getMIdVenue());
            statement.setString(3, order.getMProducts());
            statement.setInt(4, order.getMIdDeliver());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cancelOrder(Order order){
        String sql = "delete from order where idorder=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, order.getMIdOrder());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateDeliver(Order order, Deliver deliver){
        String sql = "update order set iddeliver=? where idorder=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, deliver.getMId());
            statement.setInt(2, order.getMIdOrder());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Order> getOrdersByUser(User user){
        String sql = "select * from order where iduser=?";
        List<Order> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while(res.next()){
                Order order = new Order();

                order.setMIdOrder(res.getInt("idorder"));
                order.setMIdUser(res.getInt("iduser"));
                order.setMIdVenue(res.getInt("idvenue"));
                order.setMProducts(res.getString("products"));
                order.setMIdDeliver(res.getInt("iddeliver"));

                list.add(order);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}
