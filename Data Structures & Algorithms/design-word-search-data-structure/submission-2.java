public class TrieNode{
    TrieNode[] children;
    boolean end;

    TrieNode(){
        children=new TrieNode[26];
        end=false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root= new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur= root;

        for(char c: word.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.end=true;

    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int in, TrieNode root)
    {
        TrieNode cur= root;

        for(int i=in;i<word.length();i++)
        {
            if(word.charAt(i)=='.')
            {
                for(TrieNode child: cur.children)
                {
                    if(child!= null && dfs(word,i+1,child))
                    {
                        return true;
                    }
                }
                return false;
            }
            else{
                if(cur.children[word.charAt(i)-'a']==null)
                {
                    return false;
                }
                cur= cur.children[word.charAt(i)-'a'];
            }
            
        }
        return cur.end;
    }
}
