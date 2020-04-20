/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Config;

/**
 *
 * @author Administrator
 */
public class Image {

    private int id;
    private int galleryId;
    private String image;

    public Image() {
    }

    public Image(int id, int galleryId, String image) {
        this.id = id;
        this.galleryId = galleryId;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imagePath) {
        this.image = imagePath;
    }

    public String getImagePath() throws Exception {
        return Config.getInstance().getImage() + "/" + this.image;
    }
}
