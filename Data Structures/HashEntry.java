/**
 * Created by nisarg on 9/22/15.
 */
public class HashEntry {
    int key;
    int value;
    HashEntry(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }
}
