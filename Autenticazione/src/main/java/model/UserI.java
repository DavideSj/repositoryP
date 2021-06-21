package model;

import model.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public interface UserI {
 

    public boolean insertUser(User user);
    public boolean loginUser(String email,String password);
    public User getUser(String email,String password);


}
