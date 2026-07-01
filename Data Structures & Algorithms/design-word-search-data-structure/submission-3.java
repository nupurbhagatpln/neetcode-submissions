class TrieNode {
    TrieNode[] children;
    Boolean end;
    
    TrieNode()
    {
        children = new TrieNode[26];
        end= false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root= new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;

        for(char ch: word.toCharArray())
        {
            if(cur.children[ch-'a']==null)
            {
                cur.children[ch-'a']= new TrieNode();
            }
            cur= cur.children[ch-'a'];
        }
        cur.end=true;
    }

    public boolean search(String word) {
        return dfs(root, 0,word);
    }

    private boolean dfs(TrieNode root, int ind, String word)
    {
        TrieNode cur= root;

        for(int i=ind; i<word.length();i++)
        {
            if(word.charAt(i)=='.')
            {
                for(TrieNode child: cur.children)
                {
                    if(child!=null && dfs(child, i+1,word))
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
