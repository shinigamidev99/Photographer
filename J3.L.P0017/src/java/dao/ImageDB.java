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
import model.Image;

/**
 *
 * @author Administrator
 */
public class ImageDB {

    // select list image from - to with galleryId
    public List<Image> selectImageFromToByGalleryId(int from, int to, int galleryId) throws Exception {
        DBContext context = new DBContext();
        List<Image> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,[gallery_id]\n"
                + "      ,[image]\n"
                + "FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY id) as row\n"
                + "		FROM [Photographer].[dbo].[Image]\n"
                + "             WHERE gallery_id = ?"
                + ") a Where a.row >= ? and a.row <= ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galleryId);
            ps.setInt(2, from);
            ps.setInt(3, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("gallery_id"));
                image.setImage(rs.getString("image"));
                list.add(image);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return list;
    }

    // select top 1 image by gallery id
    public Image selectTop1ImageByGalleryId(int galleryId) throws Exception {
        DBContext context = new DBContext();
        Image image = new Image();
        String query = "SELECT TOP (1) [id]\n"
                + "      ,[gallery_id]\n"
                + "      ,[image]\n"
                + "  FROM [Photographer].[dbo].[Image]\n"
                + "  WHERE gallery_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galleryId);
            rs = ps.executeQuery();

            while (rs.next()) {
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("gallery_id"));
                image.setImage(rs.getString("image"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return image;
    }

    // select image with id image and gallery id
    public Image selectImageByGalleryIdAndId(int galleryId, int id) throws Exception {
        DBContext context = new DBContext();
        Image image = new Image();
        String query = "SELECT [id]\n"
                + "      ,[gallery_id]\n"
                + "      ,[image]\n"
                + "  FROM [Photographer].[dbo].[Image]\n"
                + "WHERE gallery_id = ? and id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galleryId);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                image.setId(rs.getInt("ID"));
                image.setGalleryId(rs.getInt("gallery_id"));
                image.setImage(rs.getString("image"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }
        return image;
    }

    // return number(s) Image by gallery_id
    public int countImageByGalleryId(int galleryId) throws Exception {
        DBContext context = new DBContext();
        String query = "SELECT COUNT(*)\n"
                + "  FROM [Photographer].[dbo].[Image]\n"
                + " WHERE gallery_id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galleryId);
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
}
