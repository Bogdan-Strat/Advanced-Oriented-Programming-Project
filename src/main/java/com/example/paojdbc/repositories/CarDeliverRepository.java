package com.example.paojdbc.repositories;

import com.example.paojdbc.models.CarDeliver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDeliverRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void addCarDeliver(CarDeliver carDeliver){
        String sql = "insert into cardeliver values(NULL,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, carDeliver.getMName());
            statement.setInt(2, carDeliver.getMX());
            statement.setInt(3, carDeliver.getMY());
            statement.setBigDecimal(4, carDeliver.getMCommission());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<CarDeliver> getCarDelivers(){
        String sql = "select * from cardeliver";

        List<CarDeliver> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            var statement = con.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                CarDeliver carDeliver = new CarDeliver();

                carDeliver.setMId(res.getInt("id"));
                carDeliver.setMName(res.getString("name"));
                carDeliver.setMX(res.getInt("x"));
                carDeliver.setMY(res.getInt("y"));
                carDeliver.setMCommission(res.getBigDecimal("comission"));

                list.add(carDeliver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;


    }

    public void deleteCarDeliver(CarDeliver carDeliver){
        String sql = "delete from cardeliver where name=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, carDeliver.getMName());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void locationUpdate(CarDeliver carDeliver, Integer newX, Integer newY){
        String sql = "update cardeliver set x=?, y=? where name=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, newX);
            statement.setInt(2, newY);
            statement.setString(3, carDeliver.getMName());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
