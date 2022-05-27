package com.example.paojdbc.repositories;

import com.example.paojdbc.models.Drink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DrinkRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void addDrink(Drink drink){
        String sql = "insert into food values(NULL,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, drink.getMName());
            statement.setInt(2, drink.getMPortions());
            statement.setInt(3, drink.getMPrice());
            statement.setInt(4, drink.getMMl());
            statement.setInt(5, drink.getMVenue());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteDrink(Drink drink){
        String sql = "delete from food where id=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, drink.getMId());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePrice(Drink drink, Integer price){
        String sql = "update food set price=? where id=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, price);
            statement.setInt(2, drink.getMId());
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
