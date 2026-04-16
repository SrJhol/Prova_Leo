# 📦 Cadastro de Produtos - Loja Eletrônica

Este é um aplicativo Android desenvolvido para modernizar a organização de uma pequena loja de produtos eletrônicos. O sistema substitui as anotações manuais por um banco de dados local robusto, permitindo o cadastro e a visualização de estoque de forma digital e eficiente.

## 🚀 Funcionalidades

- **Tela de Cadastro**:
    - Nome do produto.
    - Código alfanumérico.
    - Preço (com validação de duas casas decimais).
    - Quantidade em estoque (apenas números inteiros positivos).
    - **Validações**: Impede campos em branco e valores negativos.

- **Tela de Listagem**:
    - Visualização clara de Nome, Código e Preço.
    - Interface baseada em `RecyclerView` com `CardView` para um design moderno.
    - Navegação fluida de volta para a tela de cadastro.

- **Persistência de Dados**:
    - Armazenamento local utilizando **Room Database**.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **Banco de Dados**: Room Database (Entity, DAO, Database)
- **UI/UX**: Material Design Components, ScrollView, RecyclerView, CardView.
- **IDE**: Android Studio
- **Versão do SDK**: Target SDK 36 (Android 15) / Compilação ajustada para compatibilidade.

## 📁 Estrutura do Projeto

- `Produto.java`: Entidade que define a tabela no banco de dados.
- `ProdutoDao.java`: Interface com os comandos SQL (Insert, Select).
- `ProdutoDatabase.java`: Classe Singleton que gerencia a instância do Room.
- `MainActivity.java`: Lógica da tela de cadastro e validações.
- `ListaProdutosActivity.java`: Lógica da tela de exibição dos produtos.
- `ProdutoAdapter.java`: Ponte entre a lista de dados e o RecyclerView.

## 🔧 Como Rodar o Projeto

1. Clone o repositório ou baixe o código-fonte.
2. Abra o projeto no **Android Studio**.
3. Certifique-se de que o **Gradle Sync** foi concluído com sucesso.
4. (Opcional) Verifique se o emulador ou dispositivo físico está configurado para a API 34 ou superior.
5. Clique no botão **Run (Play)** no topo da IDE.

## 📝 Autor SrJhol

Desenvolvido por **Jhonatan Mendes**.
