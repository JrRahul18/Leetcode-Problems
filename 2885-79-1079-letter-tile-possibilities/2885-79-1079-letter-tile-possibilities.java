class Solution {
    static void solve(StringBuilder sb, String tiles, boolean[] isVisited, HashSet<String> hset){

        hset.add(sb.toString());

        for(int i=0; i<tiles.length(); i++){
            if(isVisited[i] == true) continue;
            
            isVisited[i] = true;
            sb.append(tiles.charAt(i));

            solve(sb, tiles, isVisited, hset);

            sb.deleteCharAt(sb.length()-1);
            isVisited[i] = false;
        }
    }
    public int numTilePossibilities(String tiles) {

        HashSet<String> hset = new HashSet<>();
        boolean[] isVisited = new boolean[tiles.length()];

        StringBuilder sb = new StringBuilder();

        solve(sb, tiles, isVisited, hset);

        return hset.size()-1;
        
    }
}