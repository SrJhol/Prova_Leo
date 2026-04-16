package com.jhonatan.prova_leo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface Data Access Object (DAO) para a entidade Produto.
 * Define os métodos de interação com o banco de dados.
 */
@Dao
public interface ProdutoDao {

    /**
     * Insere um novo produto na tabela "produtos".
     * @param produto O objeto produto a ser salvo.
     */
    @Insert
    void inserir(Produto produto);

    /**
     * Recupera todos os produtos cadastrados.
     * @return Uma lista contendo todos os objetos Produto do banco.
     */
    @Query("SELECT * FROM produtos")
    List<Produto> listarTodos();
}
