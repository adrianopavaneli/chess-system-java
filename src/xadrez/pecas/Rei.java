package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
    private JogoXadrez jogoXadrez;

    public Rei(Tabuleiro tabuleiro, Cor cor, JogoXadrez jogoXadrez) {
        super(tabuleiro, cor);
        this.jogoXadrez = jogoXadrez;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();

    }
    public boolean testeRoque(Posicao posicao){
       PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContagemMovimentos() == 0;
    }

    public boolean[][] movimentosPossiveis() {
        boolean[][] mat =  new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);
        //acima
        p.definirValor(posicao.getLinha() - 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }


       //abaixo
        p.definirValor(posicao.getLinha() + 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //direita
        p.definirValor(posicao.getLinha(), posicao.getColuna() +1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }



        //esquerda
        p.definirValor(posicao.getLinha(), posicao.getColuna() -1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //noroeste
        p.definirValor(posicao.getLinha() - 1, posicao.getColuna() -1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //nordeste
        p.definirValor(posicao.getLinha() - 1, posicao.getColuna() +1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //sudoeste
        p.definirValor(posicao.getLinha() + 1, posicao.getColuna() -1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //sudeste
        p.definirValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //Roque

        if (getContagemMovimentos() == 0 && !jogoXadrez.getCheck()){
          // roque do rei
           Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
           if (testeRoque(posT1)){
               Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
               Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
               if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null){
                   mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
               }
           }
           //Roque da rainha
            Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
            if (testeRoque(posT2)){
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
                Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
                if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null){
                    mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
                }
            }
        }


        return mat;
    }
}
