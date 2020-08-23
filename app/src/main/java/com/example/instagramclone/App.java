package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("P32P7ZBDjryRvASiCaNM1ayrwTfwNlJjAtGZ4K4B")
                // if defined
                .clientKey("oQ0JS7Y41O1Sce2Oh3aa3fuQqnB4ubRplL5annr0")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
