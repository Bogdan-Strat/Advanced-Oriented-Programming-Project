package com.example.paojdbc.repositories;

import com.example.paojdbc.models.Food;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class FoodRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void addFood(Food food){
        String sql = "insert into food values(NULL,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, food.getMName());
            statement.setInt(2, food.getMPortions());
            statement.setInt(3, food.getMPrice());
            statement.setInt(4, food.getMGrams());
            statement.setInt(5, food.getMVenue());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteFood(Food food){
        String sql = "delete from food where id=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, food.getMId());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePrice(Food food, Integer price){
        String sql = "update food set price=? where id=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, price);
            statement.setInt(2, food.getMId());
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
