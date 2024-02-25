package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
    public Peao(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);

        if (getCor() == Cor.BRANCA) {
            p.definirValor(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p) && getTabuleiro().posicaoExiste(p2)
                    && !getTabuleiro().haUmaPeca(p2) && getContagemMovimentos() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
        } else {
            p.definirValor(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p) && getTabuleiro().posicaoExiste(p2)
                    && !getTabuleiro().haUmaPeca(p2) && getContagemMovimentos() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.definirValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }



        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
