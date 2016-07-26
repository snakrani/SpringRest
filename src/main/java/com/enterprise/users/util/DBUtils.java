package com.enterprise.users.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

 @Autowired
 private DataSource dataSource;
 
 @PostConstruct
 public void initialize(){
  try {
   Connection connection = dataSource.getConnection();
   Statement statement = connection.createStatement();
   statement.execute("DROP TABLE IF EXISTS User");
   statement.executeUpdate(
     "CREATE TABLE USER(" +
     "ID INTEGER Primary key, " +
     "FIRST_NAME varchar(30) not null, " +
     "LAST_NAME varchar(30) not null, " +
     "AGE INTEGER not null)"
     );
//   statement.executeUpdate(
//     "INSERT INTO USER " +
//     "(FIRST_NAME, LAST_NAME) " +
//     "VALUES " + "('DONALD', 'TRUMP')"
//     );
   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }
 }
}