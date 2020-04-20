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
import java.util.ArrayList;
import java.util.List;
import model.Gallery;

/**
 *
 * @author Administrator
 */
public class GalleryDB {

    // return number(s) Gallery
    public int countGallery() throws Exception {
        DBContext context = new DBContext();
        String query = "SELECT COUNT(*)\n"
                + "  FROM [Photographer].[dbo].[Gallery]";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return rows;
    }

    // return a list Gallery from - to with title
    public List<Gallery> galleryFromTo(int from, int to) throws Exception {
        DBContext context = new DBContext();
        List<Gallery> list = new ArrayList<>();

        String query = "SELECT [gallery_id]\n"
                + "      ,[title]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "  FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY gallery_id) as row\n"
                + "		FROM [Photographer].[dbo].[Gallery]\n"
                + "  ) a Where a.row >= ? and a.row <= ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                Gallery g = new Gallery();
                g.setGalleryId(rs.getInt("gallery_id"));
                g.setName(rs.getString("name"));
                g.setDescription(rs.getString("description"));
                g.setTitle(rs.getString("title"));
                list.add(g);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return list;
    }

    public List<Gallery> selectTop(int top) throws Exception {
        DBContext context = new DBContext();
        List<Gallery> list = new ArrayList<>();
        String query = "SELECT TOP (?) [gallery_id]\n"
                + "      ,[title]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "  FROM [Photographer].[dbo].[Gallery]";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery();
                g.setGalleryId(rs.getInt("gallery_id"));
                g.setName(rs.getString("name"));
                g.setDescription(rs.getString("description"));
                g.setTitle(rs.getString("title"));
                list.add(g);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return list;
    }

    public Gallery selectGalleryById(int id) throws Exception {
        DBContext context = new DBContext();
        Gallery g = new Gallery();
        String query = "SELECT [gallery_id]\n"
                + "      ,[title]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "  FROM [Photographer].[dbo].[Gallery]"
                + "  WHERE gallery_id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                g.setGalleryId(rs.getInt("gallery_id"));
                g.setName(rs.getString("name"));
                g.setDescription(rs.getString("description"));
                g.setTitle(rs.getString("title"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return g;
    }
}
