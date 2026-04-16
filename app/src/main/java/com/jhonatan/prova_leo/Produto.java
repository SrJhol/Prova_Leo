package com.jhonatan.prova_leo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entidade que representa a tabela "produtos" no banco de dados Room.
 */
@Entity(tableName = "produtos")
public class Produto {

    // Chave primária autoincrementada para identificar unicamente cada produto
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;

    /**
     * Construtor para criar um novo objeto Produto.
     * @param nome Nome do produto eletrônico.
     * @param codigo Código identificador (alfanumérico).
     * @param preco Preço unitário do produto.
     * @param quantidade Quantidade disponível no estoque.
     */
    public Produto(String nome, String codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters: Métodos para acessar e modificar os atributos privados

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
