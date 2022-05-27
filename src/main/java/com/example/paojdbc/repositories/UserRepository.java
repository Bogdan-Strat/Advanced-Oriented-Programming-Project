package com.example.paojdbc.repositories;

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
public class UserRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public void addUser(User user){
        String sql = "insert into user values(NULL,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, user.getMName());
            statement.setString(2, user.getMEmail());
            statement.setString(3, user.getMPassword());
            statement.setInt(4, user.getMX());
            statement.setInt(5, user.getMY());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        String sql = "select * from user";

        List<User> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            var statement = con.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                User user = new User();

                user.setMId(res.getInt("id"));
                user.setMName(res.getString("name"));
                user.setMEmail(res.getString("email"));
                user.setMPassword(res.getString("password"));
                user.setMX(res.getInt("x"));
                user.setMY(res.getInt("y"));

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;


    }

    public void deleteUser(User user){
        String sql = "delete from user where email=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, user.getMEmail());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePassword(User user, String newPassword){
        String sql = "update user set password=? where email=?";

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, user.getMEmail());
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public User getUserById(Integer id){
        String sql = "select * from user where id=?";
        User user = new User();

        try (Connection con = DriverManager.getConnection(url, username, password)){
            var statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();


            user.setMId(res.getInt("id"));
            user.setMName(res.getString("name"));
            user.setMEmail(res.getString("email"));
            user.setMPassword(res.getString("password"));
            user.setMX(res.getInt("x"));
            user.setMY(res.getInt("y"));

        } catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }
}
