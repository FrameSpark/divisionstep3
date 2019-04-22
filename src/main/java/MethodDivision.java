public class MethodDivision {
    private double eps;
    private double alpha;
    double x0[];
    double x1[];

    public MethodDivision(double eps, double alpha, int n, double[] x0) {
        this.eps = eps;
        this.alpha = alpha;
        this.x0 = x0;
        this.x1 = new double[n];
    }

    public void solve(){
        boolean solved = false;
        int iter=0;
        double valueGrad[];
        while(!solved){
            valueGrad = valueGrad(x0);
            if(normGrad(x0) > eps){
                //alpha * grad(x0)
                double[] temp = mul(alpha, valueGrad);
                x1 = sub(x0,temp);
                if(valueFunc(x1) < valueFunc(x0)){
                    x0 = x1;
                }
                else {
                    iter++;
                    alpha = alpha / 2;
                }
            }
            else {
                solved = true;
                System.out.print("Найденная точка: "  );
                pr(x0);
                System.out.println("Значение функции в точке: " + valueFunc(x0));
                System.out.println("Количество итераций: " + iter);
            }
        }

    }

    private double valueFunc(double x[]){
        return 2*Math.pow(x[0],2)+Math.pow(x[1],2);
        //return 2*Math.pow(x[0],2)+Math.pow(x[1],2)+x[0]*x[1];
    }

    private double[] valueGrad(double x[]){
        double temp[] = new double[x.length];

        temp[0] = 4*x[0];
        temp[1] = 2*x[1];


        /*
        temp[0] = 4*x[0]+x[1];
        temp[1] = 2*x[1]+x[0];

         */
        return temp;
    }

    private double normGrad(double x[]){
        double sum=0;
        sum +=Math.pow(4*x[0],2) + Math.pow(2*x[1],2);
        //sum += Math.pow(4*x[0]+x[1],2)+Math.pow(2*x[1]+x[0],2);
        return Math.sqrt(sum);
    }

    private double[] mul(double mn, double x[]){
        double temp[] = new double[x.length];
        for(int i=0; i<x.length;i++){
            temp[i] = x[i]*mn;
        }
        return  temp;
    }

    private double[] sub(double[]x , double[]y){
        double []temp = new double[x.length];
        for(int i=0; i<x.length;i++){

             temp[i] = x[i] - y[i];
        }
        return temp;
    }

    private void pr(double x[]){
        for (int i=0; i<x.length;i++){
            System.out.print(" " + x[i] + ";");
        }
        System.out.println();
    }
}
