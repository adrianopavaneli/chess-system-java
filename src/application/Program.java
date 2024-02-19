package application;

import xadrez.JogoXadrez;

public class Program {
    public static void main(String[] args) {
        JogoXadrez jogoXadrez = new JogoXadrez();
        UI.imprimeTabuleiro(jogoXadrez.getPecas());
    }


}
