class Juego {
    private Mapa mapa;
    public Juego() {
        mapa = new Mapa();
    }
    public void mostrarTablero() {
        System.out.println("Territorio generado: " + mapa.getTerritorio());
        mapa.imprimirTablero();
    }
    public Reino determinarGanador() {
        int[] conteoEjercitos = new int[Reino.values().length];
        int[] vidaTotal = new int[Reino.values().length];
        int[] posicionesOcupadas = new int[Reino.values().length];
        Ejercito[][] tablero = mapa.getTablero();
        for (Ejercito[] fila : tablero) {
            for (Ejercito ejercito : fila) {
                if (ejercito != null) {
                    int indexReino = ejercito.getReino().ordinal();
                    conteoEjercitos[indexReino]++;
                    vidaTotal[indexReino] += ejercito.getSoldados();
                    posicionesOcupadas[indexReino]++;
                }
            }
        }
        return determinarReinoGanador(conteoEjercitos, vidaTotal, posicionesOcupadas);
    }
    private Reino determinarReinoGanador(int[] conteoEjercitos, int[] vidaTotal, int[] posicionesOcupadas) {
        int maxEjercitos = 0, maxVida = 0, maxPosiciones = 0;
        Reino reinoGanador = null;
        for (int i = 0; i < conteoEjercitos.length; i++) {
            if (conteoEjercitos[i] > maxEjercitos) {
                maxEjercitos = conteoEjercitos[i];
                maxVida = vidaTotal[i];
                maxPosiciones = posicionesOcupadas[i];
                reinoGanador = Reino.values()[i];
            } else if (conteoEjercitos[i] == maxEjercitos) {
                if (vidaTotal[i] > maxVida || posicionesOcupadas[i] > maxPosiciones) {
                    maxVida = vidaTotal[i];
                    maxPosiciones = posicionesOcupadas[i];
                    reinoGanador = Reino.values()[i];
                }
            }
        }
        return reinoGanador;
    }
}
