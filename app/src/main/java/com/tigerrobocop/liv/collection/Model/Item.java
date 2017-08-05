package com.tigerrobocop.liv.collection.Model;

import java.io.Serializable;

/**
 * Created by Livia on 31/07/2017.
 */

public class Item  implements Serializable {

    public Item(int id, int title, int description, String url, String imageUrl) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public int id;
    public int title;
    public int description;
    public String url;
    public String imageUrl;

    @Override
    public String toString() {
        return title + ": " + description;
    }
}
