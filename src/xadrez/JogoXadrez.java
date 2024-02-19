package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.*;

public class JogoXadrez {
    private Tabuleiro tabuleiro;

    public JogoXadrez() {

        tabuleiro = new Tabuleiro(8,8);
        configInicial();
    }
    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }

        }
        return mat;

    }

    private void configInicial(){
        tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.PRETA), new Posicao(0,4));
        tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.PRETA), new Posicao(0,0));
        tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.PRETA), new Posicao(0,7));
        tabuleiro.lugarPeca(new Cavalo(tabuleiro, Cor.PRETA), new Posicao(0,1));
        tabuleiro.lugarPeca(new Cavalo(tabuleiro, Cor.PRETA), new Posicao(0,6));
        tabuleiro.lugarPeca(new Bispo(tabuleiro, Cor.PRETA), new Posicao(0,2));
        tabuleiro.lugarPeca(new Bispo(tabuleiro, Cor.PRETA), new Posicao(0,5));
        tabuleiro.lugarPeca(new Rainha(tabuleiro, Cor.PRETA), new Posicao(0,3));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,0));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,1));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,2));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,3));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,4));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,5));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,6));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.PRETA), new Posicao(1,7));
        tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.BRANCA), new Posicao(7,4));
        tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(7,0));
        tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(7,7));
        tabuleiro.lugarPeca(new Cavalo(tabuleiro, Cor.BRANCA), new Posicao(7,1));
        tabuleiro.lugarPeca(new Cavalo(tabuleiro, Cor.BRANCA), new Posicao(7,6));
        tabuleiro.lugarPeca(new Bispo(tabuleiro, Cor.BRANCA), new Posicao(7,2));
        tabuleiro.lugarPeca(new Bispo(tabuleiro, Cor.BRANCA), new Posicao(7,5));
        tabuleiro.lugarPeca(new Rainha(tabuleiro, Cor.BRANCA), new Posicao(7,3));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,0));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,1));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,2));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,3));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,4));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,5));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,6));
        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(6,7));


        tabuleiro.lugarPeca(new Peao(tabuleiro, Cor.BRANCA), new Posicao(20,7));







    }
}
