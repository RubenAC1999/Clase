package es.ejemplo.android.proyecto1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE tabla1(_id INTEGER PRIMARY KEY AUTOINCREMENT, texto1 TEXT, texto2 TEXT)";
    String sqlDelete = "DROP TABLE IF EXISTS tabla1";

    public UsuariosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDelete);
        db.execSQL(sqlCreate);
    }
}
