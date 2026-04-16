package com.jhonatan.prova_leo;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Classe que gerencia o banco de dados Room.
 * Utiliza o padrão Singleton para garantir uma única instância do banco em todo o app.
 */
@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDatabase extends RoomDatabase {

    private static ProdutoDatabase instancia;

    /**
     * Método abstrato que retorna o DAO (Data Access Object) para produtos.
     */
    public abstract ProdutoDao produtoDao();

    /**
     * Retorna a instância única do banco de dados.
     * @param context Contexto da aplicação.
     * @return Instância do ProdutoDatabase.
     */
    public static synchronized ProdutoDatabase getInstancia(Context context) {
        if (instancia == null) {
            // Constrói o banco de dados
            instancia = Room.databaseBuilder(context.getApplicationContext(),
                    ProdutoDatabase.class, "produto_database")
                    // Permite recriar o banco se a versão mudar (limpa os dados)
                    .fallbackToDestructiveMigration()
                    // Permite rodar consultas na thread principal (apenas para fins educacionais/provas rápidas)
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}
