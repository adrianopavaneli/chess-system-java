package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
    private JogoXadrez jogoXadrez;
    public Peao(Tabuleiro tabuleiro, Cor cor, JogoXadrez jogoXadrez)
    {
        super(tabuleiro, cor);
        this.jogoXadrez = jogoXadrez;
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
            // en passant branca
            if(posicao.getLinha() == 3){
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
                if(getTabuleiro().posicaoExiste(esquerda) && haPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == jogoXadrez.getVulneravelEnPassant()){
                  mat[esquerda.getLinha() -1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
                if(getTabuleiro().posicaoExiste(direita) && haPecaOponente(direita) && getTabuleiro().peca(direita) == jogoXadrez.getVulneravelEnPassant()){
                    mat[direita.getLinha() -1][esquerda.getColuna()] = true;
                }
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
            // en passant preta
            if(posicao.getLinha() == 4){
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
                if(getTabuleiro().posicaoExiste(esquerda) && haPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == jogoXadrez.getVulneravelEnPassant()){
                    mat[esquerda.getLinha() +1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
                if(getTabuleiro().posicaoExiste(direita) && haPecaOponente(direita) && getTabuleiro().peca(direita) == jogoXadrez.getVulneravelEnPassant()){
                    mat[direita.getLinha() +1][esquerda.getColuna()] = true;
                }
            }



        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
