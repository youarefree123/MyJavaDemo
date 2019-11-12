package Basic;

public class AverageScore {
    public static void main(String[] args) {
        int [] ages = {61,57,95,85,75,65,44,66,90,32};
        int sum = 0;
        for(int i : ages){
            sum += i;
        }
        double ave = 0;
        ave = (sum*1.0)/ages.length;
        System.out.println(ave);
     }
}
