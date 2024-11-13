public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.mostrarTablero();
        Reino ganador = juego.determinarGanador();
        System.out.println("Ganador: " + ganador);
    }
}
