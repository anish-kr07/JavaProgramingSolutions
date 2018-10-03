import java.util.*;

// Java program to print all permutations of a
// given string.
public class StringPermutation
{
//{   String str1[] = new String[10];
    List<String > list = new ArrayList<>();
    Set<String> set= new HashSet<>();
    Set<String> treeSet = new TreeSet<>();
//    int k =0;
    public static void main(String[] args)
    {
        String str = "AAC";
        int n = str.length();
        StringPermutation permutation = new StringPermutation();
        permutation.permute(str, 0, n-1);
        permutation.printList();
        permutation.printSet();
        permutation.printTreeSet();
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r){
            list.add(str);
            set.add(str);
            treeSet.add(str);
        }

        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private void printList(){
        System.out.println(list);
    }
    private void printSet(){
        System.out.println(set);
    }
    private void printTreeSet(){
        System.out.println(treeSet);
    }

}
