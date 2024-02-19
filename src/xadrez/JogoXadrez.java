package xadrez;


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
    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicionar());
    }

    private void configInicial(){
        colocarNovaPeca('e',8,new Rei(tabuleiro, Cor.PRETA));
        colocarNovaPeca('a',8,new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('h',8,new Torre(tabuleiro, Cor.PRETA));
        colocarNovaPeca('b',8,new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('g',8,new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('c',8,new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('f',8,new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('d',8,new Rainha(tabuleiro, Cor.PRETA));
        colocarNovaPeca('a',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('b',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('c',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('d',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('f',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('g',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('h',7,new Peao(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('a',1,new Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('h',1,new Torre(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('b',1,new Cavalo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('g',1,new Cavalo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('c',1,new Bispo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('f',1,new Bispo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('d',1,new Rainha(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('a',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('b',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('c',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('d',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('e',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('f',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('g',2,new Peao(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('h',2,new Peao(tabuleiro, Cor.BRANCA));
















    }
}
