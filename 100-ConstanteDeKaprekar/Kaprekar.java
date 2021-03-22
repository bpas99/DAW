public class Kaprekar 
{

    static java.util.Scanner entrada;

    public static void main(String[] args) {
        entrada = new java.util.Scanner(System.in);
        int casos, num,iteraciones, kapkrekar, x, y;
        casos = entrada.nextInt();
        for(int i=0; i<casos; i++) {
            casoPrueba();
        }
    }

    public static void casoPrueba()
    {
        int iteraciones, num, x, y, kaprekar;
        iteraciones = 1;
        num = entrada.nextInt();
        if(num == 6174) {
            iteraciones = 0;
        } 
        else if(num == 0) {
            iteraciones = 8;
        } 
        else {
            while(num < 1000) {
                num *= 10;
            }

            x = ordenDescendente(num);
            y = ordenAscendente(num);

            kaprekar = x - y;

            if(kaprekar == 0) {
                iteraciones = 8;
            } 
            else {
                while (kaprekar != 6174 && iteraciones < 8) {
                    iteraciones++;
                    x = ordenDescendente(kaprekar);
                    while(x < 1000) {
                        x *= 10;
                    }
                    y = ordenAscendente(kaprekar);
                    kaprekar = x - y;
                }
            }
        }

        System.out.println(iteraciones);
    }

    public static int ordenAscendente(int num) 
    {
        int digito = 0;
        int aux = 0;
        int ordenado = 0;
        for(int i=0; i<=9; i++) {
            aux = num;
            while(aux > 0) {
                digito = aux % 10;
                if(digito == i) {
                    ordenado = (ordenado * 10) + digito;
                }
                aux /= 10;
            }
        }
        return ordenado;
    }

    public static int ordenDescendente(int num) 
    {
        int digito = 0;
        int aux = 0;
        int ordenado = 0;
        for(int i=9; i>=0; i--) {
            aux = num;
            while(aux > 0) {
                digito = aux % 10;
                if(digito == i) {
                    ordenado = (ordenado * 10) + digito;
                }
                aux /= 10;
            }
        }
        return ordenado;
    }
}