package com.findapp.brunocardoso.findapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Administrador on 23/02/2018.
 */

public abstract class GenericDAO<T> extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "local_git_repository";
    private static final int VERSAO = 1;
    Context context;

    public GenericDAO(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS profile(" +
                "id_profile Long primary key autoincrement," +
                "name varchar(50) not null," +
                "description varchar(250))");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS repository(" +
                "id_repository Long primary key autoincrement," +
                "name varchar(50) not null," +
                "description varchar(300)," +
                "stars varchar(20) not null," +
                "fk_profile int(11) not null," +
                "foreign key (fk_profile) references profile(id_profile))");

        sqLiteDatabase.execSQL("Insert into profile(name, description) values('Front-End','Profile para repositórios relacionados a front-end')");
        for(int i = 0; i < 20; i++)
            sqLiteDatabase.execSQL("Insert into repository(name, description, stars, fk_profile) values ('react', 'react','30000',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public abstract void save(T t);
    public abstract void delete(T t);
    public abstract void edit(T t);
    public abstract void select(T t);
    public abstract ArrayList<T> listar();
    public abstract ArrayList<T> listar(String... values);
    public abstract ArrayList<T> listarOtherPage(int lastId);
}
