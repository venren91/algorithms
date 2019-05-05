package dp;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 */
public class LongestCommonSubSequence {

    public int execute(String str1, String str2){
        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] dp = new int[str1Len+1][str2Len+1];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<=str1Len; i++){
            for(int j=0; j<= str2Len; j++){
                if( i == 0 || j ==0 ){
                    dp[i][j] = 0;
                }else if(str1Arr[i-1] == str2Arr[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]) ;
                }

                maxLen = (dp[i][j] > maxLen) ?  dp[i][j] : maxLen;

            }
        }

        printDp(str1,str2,dp);

        return maxLen;
    }

    private void printDp(String str1, String str2, int[][] dp) {
        //print first row with string
        for(int i=0; i < str2.length()+1; i++){
            if(i ==0 ) {
                System.out.print("\t" + 0 + "\t");
                continue;
            }
            System.out.print(str2.charAt(i-1) + "\t");
        }
        //next line
        System.out.println();

        //print dp solution matrix
        for(int i=0; i< str1.length()+1; i++){
            for(int j=0; j<str2.length()+1; j++){
                if(i ==0 && j== 0){
                    System.out.print(0 + "\t");
                } else if(j == 0){
                    System.out.print(str1.charAt(i-1) + "\t");
                }

                System.out.print(dp[i][j] + "\t");
            }
            //next line
            System.out.println();
        }

        //next line
        System.out.println();
        System.out.println("*****end of dp **********");
    }

    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";

        System.out.println("Length of longest common sequence: " + new LongestCommonSubSequence().execute(s1,s2));
    }
}
