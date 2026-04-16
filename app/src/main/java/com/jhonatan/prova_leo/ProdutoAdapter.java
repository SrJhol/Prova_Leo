package com.jhonatan.prova_leo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

/**
 * Adaptador para o RecyclerView que exibe a lista de produtos.
 * Responsável por converter os objetos Produto em elementos visuais da lista.
 */
public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private List<Produto> listaProdutos;

    /**
     * Construtor do adaptador.
     * @param listaProdutos Lista de produtos a ser exibida.
     */
    public ProdutoAdapter(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    /**
     * Cria uma nova visualização (infla o layout do item) quando o RecyclerView precisar.
     */
    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o arquivo de layout XML para cada item da lista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);
        return new ProdutoViewHolder(view);
    }

    /**
     * Vincula os dados de um produto específico aos componentes visuais do ViewHolder.
     */
    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);

        // Define os textos nos TextViews do item
        holder.textNome.setText(produto.getNome());
        holder.textCodigo.setText("Código: " + produto.getCodigo());
        // Formata o preço para o padrão de moeda (ex: R$ 10,00)
        holder.textPreco.setText(String.format(Locale.getDefault(), "R$ %.2f", produto.getPreco()));
    }

    /**
     * Retorna a quantidade total de itens na lista.
     */
    @Override
    public int getItemCount() {
        return listaProdutos != null ? listaProdutos.size() : 0;
    }

    /**
     * Classe interna que mantém as referências para os componentes visuais de um único item.
     */
    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView textNome, textCodigo, textPreco;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Mapeia os componentes do layout item_produto.xml
            textNome = itemView.findViewById(R.id.textNomeItem);
            textCodigo = itemView.findViewById(R.id.textCodigoItem);
            textPreco = itemView.findViewById(R.id.textPrecoItem);
        }
    }
}
