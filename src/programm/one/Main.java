package programm.one;

public class Main {
    public static void main(String[] args) {
        float net = 0;
        int[] y = new int[16];
        float f = 0F;
        float nn = 0.5F;//норма обучения
        int k = 0;//эпоха
        int l = 0;//шаг обучения
        float[] w = new float[]{0, 0, 0, 0, 0};
        int[][] x = {{1, 0, 0, 0, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 1}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}, {1, 0, 1, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {1, 1, 0, 1, 0}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 0}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};
        int[] otveti = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1};
        float[] ww = new float[]{0, 0, 0, 0, 0};
        int be;
        int sumMis = 0;
        boolean kaif = true;
        do {
            sumMis = 0;
            l=0;
            k++;
            for (; l < 16; l++) {

                for (int j = 1; j <= 4; j++) {
                    net += w[j] * x[l][j];
                }
                net += w[0];
                if (net >= 0) y[l] = 1;
                else y[l] = 0;
                be =  otveti[l]-y[l] ;
                if (y[l] == otveti[l]) ;
                else {
                    sumMis++;
                    kaif = false;
                    smena(w, be, nn, x, l);
                }
                if (!kaif) System.out.println("Не верно");
                else System.out.println("Верно");
                kaif = true;
                //f = (float) (1 / (1 + Math.E * (-1 * net)));
                // if (f >= 0.5) y[i] = 1;
                // else y[i] = 0;
            }
            System.out.println("Ошибок:" + sumMis);
            System.out.println("Эпоха номер" + k);


        } while (sumMis != 0);

    }






            /*for ( l = 0; l<16;) {
                if (y[l] == otveti[l]) {
                    l++;
                    for (int i = 0; i < 5; i++) {
                        w[i] = w[i] + ww[i];
                    }
                } else {
                    be = otveti[l] - y[l];
                    if (l == 0) {
                        for (int i = 0; i < 5; i++) {
                            ww[i] = nn * be * x[l][i];
                        }
                    } else {
                        for (int i = 0; i < 5; i++) {
                            ww[i] = nn * be * (f * (1 - f)) * x[l][i];
                        }
                    }
                    l++;
                }
            }
            k++;
            kaif=0;
            for(int jj = 0; jj<16; jj++)if(otveti[jj]!=y[jj]) kaif++;
            System.out.println("Ошибок:"+kaif);
        }while (kaif!=0);
        System.out.println("Эпоха номер"+k);*/


        public static float[] smena ( float[] w, int be, float nn, int[][] x, int l){
            for (int i = 0; i < 5; i++) {
                w[i] = w[i] + nn * be * x[l][i];
            }
            return w;
        }



}