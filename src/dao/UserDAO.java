package dao;
import db.DBConnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void insertUser(User user){

        String sql = "INSERT INTO USERS (username, hashed_password) VALUES (? ?)";

    try (Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(sql)){

        preparedStatement.setString(1, user.toString());
        preparedStatement.setString(2, user.getHashedPassword());
        preparedStatement.executeUpdate();

        System.out.println("[DB] User registered Successfully.");

    }catch(SQLIntegrityConstraintViolationException e){
        System.out.println("[DB] Username already exists!");
    }catch(SQLException e){
        System.out.println("[DB] Error inserting user: " + e.getMessage());
    }

    }

    //fetch single user by users

    public User getUserByUsername(String username){
        String sql = "SELECT * FROM users where username = ?";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("hashed_password")
                );
            }

        }catch(SQLException e){
            System.out.println("[DB] Error fetching user: " + e.getMessage());

        }
        return null;
    }

    //fetch all users
    public List<User> getAllUsers(){
        List <User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                users.add(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("hashed_password")
                ));
            }
            
        } catch (SQLException e) {
            System.out.println("[DB] Error fetching users: " + e.getMessage());
        }

        return users;
    }

    


    
}
