package xadrez;


import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.*;

public class JogoXadrez {
    private int turno;
    private Cor jogadorAtual;
    private boolean checkMate;
    private Tabuleiro tabuleiro;

    public JogoXadrez() {

        tabuleiro = new Tabuleiro(8,8);
        turno = 1;
        jogadorAtual = Cor.BRANCA;
        configInicial();
    }

    public int getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
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

    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
        Posicao posicao = posicaoOrigem.paraPosicionar();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }
    public PecaXadrez executandoMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ){
        Posicao origem = posicaoOrigem.paraPosicionar();
        Posicao destino = posicaoDestino.paraPosicionar();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca capturaPeca = fazerMover(origem, destino);
        proximoTurno();
        return (PecaXadrez) capturaPeca;
    }

    private Peca fazerMover(Posicao origem, Posicao destino){
        Peca p = tabuleiro.removePeca(origem);
        Peca capturaPeca = tabuleiro.removePeca(destino);
        tabuleiro.lugarPeca(p,destino);
        return capturaPeca;
    }

    private void validarPosicaoOrigem(Posicao posicao){
        if(!tabuleiro.haUmaPeca(posicao)){
            throw new ExcesaoXadrez("Não existe peça na posicao de origem!");
        }
        if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()){
            throw new ExcesaoXadrez("A peça escolhida não é sua!");
        }
        if(!tabuleiro.peca(posicao).existeMovimentoPossivel()){
            throw new ExcesaoXadrez("Não há movimentos possiveis para essa peça!");
        }
    }
    private void validarPosicaoDestino(Posicao origem, Posicao destino){
        if(!tabuleiro.peca(origem).movimentosPossiveis(destino)){
            throw new ExcesaoXadrez("A peça escolhida não pode mover para a posição de destino!");
        }
    }

    private void proximoTurno(){
        turno++;
        jogadorAtual = (jogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
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
