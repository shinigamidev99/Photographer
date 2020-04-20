/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.GalleryDB;
import java.io.Serializable;
import java.util.List;
import model.Gallery;

/**
 *
 * @author Administrator
 */
public class PagingBean implements Serializable {

    private int page, size;
    private GalleryDB gdb;

    public PagingBean() {
        size = 3;
        page = 1;
        gdb = new GalleryDB();
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

    // return the total pages
    public int getPages() throws Exception {
        int rows = 0;
        rows = gdb.countGallery();
        return (int) Math.ceil(rows * 1.0 / size);
    }

    // return list Gallery from - to
    public List<Gallery> getList() throws Exception {
        int from = (page - 1) * size + 1;
        int to = page * size;
        List<Gallery> list = gdb.galleryFromTo(from, to);
        return list;
    }
}
