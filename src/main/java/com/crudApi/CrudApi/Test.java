package com.crudApi.CrudApi;

import java.math.BigInteger;
import java.util.*;


public class Test {

    static long xorSequence(long l, long r) {

            long next=0;
            long ans=0;
            for(long i=1;i<=r;i++){
                next=i^next;

                if(i>=l){
                    ans=next^ans;
                }
            }
            return ans;
    }

    static long theGreatXor(long x) {
        int va=1;
        String s= Long.toBinaryString(x);
        return (1<<s.length())-x-1;

    }
    static int sansaXor(int[] arr) {
        if(arr.length%2==0)
            return 0;
        else {
            int ans=arr[0];
            for(int i=2;i<arr.length;i+=2){
                ans^=arr[i];
            }
            return ans;
        }
    }
    static void whatsNext(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            char[] ch = new char[arr[i]];
            if (i % 2 == 0) {
                Arrays.fill(ch, '1');
                sb.append(ch);
            } else {
                Arrays.fill(ch, '0');
                sb.append(ch);
            }
        }
        int index=sb.substring(0,sb.lastIndexOf("1")).lastIndexOf("0");
        char c[]=sb.toString().toCharArray();

        if(index==-1){
            String s="10";
            StringBuilder sx=new StringBuilder();
            sx.append(s);
            sx.append(sb.substring(1));
            sb=sx;
            c=sb.toString().toCharArray();
        }
        else {
        char ch=c[index];
        c[index]=c[index+1];
        c[index+1]=ch;
        }
        sb=new StringBuilder();
        int count=0;
        char x='1';
        for(char cx:c){
            if(cx==x)
                count++;
            else{
                System.out.print(count+" ");
                count=1;
                x=cx;
            }
        }
        System.out.println(count);
    }
    static String isBalanced(String s) {
        Stack<Character> sc=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='{'||c=='('||c=='[')
                sc.push(c);
            else if(sc.peek() =='(' && c==')'){
                sc.pop();
            }
            else if(sc.peek() =='{' && c=='}'){
                sc.pop();
            }else if(sc.peek() =='[' && c==']'){
                sc.pop();
            }
            else sc.push(c);
        }

        return sc.isEmpty()?"YES":"NO";
    }
    static int flatlandSpaceStations(int n, int[] c) {
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            int max=n;
            for(int j=0;j<c.length;j++){

                max=Math.abs(i-c[j])<max?Math.abs(i-c[j]):max;
            }
            a[i]=max;
        }
        for(int i:c){
            a[i]=0;
        }
        Arrays.sort(a);
        int max=0;
        for(int i=0;i<n;i++){
            if(a[i]!=0){
                max=a[i];
                break;
            }
        }
        return a[n-1];
    }
    static int fairRations(int[] B) {
        int count=0;
        boolean turn=true;
        for(int i=0;i<B.length-1;i++){
            if(B[i]%2==0){
                if(turn){
                    B[i]+=1;
                    B[i+1]+=1;
                    i++;
                    count+=2;
                    turn=false;
                }
                else {
                    B[i]+=1;
                    B[i-1]+=1;
                    i++;
                    count+=2;
                    turn=true;
                }
            }
        }

        return count;
    }
    static int[] jimOrders1(int[][] orders) {


        List<Integer> aak=new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            int sum=orders[i][0]+orders[i][1];
            aak.add(sum);
        }
            List<Integer> aa=new ArrayList<>(aak);
        Collections.sort(aa,Collections.reverseOrder());
        Set<Integer> ss=new LinkedHashSet<>(aa);
        Iterator it=ss.iterator();
        int x[]=new int[orders.length];
        int l=orders.length;
        while (it.hasNext()){
            int tem= (int)it.next();
            for(int i=0;i<aak.size();i++){
                if(aak.get(i)==tem)
                    x[--l]=i+1;
            }
        }

        return x;
    }

    public static void main(String[] args)  {
        System.out.println(jimOrders1(new int[][]{{8,2},{4,2},{5,5},{3,1},{4,3}}));

    }

    static int solve(int[] a) {

        int count=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j])
                    count++;
                else break;
            }
        }
        return count*2;
    }

    static String isValid(String x) {
        List<Character> clist=new ArrayList<>();
        for(char c:x.toCharArray())
            clist.add(c);
        Set<Character> c=new TreeSet<>(clist);
        Iterator it=c.iterator();
        int odd=0;
        int marker=Collections.frequency(clist,it.next());
        while(it.hasNext()){
            int next=Collections.frequency(clist,it.next());
            if(next==marker) continue;
            else if( Math.abs(next-marker)<2 && odd!=1)
                odd++;
            else {
                return "NO";
            }
        }
        return "YES";
    }

    static String twoStrings(String s1, String s2) {
        Set<Character> c1=new TreeSet<>();
        for(char c:s1.toCharArray())
            c1.add(c);
        Set<Character> c2=new TreeSet<>();
        for(char c:s2.toCharArray())
            c2.add(c);
        int len=c1.size();
        c1.retainAll(c2);
        if(c1.size()!=0)
            return "YES";

        return "NO";

    }
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        long min=arr[arr.length-1];
        List<Integer> il=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            long diff=arr[i+1]-arr[i];
            if(min>diff){
                il.clear();
                min=diff;
                il.add(arr[i]);
                il.add(arr[i+1]);
            }
            else if(min==diff){
                il.add(arr[i]);
                il.add(arr[i+1]);

            }
            System.out.println(min);
        }
        int a[]=new int[il.size()];
        for(int i=0;i<a.length;i++){
            a[i]=il.get(i);
        }
        return a;


    }
    static int stringConstruction(String s) {
        Set<Character> se=new TreeSet<>();
        int step=0;
        for(char c:s.toCharArray()){
            if(se.add(c)) step++;
        }
    return step;
    }

    static String gameOfThrones(String s) {
        List<Character> c=new ArrayList<>();
        char[] cx=s.toCharArray();
        for(char ch:cx){
            c.add(ch);
        }
        int odd=0;
        Set<Character> cset=new TreeSet<>(c);
        Iterator it=cset.iterator();
        while(it.hasNext()){
            if(Collections.frequency(c,it.next())%2!=0)
                odd++;

        }
        if(odd==0|| odd==1)
            return "YES";
        else return "NO";
    }
    static String happyLadybugs(String b) {
        List<Character> c=new ArrayList<>();
        for(char ch:b.toCharArray()){
            if(ch!='_')
                c.add(ch);
        }

        Set<Character> cs=new TreeSet<>(c);
        Iterator<Character> it=cs.iterator();
        while (it.hasNext()){
            if( Collections.frequency(c,it.next())<2)
                return "NO";
        }
        return "YES";
    }

    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        if(p>s) return 0;
        int sum=0,count=0;
        while(p>m && p<s-sum){
            sum+=p;
            p-=d;
            count++;
        }
        if(p>s-sum) return count;


        return (count+(s-sum)/m);
    }


    static int beautifulTriplets(int d, Integer[] arr) {
        int tripletsCount=0;
        List<Integer> ss=Arrays.asList(arr);
        for(int i=0;i<arr.length;i++){
            int x=0;
            int sum=arr[i];
            while(x<2){
                if(ss.contains(sum+d)){
                    sum+=d;
                    x++;
                }
                else break;
            }
            if(x==2)
                tripletsCount++;

        }
        return tripletsCount;
    }

    static void kaprekarNumbers(int p, int q) {
        StringBuilder sb=new StringBuilder();
        for(int i=p;i<=q;i++){

            long sq=(long)Math.pow(i,2);
            String s=String.valueOf(sq);
            int len=s.length();
            if(len%2!=0){ s="0"+s;
                len++;
            }
            int half =len/2;
            String l=s.substring(0,half);
            String r=s.substring(half,len);
            int sum= Integer.parseInt(l)+Integer.parseInt(r);
            if(sum==i){
                sb.append(i+" ");
            }
        }
        if(sb.toString().length()==0) System.out.println("INVALID RANGE");
        else System.out.println(sb.toString());
    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here

        if(bc-wc>z){
            return (long)((w*wc)+((wc+z)*b));
        }
        else  if(wc-bc>z){
            return (long)((b*bc)+ ((bc+z)*w));
        } else {
            return (long)((b*bc)+(wc*w));
        }

    }
    static int[] acmTeam(String[] topic) {
        int a[]=new int[2];
        BigInteger b[]=new BigInteger[topic.length];
        for(int i=0;i<topic.length;i++){
            b[i]=new BigInteger(topic[i],2);
        }
        int max=0,maxCount=0;
        for(int i=0;i<topic.length-1;i++){
            for(int j=i+1;j<topic.length;j++){
                int count=b[i].or(b[j]).bitCount();
                if(max<count){
                    max=count;
                    maxCount=1;
                }
                else if(max==count){
                    maxCount++;
                }
            }
        }
        a[0]=max;
        a[1]=maxCount;
        return a;
    }

    static long repeatedString(String s, long n) {
        long count=0;
        for(char c:s.toCharArray()){
            if(c=='a') count++;
        }
        long div=n/s.length();
        long remain=n%s.length();
        count*=div;
        for(int i=0;i<remain;i++){
            if(s.charAt(i)=='a')count++;
        }
        return count;

    }
    static String morganAndString(String a, String b) {
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        while(i!=a.length() && j!=b.length()){
            if(a.charAt(i)<b.charAt(j)){
                sb.append(a.charAt(i));
                i++;
                continue;
            }
            if(a.charAt(i)>b.charAt(j)){
                sb.append(b.charAt(j));
                j++;
                continue;
            }
            if(a.charAt(i)==b.charAt(j)){
                if(i<j) {
                    sb.append(a.charAt(i));
                    i++;
                    continue;
                }
                else {
                    sb.append(b.charAt(j));
                    j++;
                    continue;
                }
            }
        }

        if(i==a.length()) sb.append(b.substring(j));
        else sb.append(a.substring(i));

        return sb.toString();
    }

    static int anagram(String s) {
        if(s.length()%2!=0) return -1;
        int len=s.length();
        int count=0;
        String s1=s.substring(0,len/2);
        String s2=s.substring(len/2,len);
        int i=0;
        for(;i<len/2;i++){
            if(s2.contains(Character.toString(s1.charAt(i)))){
                String tem=Character.toString(s1.charAt(i));
                s2= s2.replaceFirst(tem,"");
            }
            else count++;
        }

        return count;
    }
    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> set=new TreeSet();
        int x=0;
        char old='X';
        for(char c:s.toCharArray()) {
            if (c == old) {
                x += old - 'a' + 1;;
                set.add(x);
            } else {
                old = c;
                x = old - 'a' + 1;
                set.add(x);

            }
        }
        String[] ans=new String[queries.length];
        for(int i=0;i<queries.length;i++){
            if(set.contains(queries[i])) ans[i]="YES";
            else ans[i]="NO";
        }
        return ans;
    }

    static int theLoveLetterMystery(String s) {
        int ans=0;
        char c[]=s.toCharArray();
        for(int i=0;i<Math.ceil(c.length/2);i++){
            ans=ans+Math.abs(c[i]-c[c.length-i-1]);
        }
        return ans;

    }

    static String caesarCipher(String s, int k) {
        k=k%26;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            boolean upper=Character.isUpperCase(c);
            if(Character.isAlphabetic(c)){

                char temp= (char) (Character.toLowerCase(c)+k);
                if(Character.isAlphabetic(temp)) sb.append(upper?Character.toUpperCase(temp):Character.toLowerCase(temp));
                else sb.append(upper?Character.toUpperCase((char)('a'+(k-1)-('z'-Character.toLowerCase(c)))):Character.toLowerCase((char)('a'+(k-1)-('z'-Character.toLowerCase(c)))));

            }
            else sb.append(c);
        }
        return sb.toString();
    }
    static String balancedSums(List<Integer> arr) {

        int count=arr.get(0);
        int  sum=0;
        for(int i:arr) sum+=i;
        if(sum-count==0) return "YES";
        for(int i=1;i<arr.size();i++){
            if(sum-arr.get(i)-count==count || sum-arr.get(i)==0)
                return "YES";
            count+=arr.get(i);
        }
        return "NO";

    }
    static int[] icecreamParlor(int m, int[] arr) {
        int ans[]=new int[2];
        for(int i=0;i<arr.length;i++){
            boolean breaker=false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==m )
                {   ans[0]=i+1;
                    ans[1]=j+1;
                    breaker=true;
                    break;
                }
            }
            if(breaker) break;
        }
        Arrays.sort(ans);
        return ans;
    }

    static int beautifulBinaryString(String b) {
        int index=0;
        while(b.contains("010")){
            b=b.replaceFirst(
                    "010","011");
            index++;
        }
        return index;
    }
    static int superDigit(String n, int k) {
        String s=new String(new char[k]).replace("\0", n);
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans+=Character.getNumericValue(s.charAt(i));
        }
        //ans+=ans;
        if(ans<10)
            return ans;
        else
            return superDigit(String.valueOf(ans),1);


    }
    static long strangeCounter(long t) {
        int ini=3;int count=1;
        long i=ini;
        while(count!=t){

            if(i==1) {
                ini=ini*2;
                i=ini;
                count++;
            }
            else {
                i--;
                count++;
            }
        }
        return i;

    }
    static int[] permutationEquation(Integer[] p) {
        int a[]=new int[p.length];
        List<Integer> il=Arrays.asList(p);
        for(int i=1;i<=p.length;i++){
            int temp=il.indexOf(i);
            a[i-1]=il.indexOf(temp+1)+1;
        }
        return a;
    }
    static int minimumAbsoluteDifference(int[] arr) {
        int min=Math.abs(arr[0]-arr[1]);
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++){
                int temp=Math.abs(arr[i]-arr[j]);
                if(min>temp) min=temp;
            }
        }
        return min;
    }
    static int[] jimOrders(int[][] orders) {
        List<Integer> i1=new ArrayList<>();
        List<Integer> i2=new ArrayList<>();

        for(int i=0;i<orders.length;i++){

        }
        return null;
    }
    static long marcsCakewalk(Integer[] calorie) {
        List<Integer> ilist=Arrays.asList(calorie);
        Collections.sort(ilist,Collections.reverseOrder());
        double ans=0;
        for(int i=0;i<ilist.size();i++){
            ans=ans+(Math.pow(2,i)*ilist.get(i));
        }
        return (long)ans;
    }

    static String twoArrays(int k, Integer[] A, Integer[] B) {
        List<Integer> alist=Arrays.asList(A);
        List<Integer> blist=Arrays.asList(B);
        Collections.sort(alist);
        Collections.sort(blist,Collections.reverseOrder());
        Map<Integer,Integer> mmi=new HashMap<>();
        int count=0;
        for(int i=0;i<A.length;i++){
            System.out.println(alist.get(i)+" "+blist.get(i));
            if(alist.get(i)+blist.get(i)>=k)count++;

        }
        return (count==alist.size()) ? "yes":"no";
    }

    static int toys(Integer[] w) {
        Arrays.sort(w);
        List<Integer> ilist=Arrays.asList(w);
        int containerCount=1;
        int min=Collections.min(ilist);
        for(int i=0;i<w.length;i++){
            if(w[i]<=min+4){

            }
            else{
                min=Collections.min(ilist.subList(i,ilist.size()));
                containerCount++;
            }
        }
        return containerCount;

    }

    static int maximumToys(int[] prices, int k) {
        int count=0,amount=0;
        Arrays.sort(prices);
        int i=0;
        while(prices[i]<k-amount){
            amount+=prices[i];
            count++;
            i++;
        }
        return count;
    }

    static String counterGame(long n) {
        int i=0;
        while(n>0){

            if((n&(n-1))==0){
                n/=2;
            }else{
                n-=getNextPowerOfTwo(n);
            }

            i=i==0?1:0;
        }
        return i==0?"l":"r";

    }
    static double getNextPowerOfTwo(long n){
        int count=0;
        while(n>1){
            n>>=1;
            count++;
        }
        return Math.pow(2,count);
    }
    static int[] countingSort(int[] arr) {


        int ann[]=new int[arr.length];
        int ans[] =new int[100];
        for(int i:arr){
            ans[i--]++;
        }
        int i=0,k=0;
        while(i<100){
            if(ans[i]!=0){
                for(int j=0;j<ans[i];j++){
                    ann[k]=i;
                    k++;
                }
            }
            i++;
        }
        return ans;

    }

    static int[] quickSort(int[] arr) {
        int left[]=new int[arr.length-1],l=0;
        int right[]=new int[arr.length-1],r=0;
        int middle[]=new int[arr.length-1],m=1;

        middle[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(middle[0]==arr[i]) {
                middle[m]=arr[i];
                m++;
            }
            if(middle[0]>arr[i]) {
                left[l]=arr[i];
                l++;
            }
            if(middle[0]<arr[i]) {
                right[r]=arr[i];
                r++;
            }
        }
        int a[]=new int[arr.length],a1=0;
        for(int i=0;i<a.length-1;i++){
            if(left[i]==0) break;
            a[a1]=left[i];
            a1++;
        }
        for(int i=0;i<a.length-1;i++){
            if(middle[i]==0) break;

            a[a1]=middle[i];
            a1++;
        }
        for(int i=0;i<a.length-1;i++){
            if(right[i]==0) break;
            a[a1]=right[i];
            a1++;
        }

        return a;

    }

    static void insertionSort2(int n, int[] arr) {
        for( int i=1;i<n;i++){
            int k=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>k){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=k;
            for (int l:arr)
                System.out.print(l+" ");
            System.out.println();
        }

    }

    static int[] serviceLane(int n, int[][] cases,int[] width) {
        int x[]=new int[cases.length];
        for(int i=0;i<cases.length;i++){
            int start=cases[i][0];
            int end = cases[i][1];
            int min=Arrays.stream(width).max().getAsInt();
            for(int j=start;j<=end;j++){
                min=min>width[j]?width[j]:min;
            }
            x[i]=min;
        }
        return x;
    }

    static int squares(int a, int b) {
        List<Integer> il=new ArrayList<>();
        double sb=0;
        for(int i=a;i<=b;i++){
            sb=Math.sqrt(i);
            if(sb==Math.floor(sb)){
                il.add((int)sb);
                sb=(int)sb ;
                break;
            }
        }
        sb++;
        while(Math.pow(sb,2)<=b){
            il.add((int)sb);
            sb++;
        }
        return il.size();
    }

    static int minimumDistances(int[] a) {
        int min=a.length;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j])
                    min=Math.abs(i-j)<min?Math.abs(i-j):min;
            }
        }
        return min!=a.length?min:-1;
    }

    static int equalizeArray(int[] arr) {
        Map<Integer,Integer> iim=new HashMap<>();
        for(int i:arr)
            if(iim.containsKey(i)) iim.put(i,iim.get(i)+1);
            else iim.put(i,1);
        int max=Collections.max(iim.values());
        return arr.length-max;

    }

    static Integer[] cutTheSticks(int[] arr) {
        List<Integer> integers=new ArrayList<>();
        for(int i:arr)
            integers.add(i);
        List<Integer> ans=new ArrayList<>();
        while(integers.size()!=0)
        {
            int min= Collections.min(integers);
            int len=integers.size();
            ans.add(len);
            for(int i=0;i<len;i++){
                int temp=integers.remove(0);
                if(temp-min!=0) integers.add(temp-min);
            }

        }

        return ans.stream().toArray(Integer[]::new);
    }

    static int jumpingOnClouds(int[] c, int k) {
        int energy=100,i=0,n=c.length;
        while (energy!=0){
            i=(i+k)%n;

            int tep=c[i];
            if(tep==0)
                energy--;
            else energy-=3;
            if(i==0) break;
        }
        return energy;
    }

    static long arrayManipulation(int n, int[][] queries) {
        int a[]=new int[n];

        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int inc=queries[i][2];
            for(int j=start;j<=end;j++){
                a[j]+=inc;
            }

        }
        Arrays.sort(a);
        return a[n-1];
    }
    static  int[] rotateLeftByK(int[] a, int k){
            int len=a.length;

            int[] te =new int[k];
            for(int i=0,temp=0;i<k;i++){
                te[i]=a[temp++];
            }

            for(int i=0;i<len-k;i++)
                a[i]=a[i+k];

            for(int i=len-1,x=te.length;x>0;i--){
                a[i]=te[--x];
            }
            return a;

    }

    static int[] rotateRightByK(int[] a, int k){
        int len=a.length;

        int[] te =new int[k];
        for(int i=te.length-1,temp=len;i>=0;i--){
            te[i]=a[--temp];
        }

        for(int i=len-1;i>k-1;i--)
            a[i]=a[i-k];

        for(int i=0;i<te.length;i++){
            a[i]=te[i];
        }
        return a;
    }
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        a=rotateRightByK(a,k);

        int[] x =new int[queries.length];
        int j=0;
        for(int i:queries){
            x[j]=a[i];
            j++;
        }

        return x;
    }

    static int saveThePrisoner(int p, int s, int i) {
        int ans=(s+i-1)%p;
        return ans==0?p:ans;
    }

    static void electronicShop(int budget, int[] key,int[] drives){
        int max=0;
        for(int i:key){
            for (int j:drives){
                int temp=i+j;
                max=temp<=budget && temp>max?temp:max;
            }
        }
        System.out.println(max);
    }
    static void funny(int s){

        boolean century=(s%100==0);

        if(s>1918){
            if(s%400==0)
                System.out.println("12.09."+s);
            else if(!century && s%4==0) System.out.println("12.09."+s);
            else System.out.println("13.09."+s);

        }
        else {

            if(s%4==0)
                System.out.println("12.09."+s);
            else System.out.println("13.09."+s);
        }
    }

    public static String stringsXOR(String s, String t) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i))
                res.append("0");
            else
                res.append("1");
        }

        return res.toString();
    }





    static int hurdleRace(int[] height) {
        Arrays.sort(height);

        return height[(height.length-1)/2];
    }
    public static String getString(int i){
        String[] a =new String[]{"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirt","fourt","fift","sixt","eight","nint","twent"};
        List<String> str= Arrays.asList(a);
        return str.get(i-1);
    }

    public static void convertTime(int h,int m){
        if(m==0)
            System.out.println(getString(h)+" O' clock");
        else if(m>0 && m<30)
            System.out.println((m>13)?getString(m):getString(m)+"een"+ "minutes past "+ getString(h));
        else System.out.println();
    }

}