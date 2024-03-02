package application;

import xadrez.ExcesaoXadrez;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoXadrez jogoXadrez = new JogoXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();
        while (!jogoXadrez.getCheckMate()) {
            try {


                UI.limpaTela();
                UI.imprimePartida(jogoXadrez, capturadas);
                System.out.println();
                System.out.println("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                boolean[][] movimentosPossiveis = jogoXadrez.movimentosPossiveis(origem);
                UI.limpaTela();
                UI.imprimeTabuleiro(jogoXadrez.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.println("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaXadrez capturaPeca = jogoXadrez.executandoMovimentoXadrez(origem, destino);
                if(capturaPeca != null){
                    capturadas.add(capturaPeca);
                }
                if (jogoXadrez.getPromocao() != null){
                    System.out.print("Entre com a Peça Promovida (B/C/T/R)");
                    String type = sc.nextLine();
                    jogoXadrez.substituirPecaPromovida(type);
                }

            }catch(ExcesaoXadrez e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }
        }
        UI.limpaTela();
        UI.imprimePartida(jogoXadrez, capturadas);


    }
}
