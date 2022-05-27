package com.example.paojdbc.services;

import com.example.paojdbc.models.Product;
import com.example.paojdbc.models.User;
import com.example.paojdbc.models.Venue;
import com.example.paojdbc.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(User user){
        userRepository.addUser(user);
    }

    public List<User> getUsers(){
       return userRepository.getUsers();
    }

    public User getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    public void closeAccount(User user){
        userRepository.deleteUser(user);
    }

    public void changePassword(User user, String password){
        userRepository.updatePassword(user, password);
    }

    public void addProductInBasket(User user, Product product){
        List <Product> basket = user.getMBasket();
        basket.add(product);
        user.setMBasket(basket);
    }

    public List<Product> getBasket(User user){
        return user.getMBasket();
    }

    public Integer getPriceOfBasket(User user){
        Integer costBasket = 0;

        for(Product prod : user.getMBasket()){
            costBasket += prod.getMPrice();
        }

        return costBasket;
    }

    public void selectRestaurant(User user, Venue venue){
        user.setMOnRestaurant(venue);
    }
}
