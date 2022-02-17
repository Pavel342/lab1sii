package programm.one;

public class Main {

    public static void main(String[] args) {
	float net=0;
    int y;
    float f;
    float nn= 0.5F;//норма обучения
    int k=1;//эпоха
         int l=0;//щаг обучения
    int[] w=new int[]{0,0,0,0,0};
    int[] x=new int[4];
    int[] otveti= new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1}


    for(int i=1;i<5;i++){
        net+=w[i]*x[i]+w[0];
    }
    f= (float) (1/(1+Math.E*(-1*net)));
    if(f>=0.5) y=1;
    else y=0;


    }
}
