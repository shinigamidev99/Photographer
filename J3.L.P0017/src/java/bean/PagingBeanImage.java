/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.GalleryDB;
import dao.ImageDB;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;

/**
 *
 * @author Administrator
 */
public class PagingBeanImage implements Serializable {

    private int page, size, galleryId;
    private GalleryDB gdb;
    private ImageDB idb;

    public PagingBeanImage() {
        size = 8;
        page = 1;
        gdb = new GalleryDB();
        idb = new ImageDB();
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    // return the total pages
    public int getPages() throws Exception {
        int rows = 0;
        rows = idb.countImageByGalleryId(galleryId);
        return (int) Math.ceil(rows * 1.0 / size);
    }

    // return list image from - to with galleryId
    public List<Image> getList() throws Exception {
        int from = (page - 1) * size + 1;
        int to = page * size;
        List<Image> list = idb.selectImageFromToByGalleryId(from, to, galleryId);
        return list;
    }
}
