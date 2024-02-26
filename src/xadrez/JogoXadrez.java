package xadrez;


import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JogoXadrez {
    private int turno;
    private Cor jogadorAtual;
    private boolean checkMate;

    private boolean check;
    private Tabuleiro tabuleiro;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public JogoXadrez() {

        tabuleiro = new Tabuleiro(8,8);
        turno = 1;
        jogadorAtual = Cor.BRANCA;
        check = false;
        configInicial();
    }

    public int getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
    }

   public boolean getCheck(){
        return check;
   }

    public boolean getCheckMate() {
        return checkMate;
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

        if(testeCheck(jogadorAtual)){
            desfazerMover(origem,destino,capturaPeca);
            throw  new ExcesaoXadrez("Você não pode ser colocar em Check");
        }
        check = (testeCheck(oponente(jogadorAtual))) ? true : false;

        if(testeCheckMate(oponente(jogadorAtual))){
            checkMate = true;
        }else{
            proximoTurno();
        }


        return (PecaXadrez) capturaPeca;
    }

    private Peca fazerMover(Posicao origem, Posicao destino){
        PecaXadrez p = (PecaXadrez) tabuleiro.removePeca(origem);
        p.adicionaMovimento();
        Peca capturaPeca = tabuleiro.removePeca(destino);
        tabuleiro.lugarPeca(p,destino);
        if(capturaPeca != null){
            pecasNoTabuleiro.remove(capturaPeca);
            pecasCapturadas.add(capturaPeca);
        }
        //Roque do rei
        if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2){
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(origemT);
            tabuleiro.lugarPeca(torre, destinoT);
            torre.adicionaMovimento();
        }
        //Roque da Rainha
        if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2){
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(origemT);
            tabuleiro.lugarPeca(torre, destinoT);
            torre.adicionaMovimento();
        }

        return capturaPeca;
    }
    private void desfazerMover(Posicao origem, Posicao destino, Peca pecaCapturada){
       PecaXadrez p = (PecaXadrez) tabuleiro.removePeca(destino);
       p.removeMovimento();
       tabuleiro.lugarPeca(p, origem);
       if (pecaCapturada != null){
           tabuleiro.lugarPeca(pecaCapturada, destino);
           pecasCapturadas.remove(pecaCapturada);
           pecasNoTabuleiro.add(pecaCapturada);
       }

        //Roque do rei
        if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2){
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(destinoT);
            tabuleiro.lugarPeca(torre, origemT);
            torre.removeMovimento();
        }
        //Roque da Rainha
        if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2){
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removePeca(destinoT);
            tabuleiro.lugarPeca(torre, origemT);
            torre.removeMovimento();
        }
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

    private Cor oponente(Cor cor){
        return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
    }

    private PecaXadrez rei(Cor cor){
        List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
        for (Peca p : lista){
            if(p instanceof Rei){
                return (PecaXadrez) p;
            }
        }
        throw new IllegalArgumentException("Não existe o Rei da cor " + cor + " no tabuleiro");
    }
    private boolean testeCheck(Cor cor){
        Posicao posicaoRei = rei(cor).getposicaoXadrez().paraPosicionar();
        List<Peca> pecasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
        for (Peca p : pecasOponente){
          boolean[][] mat = p.movimentosPossiveis();
          if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]){
              return true;
          }
        }
        return false;
    }
    private boolean testeCheckMate(Cor cor){
        if(!testeCheck(cor)){
            return false;
        }
        List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
        for(Peca p : lista){
            boolean[][] mat = p.movimentosPossiveis();
            for (int i = 0; i < tabuleiro.getLinhas(); i++) {
                for (int j = 0; j < tabuleiro.getColunas(); j++) {
                    if(mat[i][j]){
                        Posicao origem = ((PecaXadrez)p).getposicaoXadrez().paraPosicionar();
                        Posicao destino = new Posicao(i,j);
                        Peca pecaCapturada = fazerMover(origem, destino);
                        boolean testeCheck = testeCheck(cor);
                        desfazerMover(origem, destino, pecaCapturada);
                        if (!testeCheck) {
                            return false;
                        }
                    }
                }

            }

        }

        return true;
    }


    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicionar());
        pecasNoTabuleiro.add(peca);
    }

    private void configInicial(){
        colocarNovaPeca('e',8,new Rei(tabuleiro, Cor.PRETA, this));
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
        colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCA, this));
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
