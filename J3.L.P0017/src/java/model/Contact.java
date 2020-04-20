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
public class Contact {

    private String address;
    private String city;
    private String country;
    private String tel;
    private String email;
    private String imageMain;
    private String map;
    private String about;
    private String nameImage;

    public Contact() {
    }

    public Contact(String address, String city, String country, String tel,
            String email, String imageMain, String map, String about, String nameImage) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.tel = tel;
        this.email = email;
        this.imageMain = imageMain;
        this.map = map;
        this.about = about;
        this.nameImage = nameImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getImagePath() throws Exception {
        return Config.getInstance().getImage() + "/" + imageMain;
    }

    public String getMapPath() throws Exception {
        return Config.getInstance().getImage() + "/" + map;
    }
}
