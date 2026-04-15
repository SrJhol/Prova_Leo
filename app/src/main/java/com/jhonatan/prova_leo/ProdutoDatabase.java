package com.jhonatan.prova_leo;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDatabase extends RoomDatabase {

    private static ProdutoDatabase instancia;

    public abstract ProdutoDao produtoDao();

    public static synchronized ProdutoDatabase getInstancia(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(context.getApplicationContext(),
                    ProdutoDatabase.class, "produto_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}
