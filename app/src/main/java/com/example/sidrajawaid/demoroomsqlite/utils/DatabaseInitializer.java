package com.example.sidrajawaid.demoroomsqlite.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sidrajawaid.demoroomsqlite.database.AppDatabase;
import com.example.sidrajawaid.demoroomsqlite.entity.User;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

//    public static void populateSync(@NonNull final AppDatabase db) {
//        populateWithTestData(db);
//    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }
    public static void saveData(AppDatabase db,String fname,String lname,int age) {
        //TODO:
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setAge(age);
        addUser(db, user);

    }

    private static User editUser(final AppDatabase db, User user) {
        db.userDao().editUser(user);
        return user;
    }
    public static void editData(AppDatabase db,String fname,String lname,int age) {
        //TODO:
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setAge(age);
        editUser(db, user);

    }

    private static void deleteUser(final AppDatabase db, User user) {
        db.userDao().delete(user);

    }
    public static void deleteData(AppDatabase db,String fname) {
        //TODO:
        User user1 = new User();
        user1.setFirstName(fname);
        deleteUser(db,user1);
    }

    private static List showUser(final AppDatabase db) {
        List<User> userlist=db.userDao().getAll();
        return userlist;

    }
    public static List showData(AppDatabase db) {
        //TODO:
        List<User> userList = showUser(db);
        return userList;

    }



    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //populateWithTestData(mDb);
            return null;
        }

    }
}
