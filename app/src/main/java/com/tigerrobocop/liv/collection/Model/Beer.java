package com.tigerrobocop.liv.collection.Model;

import java.io.Serializable;

/**
 * Created by Livia on 11/08/2017.
 */

public class Beer implements Serializable {

    public int id;
    public String type;
    public int origin;
    public String city;
    public int photoID;
    public String photoPath;

    // constructor from local resources
    public Beer(int _id, String _type, int _origin, String _city, int _photoID){
        this.id = _id;
        this.type = _type;
        this.origin = _origin;
        this.city = _city;
        this.photoID = _photoID;
    }

    // constructor from user input
    public Beer(int _id, String _type, int _origin, String _city, String _photoPath){
        this.id = _id;
        this.type = _type;
        this.origin = _origin;
        this.city = _city;
        this.photoPath = _photoPath;
    }


}
