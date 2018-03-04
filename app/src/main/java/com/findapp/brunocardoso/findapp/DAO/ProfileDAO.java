package com.findapp.brunocardoso.findapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.findapp.brunocardoso.findapp.Modelo.Profile;

import java.util.ArrayList;

/**
 * Created by Administrador on 23/02/2018.
 */

public class ProfileDAO extends GenericDAO<Profile> {

    SQLiteDatabase db;

    public ProfileDAO(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    @Override
    public void save(Profile profile) {

    }

    @Override
    public void delete(Profile profile) {

    }

    @Override
    public void edit(Profile profile) {

    }

    @Override
    public void select(Profile profile) {

    }

    @Override
    public ArrayList<Profile> listar() {
        return null;
    }

    @Override
    public ArrayList<Profile> listar(String... value) {
        return null;
    }

    @Override
    public ArrayList<Profile> listarOtherPage(int lastId) {
        return null;
    }

}
