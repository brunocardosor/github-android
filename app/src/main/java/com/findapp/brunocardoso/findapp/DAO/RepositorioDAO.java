package com.findapp.brunocardoso.findapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.findapp.brunocardoso.findapp.Modelo.Repositorio;

import java.util.ArrayList;

/**
 * Created by Administrador on 23/02/2018.
 */

public class RepositorioDAO extends GenericDAO<Repositorio> {
    SQLiteDatabase db;
    public RepositorioDAO(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    @Override
    public void save(Repositorio repositorio) {

    }

    @Override
    public void delete(Repositorio repositorio) {

    }

    @Override
    public void edit(Repositorio repositorio) {

    }

    @Override
    public void select(Repositorio repositorio) {

    }

    @Override
    public ArrayList<Repositorio> listar() {
        return null;
    }

    @Override
    public ArrayList<Repositorio> listar(String... value) {
        return null;
    }

    @Override
    public ArrayList<Repositorio> listarOtherPage(int lastId) {
        return null;
    }

}
