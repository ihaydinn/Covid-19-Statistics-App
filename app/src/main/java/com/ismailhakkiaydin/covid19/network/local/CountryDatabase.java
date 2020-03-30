package com.ismailhakkiaydin.covid19.network.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ismailhakkiaydin.covid19.network.dto.Country;

@Database(entities = {Country.class}, version = 1, exportSchema = false)
public abstract class CountryDatabase extends RoomDatabase {

    private static CountryDatabase instance;

    public abstract CountryDao countryDao();

    public static synchronized CountryDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CountryDatabase.class, "country_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
