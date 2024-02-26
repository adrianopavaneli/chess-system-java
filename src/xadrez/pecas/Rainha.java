package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez {
    public Rainha(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat =  new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);

        //acima

        p.definirValor(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() -1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //abaixo

        p.definirValor(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() +1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //direita

        p.definirValor(posicao.getLinha(), posicao.getColuna() +1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() +1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //esquerda

        p.definirValor(posicao.getLinha(), posicao.getColuna() -1);
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() -1);
        }
        if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //noroeste

        p.definirValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.definirValor(p.getLinha() - 1, p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //nordeste

        p.definirValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.definirValor(p.getLinha() - 1, p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //sudoeste

        p.definirValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.definirValor(p.getLinha() + 1, p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //sudeste

        p.definirValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.definirValor(p.getLinha() + 1, p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
