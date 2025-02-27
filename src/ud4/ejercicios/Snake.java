package ud4.ejercicios;


/*
public class Snake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        // Leer el primer número de movimientos
        int N = scanner.nextInt();

        while (N != 0) { // Continuar mientras N no sea 0
            // Inicialización del juego
            int[][] board = new int[21][21]; // Tablero 21x21
            int headX = 10, headY = 10; // Posición inicial de la cabeza
            int length = 10; // Longitud inicial de la serpiente
            int time = 0; // Tiempo actual
            int[] snakeX = new int[2000]; // Para almacenar las posiciones X de la serpiente
            int[] snakeY = new int[2000]; // Para almacenar las posiciones Y de la serpiente

            // Inicializar la serpiente
            for (int i = 0; i < length; i++) {
                snakeX[i] = headX; // X de la cabeza
                snakeY[i] = headY + i; // Y de la cabeza (vertical)
                board[headX][headY + i] = 1; // Marcar la posición ocupada
            }

            int lastTime = 0; // Último instante en que la serpiente pudo avanzar
            boolean collision = false; // Indica si hay colisión

            // Procesar movimientos
            for (int i = 0; i < N; i++) {
                int t = scanner.nextInt(); // Tiempo del movimiento
                char direction = scanner.next().charAt(0); // Dirección del movimiento

                // Mover la serpiente hasta el tiempo del movimiento
                while (time < t) {
                    time++;
                    lastTime = time;

                    // Mover la cabeza de la serpiente
                    int newX = headX, newY = headY;

                    // Actualizar la posición según la dirección
                    switch (direction) {
                        case 'U': newX--; break; // Arriba
                        case 'D': newX++; break; // Abajo
                        case 'L': newY--; break; // Izquierda
                        case 'R': newY++; break; // Derecha
                    }

                    // Verificar colisión con las paredes
                    if (newX < 0 || newX >= 21 || newY < 0 || newY >= 21) {
                        collision = true;
                        break;
                    }

                    // Verificar colisión con el cuerpo de la serpiente
                    for (int j = 0; j < length; j++) {
                        if (snakeX[j] == newX && snakeY[j] == newY) {
                            collision = true;
                            break;
                        }
                    }

                    if (collision) break;

                    // Mover la serpiente
                    headX = newX;
                    headY = newY;

                    // Añadir nueva cabeza
                    for (int j = length; j > 0; j--) {
                        snakeX[j] = snakeX[j - 1];
                        snakeY[j] = snakeY[j - 1];
                    }
                    snakeX[0] = headX;
                    snakeY[0] = headY;

                    // Si la longitud de la serpiente es mayor que el tiempo, eliminar la cola
                    if (time % 10 == 0) {
                        length++; // Crecer la serpiente
                    }

                    // Eliminar la cola
                    if (time > length) {
                        board[snakeX[length]][snakeY[length]] = 0; // Desmarcar la posición
                    }
                }

                if (collision) break; // Si hay colisión, salir del bucle
            }

            // Si no hay colisión, continuar moviendo la serpiente
            while (!collision) {
                time++;
                lastTime = time;

                // Mover la cabeza de la serpiente
                int newX = headX, newY = headY;

                // Actualizar la posición según la última dirección
                switch (direction) {
                    case 'U': newX--; break; // Arriba
                    case 'D': newX++; break; // Abajo
                    case 'L': newY--; break; // Izquierda
                    case 'R': newY++; break; // Derecha
                }

                // Verificar colisión con las paredes
                if (newX < 0 || newX >= 21 || newY < 0 || newY >= 21) {
                    collision = true;
                    break;
                }

                // Verificar colisión con el cuerpo de la serpiente
                for (int j = 0; j < length; j++) {
                    if (snakeX[j] == newX && snakeY[j] == newY) {
                        collision = true;
                        break;
                    }
                }

                if (collision) break;

                // Mover la serpiente
                headX = newX;
                headY = newY;

                // Añadir nueva cabeza
                for (int j = length; j > 0; j--) {
                    snakeX[j] = snakeX[j - 1];
                    snakeY[j] = snakeY[j - 1];
                }
                snakeX[0] = headX;
                snakeY[0] = headY;

                // Si la longitud de la serpiente es mayor que el tiempo, eliminar la cola
                if (time % 10 == 0) {
                    length++; // Crecer la serpiente
                }

                // Eliminar la cola
                if (time > length) {
                    board[snakeX[length]][snakeY[length]] = 0; // Desmarcar la posición
                }
            }

            // Imprimir el último instante en que la serpiente pudo avanzar
            System.out.println(lastTime);

            // Leer el siguiente número de movimientos
            N = scanner.nextInt();
        }

        scanner.close(); // Cerrar el escáner al final
    }
}*/