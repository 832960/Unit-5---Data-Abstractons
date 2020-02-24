import java.util.ArrayList;

public class IntegerSet {

    ArrayList<Integer> nums;

    IntegerSet() {

        nums = new ArrayList<>();

    }

    //Requires: Int
    //Modifies: This
    //Effects: Inserts integer into the set unless the number it's already there, in which case do nothing
    public void insert(Integer num) {

        if (!nums.contains(num)) {

            nums.add(num);

        }

    }

    //Requires: Int
    //Modifies: This
    //Effects: If the integer is in the set remove it, otherwise do nothing
    public void remove(Integer num) {

        nums.remove(num);

    }

    //Effects: Returns size of the set
    public int size() {

        return nums.size();

    }

    //Effects: checks if the integer is in the set
    public boolean contains(Integer num) {

        return nums.contains(num);

    }

}
