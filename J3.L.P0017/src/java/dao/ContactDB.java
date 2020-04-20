/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contact;

/**
 *
 * @author Administrator
 */
public class ContactDB {

    // select Contact
    public Contact select() throws Exception {
        DBContext context = new DBContext();
        Contact contact = new Contact();
        String query = "SELECT [address]\n"
                + "      ,[city]\n"
                + "      ,[country]\n"
                + "      ,[tel]\n"
                + "      ,[email]\n"
                + "      ,[image_main]\n"
                + "      ,[name_image]\n"
                + "      ,[map]\n"
                + "      ,[about]\n"
                + "  FROM [Photographer].[dbo].[Contact]";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setTel(rs.getString("tel"));
                contact.setEmail(rs.getString("email"));
                contact.setImageMain(rs.getString("image_main"));
                contact.setMap(rs.getString("map"));
                contact.setAbout(rs.getString("about"));
                contact.setNameImage(rs.getString("name_image"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return contact;
    }
}
