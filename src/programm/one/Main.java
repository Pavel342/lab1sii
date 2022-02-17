package programm.one;

public class Main {

    public static void main(String[] args) {
        float net = 0;
        int[] y = new int[16];
        float f = 0F;
        float nn = 0.5F;//норма обучения
        int k = 0;//эпоха
        int l ;//щаг обучения
        float[] w = new float[]{0, 0, 0, 0, 0};
        int[] x = new int[]{1, 0, 0, 0, 0};
        int[] otveti = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1};
        float[] ww = new float[]{0, 0, 0, 0, 0};
        int be;
        boolean kaif;
        do {

            for (int i = 0; i < 16; i++) {
                for (int j = 1; j <=4; j++) {
                    net += w[j] * x[j] + w[0];
                }
                f = (float) (1 / (1 + Math.E * (-1 * net)));
                if (f >= 0.5) y[i] = 1;
                else y[i] = 0;
            }

            for ( l = 0; l<16;) {
                if (y[l] == otveti[l]) {
                    l++;
                    for (int i = 0; i < 5; i++) {
                        w[i] = w[i] + ww[i];
                    }
                } else {
                    be = otveti[l] - y[l];
                    if (l == 0) {
                        for (int i = 0; i < 5; i++) {
                            ww[i] = nn * be * x[i];
                        }
                    } else {
                        for (int i = 0; i < 5; i++) {
                            ww[i] = nn * be * (f * (1 - f)) * x[i];
                        }
                    }
                }
            }
            k++;
            kaif=true;
            for(int jj = 0; jj<16; jj++)if(otveti[jj]!=y[jj]) {kaif=false;break;}
        }while (!kaif);
        System.out.println("Эпоха номер"+k);
    }

}
