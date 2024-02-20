package jogoTabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
           throw new ExcecaoTabuleiro("Erro criando tabueiro: é necessário que haja pelo menos uma linha e uma coluna!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }


    public int getColunas() {
        return colunas;
    }


    public Peca peca(int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw new ExcecaoTabuleiro("Posição fora do tabuleiro!");
        }
        return pecas[linha][coluna];
    }
    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoTabuleiro("Posição fora do tabuleiro!");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void lugarPeca(Peca peca, Posicao posicao){
        if(haUmaPeca(posicao)){
            throw new ExcecaoTabuleiro("Já existe uma peça na posição: " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;

    }
    public  Peca removePeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoTabuleiro("Posição fora do tabuleiro!");
        }
        if (peca(posicao) == null){
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;



    }

    public boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }
    public boolean haUmaPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new ExcecaoTabuleiro("Posição fora do tabuleiro!");
        }
        return peca(posicao) != null;
    }
}
