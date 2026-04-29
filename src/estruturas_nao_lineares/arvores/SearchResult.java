package estruturas_nao_lineares.arvores;

// Classe auxiliar interna para retornar os dados da busca
public class SearchResult {
    int value;
    int level;
    int height;

    SearchResult(int value, int level, int height) {
        this.value = value;
        this.level = level;
        this.height = height;
    }
}
