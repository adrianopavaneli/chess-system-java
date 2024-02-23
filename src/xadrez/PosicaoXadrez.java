package xadrez;

import jogoTabuleiro.Posicao;

public class PosicaoXadrez {
    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new ExcesaoXadrez("Erro instanciando Posição de Xadrez. Valores validos são de a1até h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }


    public int getLinha() {
        return linha;
    }
    protected Posicao paraPosicionar(){
        return new Posicao(8 - linha, coluna - 'a');

    }
    protected static PosicaoXadrez dePosicionar(Posicao posicao){
        return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;

    }
}
