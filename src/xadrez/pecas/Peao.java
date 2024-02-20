package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
    public Peao(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "P";
    }
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat =  new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);

        p.definirValor(posicao.getLinha() - 1, posicao.getColuna());
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() -1);

        if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
