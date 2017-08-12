package com.tigerrobocop.liv.collection;

import android.app.Application;
import android.support.annotation.NonNull;

import com.tigerrobocop.liv.collection.Model.Beer;
import com.tigerrobocop.liv.collection.Model.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Livia on 10/08/2017.
 */

public class CollectionApp extends Application {

    List<Item> mListItem;

    List<Beer> mListBeers;
    @Override
    public void onCreate() {
        super.onCreate();

        mListBeers = getBeers();
        mListItem = loadItems();
    }

    public  List<Beer> getBeers(){
        return mListBeers;
    }

    public  List<Item> getList(){
        return mListItem;
    }

    private List<Beer> loadBeers(){
        List<Beer> result = new ArrayList<>();


        result.add(new Beer(1, "IPA", "Capunga", R.integer.local
                , "Recife - PE", R.drawable.logo_capunga,"http://www.capunga.com/"));

        result.add(new Beer(2, "Lager", "Debron", R.integer.local
                , "Jabooatão dos Guararapes - PE", R.drawable.logo_debron, "https://www.facebook.com/DeBronBier/"));

        result.add(new Beer(3, "IPA", "Ekaut", R.integer.local
                , "Recife - PE", R.drawable.logo_ekaut, "http://ekaut.com.br/"));

        result.add(new Beer(4, "Pilsen" ,"Indie Beer", R.integer.local
                , "Recife - PE", R.drawable.logo_indie, "https://www.facebook.com/IBCA2016/"));

        return result;

    }

    private List<Item> loadItems() {
        List<Item> retorno = new ArrayList<Item>();
        retorno.add(new Item(1,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(2,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(3,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        retorno.add(new Item(4,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(5,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(6,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        retorno.add(new Item(7,
                R.string.item_1_title,
                R.string.item_1_description,
                "",
                ""));

        retorno.add(new Item(8,
                R.string.item_2_title,
                R.string.item_2_description,
                "",
                ""));

        retorno.add(new Item(9,
                R.string.item_3_title,
                R.string.item_3_description,
                "",
                ""));

        return retorno;
    }

}
