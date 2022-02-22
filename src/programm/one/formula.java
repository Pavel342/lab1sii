package programm.one;

public class formula {
    public static void main(String[] args) {
        float net = 0;
        int[] y = new int[16];
        float f;
        float nn = 0.5F;//норма обучения
        int k = 0;//эпоха
        float[] w = new float[]{0, 0, 0, 0, 0};
        int[][] x = {{1, 0, 0, 0, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 1}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}, {1, 0, 1, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {1, 1, 0, 1, 0}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 0}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};
        int[] otveti = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1};
        int be;
        int sumMis;
        boolean kaif = true;
        do {
            sumMis = 0;
            System.out.println("Эпоха номер " + k);
            System.out.println();
            k++;
            for (int i=0; i < 16; i++) {

                for (int j = 1; j <= 4; j++) {
                    net += w[j] * x[i][j];
                }
                net += w[0];
                f = (float) (1 / (1 + Math.E * (-1 * net)));
                if (f >= 0.5) y[i] = 1;
                else y[i] = 0;
                be =  otveti[i]-y[i] ;
                if (y[i] == otveti[i])  ;
                else {
                    sumMis++;
                    kaif = false;
                    smena(w, be, nn, x, i, f);
                }
                if (!kaif) System.out.println("Не верно");
                else System.out.println("Верно");
                kaif = true;
                net=0;
            }
            System.out.println("Ошибок:" + sumMis);

        } while (sumMis != 0);

    }

    public static float[] smena ( float[] w, int be, float nn, int[][] x, int l, float f){
        for (int i = 0; i < 5; i++) {
            w[i] = w[i]+ f*(1-f) * nn * be * x[l][i];
        }
        return w;
    }
}
