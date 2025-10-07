class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        HashMap<String,String> cap = new HashMap<>();
        HashMap<String,String> v = new HashMap<>();
        for (int i = 0;i<wordlist.length;i++){
            set.add(wordlist[i]);
            String capital = small(wordlist[i]);
            if(!cap.containsKey(capital)){
                cap.put(capital,wordlist[i]);
            }
            String vow = vowel(capital);
            if(!v.containsKey(vow)){
                v.put(vow,wordlist[i]);
            }
            //System.out.println(capital+" "+vow);
        }
        String[] arr = new String[queries.length];
        for (int i = 0;i<queries.length;i++){
            if (set.contains(queries[i])){
                arr[i] = queries[i];
                continue;
            }
            if(cap.containsKey(small(queries[i]))){
                arr[i] = cap.get(small(queries[i]));
                continue;
            }
            if(v.containsKey(vowel(small(queries[i])))){
                arr[i] = v.get(vowel(small(queries[i])));
                continue;
            }
            arr[i] = "";
        }
        return arr;
    }
    public String small(String s){
        StringBuilder sb = new StringBuilder();
        for (int i =0;i< s.length();i++){
            if(s.charAt(i)>96){
                sb.append((char)(s.charAt(i)-32));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public String vowel(String s){
        StringBuilder sb = new StringBuilder();
        String t = small(s);
        for (int i = 0;i<t.length();i++){
            if (t.charAt(i)=='A' || t.charAt(i)=='I' || t.charAt(i)=='E' || t.charAt(i)=='O' || t.charAt(i)=='U'){
                sb.append('*');
            }
            else {
                sb.append(t.charAt(i));
            }
        }
        return sb.toString();
    }
