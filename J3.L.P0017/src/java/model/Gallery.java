/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Config;
import dao.ImageDB;

/**
 *
 * @author Administrator
 */
public class Gallery {

    private int galleryId;
    private String title;
    private String name;
    private String description;

    public Gallery() {
    }

    public Gallery(int galleryId, String title, String name, String description) {
        this.galleryId = galleryId;
        this.title = title;
        this.name = name;
        this.description = description;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTop1Image() throws Exception {
        return new ImageDB().selectTop1ImageByGalleryId(this.galleryId).getImage();
    }

    public String getTop1ImagePath() throws Exception {
        return Config.getInstance().getImage() + "/" + getTop1Image();
    }
}
