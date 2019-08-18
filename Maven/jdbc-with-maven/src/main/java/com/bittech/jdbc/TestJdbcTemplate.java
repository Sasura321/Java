package com.bittech.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Author: secondriver
 * Created: 2019/1/9
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestJdbcTemplate {

    public static void main(String[] args) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate("localhost", 3306, "root", "123456", "memo") {
            @Override
            public void handlerCUD(int effect) {
                //do nothing
            }

            @Override
            public void handlerR(ResultSet resultSet) {
                if (resultSet != null) {
                    try {
                        while (resultSet.next()) {//如果返回true表示有下一行记录，则否无记录
                            int id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            LocalDateTime createdTime = resultSet.getTimestamp("created_time").toLocalDateTime();
                            LocalDateTime modifyTime = resultSet.getTimestamp("modify_time").toLocalDateTime();
                            System.out.println(
                                    String.format(
                                            "编号：%d, 名称：%s, 创建时间：%s, 修改时间：%s",
                                            id, name,
                                            createdTime.toString(),
                                            modifyTime.toString()
                                    )
                            );

                        }
                    } catch (SQLException e) {

                    }
                }
            }

            @Override
            public String createSql() {
                return "select id,name,created_time,modify_time from memo_group";
            }

            @Override
            public boolean executeType() {
                return true;
            }
        };

        jdbcTemplate.call();


    }
}

