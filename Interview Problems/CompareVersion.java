/**
 * Created by nisarg on 10/26/15.
 */
public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null)
            return 0;
        if(version1 == null)
            return -1;
        if(version2 == null)
            return 1;

        String[] v1 = version1.toString().split("\\.");
        String[] v2 = version2.toString().split("\\.");
        for(int i = 0; i < Math.min(v1.length, v2.length); i++) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]))
                return 1;
            else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]))
                return -1;
        }
        if(v1.length > v2.length){
            for(int j = v2.length; j < v1.length; j++){
                if(Integer.parseInt(v1[j]) > 0)
                    return 1;
            }
            return 0;
        }else if(v1.length < v2.length){
            for(int j = v1.length; j < v2.length; j++){
                if(Integer.parseInt(v2[j]) > 0)
                    return -1;
            }
            return 0;
        }else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1.1"));
        System.out.println(compareVersion("1.0", "1"));
        System.out.println(compareVersion("1", "1.0.1"));
        System.out.println(compareVersion("1.1.0", "1.1"));
        System.out.println(compareVersion("1.1.1", "1.1"));

    }
}
