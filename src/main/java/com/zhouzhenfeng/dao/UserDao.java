package com.zhouzhenfeng.dao;

import com.zhouzhenfeng.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{



    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4, user.getEmail());
        st.setString(5, user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthdate());

        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from  usertable where id=?, username=?,password=?,email=?,gender=?,birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4, user.getEmail());
        st.setString(5, user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthdate());
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4, user.getEmail());
        st.setString(5, user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthdate());
        return 0;
    }


    @Override
    public   User findById(Connection con, Integer id) throws SQLException {
        String sql="select id, username,password,email,gender,birthdate from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id, username,password,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user= new User();

            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select id, username,password,email,gender,birthdate from usertable where username =?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setUsername(rs.getString("username"));
        }
        return (List<User>) user;

    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select id, username,password,email,gender,birthdate from usertable where password =?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setUsername(rs.getString("password"));
        }
        return (List<User>) user;

    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {

        String sql="select id, username,password,email,gender,birthdate from usertable where email =?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setUsername(String.valueOf(rs.getDate("email")));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {

        String sql="select id, username,password,email,gender,birthdate from usertable where gender =?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setUsername(rs.getString("gender"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {

        String sql="select id, username,password,email,gender,birthdate from usertable where birthdate =?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user = new User();
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select id, username,password,email,gender,birthdate from usertable where gender =?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user= new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }
}


