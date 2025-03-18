package es.ejemplo.android.proyecto1;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;


public class Actividad1 extends AppCompatActivity {

    List arrayList;
    EditText texto1, texto2;
    SQLiteDatabase db;
    ListView miLista;
    SimpleCursorAdapter adaptador;
    int seleccionado;
    Cursor cursor2;
    String[] from;
    int[] to;
    String indice, nombre1, nombre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        Button insertar = findViewById(R.id.insertar);
        Button actualizar = findViewById(R.id.actualizar);
        Button borrar = findViewById(R.id.borrar);

        texto1 = findViewById(R.id.edit1);
        texto2 = findViewById(R.id.edit2);

        miLista = findViewById(R.id.listView);

        UsuariosSQLiteHelper usuariosBBDD = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        db = usuariosBBDD.getWritableDatabase();
        muestra();

        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seleccionado = position;
                cursor2.moveToPosition(seleccionado);
                indice = cursor2.getString(0);
                texto1.setText(cursor2.getString(1));
                texto2.setText(cursor2.getString(2));
                Toast.makeText(getApplicationContext(), "SELECCIONADO REGISTRO CON ÍNDICE" + indice, Toast.LENGTH_SHORT).show();

            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre1 = texto1.getText().toString();
                nombre2 = texto2.getText().toString();

                if (nombre1.length() == 0 || nombre2.length() == 0) {
                    Toast.makeText(getApplicationContext(), "NO PUEDE HABER CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
                } else {

                    AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(Actividad1.this);
                    alerDialogBuilder
                            .setTitle("ACTIVIDAD SQLITE?")
                            .setMessage("¿Desea modificar este registro?")
                            .setNegativeButton("NO MODIFICAR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(), "REGISTRO NO ACTUALIZADO", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("SI MODIFICAR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String puntero = String.valueOf(indice);
                                    ContentValues editarRegistro = new ContentValues();
                                    editarRegistro.put("texto1", nombre1);
                                    editarRegistro.put("texto2", nombre2);
                                    db.update("tabla1", editarRegistro, "_id=" + puntero, null);
                                    Toast.makeText(getApplicationContext(), "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                                    muestra();
                                }
                            })
                            .create()
                            .show();
                }
            }
        });

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre1 = texto1.getText().toString();
                nombre2 = texto2.getText().toString();

                if (nombre1.length() == 0 || nombre2.length() == 0) {
                    Toast.makeText(getApplicationContext(), "NO PUEDE HABER CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues nuevoRegistro = new ContentValues();
                    //nuevoRegistro.put("codigo", posicion);
                    nuevoRegistro.put("texto1", nombre1);
                    nuevoRegistro.put("texto2", nombre2);
                    db.insert("tabla1", null, nuevoRegistro);
                    Toast.makeText(getApplicationContext(), "REGISTRO AÑADIDO", Toast.LENGTH_SHORT).show();
                    muestra();
                }
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(Actividad1.this);
                alerDialogBuilder
                        .setTitle("ACTIVIDAD SQLITE?")
                        .setMessage("¿Desea borrar este registro?")
                        .setNegativeButton("NO BORRAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "REGISTRO NO BORRADO", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("SI BORRAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String puntero = String.valueOf(indice);
                                //db.execSQL("DELETE FROM tabla1 WHERE _id=" + puntero);
                                db.delete("tabla1", "_id=" + puntero, null);
                                adaptador.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(), "REGISTRO BORRADO " , Toast.LENGTH_SHORT).show();
                                muestra();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }


    public void muestra() {
        cursor2 = db.query("tabla1", null, null, null, null, null, null);
        from = new String[]{"texto1", "texto2"};
        to = new int[]{android.R.id.text1, android.R.id.text2};
        startManagingCursor(cursor2);
        adaptador = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor2, from, to, 0);
        adaptador.notifyDataSetChanged();
        miLista.setAdapter(adaptador);
    }

}

