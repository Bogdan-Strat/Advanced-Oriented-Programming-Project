package com.example.paojdbc.repositories;

import com.example.paojdbc.models.Drink;
import com.example.paojdbc.models.Food;
import com.example.paojdbc.models.Product;
import com.example.paojdbc.models.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VenueRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void addVenue(Venue venue){
        String sql = "insert into venue values(NULL,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, venue.getMName());
            statement.setInt(2, venue.getMX());
            statement.setInt(3, venue.getMY());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteVenue(Venue venue){
        String sql = "delete from venue where id=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, venue.getMId());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Venue> getVenues(){
        String sql = "select * from venue";

        List<Venue> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            var statement = con.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                Venue venue = new Venue();

                venue.setMId(res.getInt("id"));
                venue.setMName(res.getString("name"));
                venue.setMX(res.getInt("x"));
                venue.setMY(res.getInt("y"));

                list.add(venue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Food> getFoodOfAVenue(Venue venue){
        String sql = "select * from venue v join food f on(f.id=?)";

        List<Food> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            var statement = con.prepareStatement(sql);
            statement.setInt(1, venue.getMId());
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                Food food = new Food();

                food.setMId(res.getInt("id"));
                food.setMName(res.getString("name"));
                food.setMPortions(res.getInt("portions"));
                food.setMPrice(res.getInt("price"));
                food.setMGrams(res.getInt("grams"));
                food.setMVenue(res.getInt("idvenue"));

                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Drink> getDrinksOfAVenue(Venue venue){
        String sql = "select * from venue v join drink d on(d.id=?)";

        List<Drink> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            var statement = con.prepareStatement(sql);
            statement.setInt(1, venue.getMId());
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                Drink drink = new Drink();

                drink.setMId(res.getInt("id"));
                drink.setMName(res.getString("name"));
                drink.setMPortions(res.getInt("portions"));
                drink.setMPrice(res.getInt("price"));
                drink.setMMl(res.getInt("ml"));
                drink.setMVenue(res.getInt("idvenue"));

                list.add(drink);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
