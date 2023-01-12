package com.meiken;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/jndi")
public class JndiController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String test(){

        String returnResult = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Context ctx = new InitialContext();
            Object datasourceRef = ctx.lookup("java:comp/env/jndi/user"); //引用数据源
            DataSource ds = (DataSource) datasourceRef;
            conn = ds.getConnection();
            String sql = "select * from user_test where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "1");
            rs = ps.executeQuery();

            while (rs.next()) {
                returnResult = rs.getString("name");
                System.out.println("person name is " + returnResult );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        return returnResult;

    }
}
