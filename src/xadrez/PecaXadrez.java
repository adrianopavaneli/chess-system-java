package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import jogoTabuleiro.Peca;

public abstract class PecaXadrez extends Peca {
    private Cor cor;
    private int contagemMovimentos;


    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
    public PosicaoXadrez getposicaoXadrez(){
        return PosicaoXadrez.dePosicionar(posicao);
    }

    public int getContagemMovimentos() {
        return contagemMovimentos;
    }

    public void adicionaMovimento(){
        contagemMovimentos++;
    }
    public void removeMovimento(){
        contagemMovimentos--;
    }

    protected boolean haPecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
}
