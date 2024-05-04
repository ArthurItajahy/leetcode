import java.util.Arrays;

public class BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int l = 0;
        int r = people.length - 1;

        while(l<=r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
            }else{
                r--;
            }
            boats++;
        }
        return boats;
    }
}