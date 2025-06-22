package solved;

public class JumpingOnClouds {

    public static void main(String[] args) {

        System.out.println(jumpingOnClouds(new int[]{1 ,1 ,1 ,0 ,1 ,1 ,0 ,0 ,0 ,0}, 3));

    }
    static int jumpingOnClouds(int[] c, int k) {

        int energy = (c[0] == 0) ? 99 : 97;
        int idx = 0;

        while((idx + k) % c.length != 0){
            idx += k;

            if(c[idx % c.length] == 0){
                energy--;
            } else {
                energy -= 3;

            }
        }
        return energy;
    }
}
