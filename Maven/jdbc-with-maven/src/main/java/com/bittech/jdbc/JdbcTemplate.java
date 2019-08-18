package com.bittech.jdbc;

import java.sql.*;

/**
 * Author: secondriver
 * Created: 2019/1/9
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public abstract class JdbcTemplate {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private int effect = -1;
    private String url;
    public JdbcTemplate(String host, Integer port, String username, String password, String databaseName) {
        this.url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false",
                host,
                port,
                databaseName,
                username,
                password);
    }
    public final void call() {
        //1.加载驱动
        loadDriver();
        //2.创建连接
        createConnect();
        //3.创建命令
        createStatement();
        //4.准备SQL
        createSql();
        //5.执行
        execute();
        //6.处理结果
        //第一类：CUD int 第二：R result
        handlerResult();
        //7.关闭结果集，命令，连接
        closeAll();
    }

    private void closeAll() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.effect = -1;
    }

    private void handlerResult() {
        if (this.executeType()) {
            this.handlerR(resultSet);
        } else {
            this.handlerCUD(effect);
        }

    }

    public abstract void handlerCUD(int effect);

    public abstract void handlerR(ResultSet resultSet);

    private void execute() {
        String sql = this.createSql();
        if (sql != null) {
            if (this.executeType()) {
                //select
                try {
                    resultSet = statement.executeQuery(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                //insert update delete
                try {
                    effect = statement.executeUpdate(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //用户来覆写
    public abstract String createSql();

    //如果返回true 查询， 如果返回false 插入，删除，更新
    public abstract boolean executeType();

    private void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnect() {
        try {
            connection = DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

