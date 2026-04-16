package com.jhonatan.prova_leo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Tela Principal do aplicativo, responsável pelo cadastro de novos produtos.
 */
public class MainActivity extends AppCompatActivity {

    // Componentes de entrada de texto (Material Design)
    private TextInputEditText editNome, editCodigo, editPreco, editQuantidade;

    // Botões de ação
    private Button btnSalvar, btnVerLista;

    // Instância do banco de dados Room
    private ProdutoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa a conexão com o banco de dados (Singleton)
        db = ProdutoDatabase.getInstancia(this);

        // Mapeia os componentes do layout XML para o código Java
        editNome = findViewById(R.id.editNome);
        editCodigo = findViewById(R.id.editCodigo);
        editPreco = findViewById(R.id.editPreco);
        editQuantidade = findViewById(R.id.editQuantidade);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnVerLista = findViewById(R.id.btnVerLista);

        // Define a ação do botão Salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarProduto();
            }
        });

        // Define a ação do botão para abrir a lista de produtos
        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaProdutosActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Valida os campos e salva o novo produto no banco de dados.
     */
    private void salvarProduto() {
        // Captura os textos digitados e remove espaços em branco extras
        String nome = editNome.getText().toString().trim();
        String codigo = editCodigo.getText().toString().trim();
        String precoStr = editPreco.getText().toString().trim();
        String quantStr = editQuantidade.getText().toString().trim();

        // Verificação básica de campos vazios
        if (nome.isEmpty() || codigo.isEmpty() || precoStr.isEmpty() || quantStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Conversão de strings para tipos numéricos
            double preco = Double.parseDouble(precoStr.replace(",", "."));
            int quantidade = Integer.parseInt(quantStr);

            // Validação de valores positivos
            if (preco <= 0 || quantidade <= 0) {
                Toast.makeText(this, "Preço e quantidade devem ser positivos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cria o objeto Produto e insere no banco (executado na Thread principal por simplicidade nesta prova)
            Produto produto = new Produto(nome, codigo, preco, quantidade);
            db.produtoDao().inserir(produto);

            Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos(); // Limpa a tela após o sucesso

        } catch (NumberFormatException e) {
            // Caso o usuário digite algo que não seja um número válido
            Toast.makeText(this, "Digite valores válidos!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Limpa todos os campos de entrada e volta o foco para o primeiro campo.
     */
    private void limparCampos() {
        editNome.setText("");
        editCodigo.setText("");
        editPreco.setText("");
        editQuantidade.setText("");
        editNome.requestFocus();
    }
}
