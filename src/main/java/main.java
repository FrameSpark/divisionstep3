public class main {
    public static void main(String[] args) {
        double x0[] = {0.5,1};
        //пример  2*x1^2+x2^2
        MethodDivision md = new MethodDivision(0.01,1,2,x0);
        md.solve();

        //Пример 2*x1^2+x2^2+x1*x2
       // MethodDivision md = new MethodDivision(0.4,1,2,x0);
       // md.solve();
    }
}
