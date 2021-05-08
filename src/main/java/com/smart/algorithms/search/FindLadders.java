package com.smart.algorithms.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/
 *单词接龙 II
 */
public class FindLadders {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        LinkedList<String> tmp = new LinkedList<>();
        tmp.add(beginWord);
        //bfs
        if (bfs(wordSet, beginVisited, endVisited, map, true)) {
            //dfs
            dfs(res, beginWord, endWord, map, tmp);
        }
        return res;
    }

    private static void dfs(List<List<String>> res, String beginWord, String endWord, Map<String, List<String>> map, LinkedList<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> words = map.getOrDefault(beginWord, new ArrayList<>());
        for (String word : words) {
            path.addLast(word);
            dfs(res, word, endWord, map, path);
            path.removeLast();
        }
    }


    //双向bfs
    private static boolean bfs(Set<String> wordSet, Set<String> beginVisited, Set<String> endVisited, Map<String, List<String>> map, boolean isFront) {
        if (beginVisited.size() == 0) {
            return false;
        }
        if (beginVisited.size() > endVisited.size()) {
            return bfs(wordSet, endVisited, beginVisited, map, !isFront);
        }
        wordSet.removeAll(beginVisited);
        boolean isMeet = false;
        Set<String> nextLevel = new HashSet<>();
        for (String word : beginVisited) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char tmp = chars[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (tmp == k) {
                        continue;
                    }
                    chars[i] = k;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        nextLevel.add(newWord);
                        String key = isFront ? word : newWord;
                        String nextWord = isFront ? newWord : word;
                        if (endVisited.contains(newWord)) {
                            isMeet = true;
                        }
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(nextWord);
                    }
                }
                chars[i] = tmp;
            }
        }
        if (isMeet) {
            return true;
        }
        return bfs(wordSet, nextLevel, endVisited, map, isFront);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaaaaaaaa", "caaaaaaaaa", "cbaaaaaaaa", "daaaaaaaaa", "dbaaaaaaaa", "eaaaaaaaaa", "ebaaaaaaaa", "faaaaaaaaa", "fbaaaaaaaa", "gaaaaaaaaa", "gbaaaaaaaa", "haaaaaaaaa", "hbaaaaaaaa", "iaaaaaaaaa", "ibaaaaaaaa", "jaaaaaaaaa", "jbaaaaaaaa", "kaaaaaaaaa", "kbaaaaaaaa", "laaaaaaaaa", "lbaaaaaaaa", "maaaaaaaaa", "mbaaaaaaaa", "naaaaaaaaa", "nbaaaaaaaa", "oaaaaaaaaa", "obaaaaaaaa", "paaaaaaaaa", "pbaaaaaaaa", "qaaaaaaaaa", "qbaaaaaaaa", "raaaaaaaaa", "rbaaaaaaaa", "saaaaaaaaa", "sbaaaaaaaa", "taaaaaaaaa", "tbaaaaaaaa", "uaaaaaaaaa", "ubaaaaaaaa", "vaaaaaaaaa", "vbaaaaaaaa", "waaaaaaaaa", "wbaaaaaaaa", "xaaaaaaaaa", "xbaaaaaaaa", "yaaaaaaaaa", "ybaaaaaaaa", "zaaaaaaaaa", "zbaaaaaaaa", "bbaaaaaaaa", "bdaaaaaaaa", "bdbaaaaaaa", "beaaaaaaaa", "bebaaaaaaa", "bfaaaaaaaa", "bfbaaaaaaa", "bgaaaaaaaa", "bgbaaaaaaa", "bhaaaaaaaa", "bhbaaaaaaa", "biaaaaaaaa", "bibaaaaaaa", "bjaaaaaaaa", "bjbaaaaaaa", "bkaaaaaaaa", "bkbaaaaaaa", "blaaaaaaaa", "blbaaaaaaa", "bmaaaaaaaa", "bmbaaaaaaa", "bnaaaaaaaa", "bnbaaaaaaa", "boaaaaaaaa", "bobaaaaaaa", "bpaaaaaaaa", "bpbaaaaaaa", "bqaaaaaaaa", "bqbaaaaaaa", "braaaaaaaa", "brbaaaaaaa", "bsaaaaaaaa", "bsbaaaaaaa", "btaaaaaaaa", "btbaaaaaaa", "buaaaaaaaa", "bubaaaaaaa", "bvaaaaaaaa", "bvbaaaaaaa", "bwaaaaaaaa", "bwbaaaaaaa", "bxaaaaaaaa", "bxbaaaaaaa", "byaaaaaaaa", "bybaaaaaaa", "bzaaaaaaaa", "bzbaaaaaaa", "bcbaaaaaaa", "bcdaaaaaaa", "bcdbaaaaaa", "bceaaaaaaa", "bcebaaaaaa", "bcfaaaaaaa", "bcfbaaaaaa", "bcgaaaaaaa", "bcgbaaaaaa", "bchaaaaaaa", "bchbaaaaaa", "bciaaaaaaa", "bcibaaaaaa", "bcjaaaaaaa", "bcjbaaaaaa", "bckaaaaaaa", "bckbaaaaaa", "bclaaaaaaa", "bclbaaaaaa", "bcmaaaaaaa", "bcmbaaaaaa", "bcnaaaaaaa", "bcnbaaaaaa", "bcoaaaaaaa", "bcobaaaaaa", "bcpaaaaaaa", "bcpbaaaaaa", "bcqaaaaaaa", "bcqbaaaaaa", "bcraaaaaaa", "bcrbaaaaaa", "bcsaaaaaaa", "bcsbaaaaaa", "bctaaaaaaa", "bctbaaaaaa", "bcuaaaaaaa", "bcubaaaaaa", "bcvaaaaaaa", "bcvbaaaaaa", "bcwaaaaaaa", "bcwbaaaaaa", "bcxaaaaaaa", "bcxbaaaaaa", "bcyaaaaaaa", "bcybaaaaaa", "bczaaaaaaa", "bczbaaaaaa", "bccbaaaaaa", "bccdaaaaaa", "bccdbaaaaa", "bcceaaaaaa", "bccebaaaaa", "bccfaaaaaa", "bccfbaaaaa", "bccgaaaaaa", "bccgbaaaaa", "bcchaaaaaa", "bcchbaaaaa", "bcciaaaaaa", "bccibaaaaa", "bccjaaaaaa", "bccjbaaaaa", "bcckaaaaaa", "bcckbaaaaa", "bcclaaaaaa", "bcclbaaaaa", "bccmaaaaaa", "bccmbaaaaa", "bccnaaaaaa", "bccnbaaaaa", "bccoaaaaaa", "bccobaaaaa", "bccpaaaaaa", "bccpbaaaaa", "bccqaaaaaa", "bccqbaaaaa", "bccraaaaaa", "bccrbaaaaa", "bccsaaaaaa", "bccsbaaaaa", "bcctaaaaaa", "bcctbaaaaa", "bccuaaaaaa", "bccubaaaaa", "bccvaaaaaa", "bccvbaaaaa", "bccwaaaaaa", "bccwbaaaaa", "bccxaaaaaa", "bccxbaaaaa", "bccyaaaaaa", "bccybaaaaa", "bcczaaaaaa", "bcczbaaaaa", "bcccbaaaaa", "bcccdaaaaa", "bcccdbaaaa", "bccceaaaaa", "bcccebaaaa", "bcccfaaaaa", "bcccfbaaaa", "bcccgaaaaa", "bcccgbaaaa", "bccchaaaaa", "bccchbaaaa", "bccciaaaaa", "bcccibaaaa", "bcccjaaaaa", "bcccjbaaaa", "bccckaaaaa", "bccckbaaaa", "bccclaaaaa", "bccclbaaaa", "bcccmaaaaa", "bcccmbaaaa", "bcccnaaaaa", "bcccnbaaaa", "bcccoaaaaa", "bcccobaaaa", "bcccpaaaaa", "bcccpbaaaa", "bcccqaaaaa", "bcccqbaaaa", "bcccraaaaa", "bcccrbaaaa", "bcccsaaaaa", "bcccsbaaaa", "bccctaaaaa", "bccctbaaaa", "bcccuaaaaa", "bcccubaaaa", "bcccvaaaaa", "bcccvbaaaa", "bcccwaaaaa", "bcccwbaaaa", "bcccxaaaaa", "bcccxbaaaa", "bcccyaaaaa", "bcccybaaaa", "bccczaaaaa", "bccczbaaaa", "bccccbaaaa", "bccccdaaaa", "bccccdbaaa", "bcccceaaaa", "bccccebaaa", "bccccfaaaa", "bccccfbaaa", "bccccgaaaa", "bccccgbaaa", "bcccchaaaa", "bcccchbaaa", "bcccciaaaa", "bccccibaaa", "bccccjaaaa", "bccccjbaaa", "bcccckaaaa", "bcccckbaaa", "bcccclaaaa", "bcccclbaaa", "bccccmaaaa", "bccccmbaaa", "bccccnaaaa", "bccccnbaaa", "bccccoaaaa", "bccccobaaa", "bccccpaaaa", "bccccpbaaa", "bccccqaaaa", "bccccqbaaa", "bccccraaaa", "bccccrbaaa", "bccccsaaaa", "bccccsbaaa", "bcccctaaaa", "bcccctbaaa", "bccccuaaaa", "bccccubaaa", "bccccvaaaa", "bccccvbaaa", "bccccwaaaa", "bccccwbaaa", "bccccxaaaa", "bccccxbaaa", "bccccyaaaa", "bccccybaaa", "bcccczaaaa", "bcccczbaaa", "bcccccbaaa", "bcccccdaaa", "bcccccdbaa", "bccccceaaa", "bcccccebaa", "bcccccfaaa", "bcccccfbaa", "bcccccgaaa", "bcccccgbaa", "bccccchaaa", "bccccchbaa", "bccccciaaa", "bcccccibaa", "bcccccjaaa", "bcccccjbaa", "bccccckaaa", "bccccckbaa", "bccccclaaa", "bccccclbaa", "bcccccmaaa", "bcccccmbaa", "bcccccnaaa", "bcccccnbaa", "bcccccoaaa", "bcccccobaa", "bcccccpaaa", "bcccccpbaa", "bcccccqaaa", "bcccccqbaa", "bcccccraaa", "bcccccrbaa", "bcccccsaaa", "bcccccsbaa", "bccccctaaa", "bccccctbaa", "bcccccuaaa", "bcccccubaa", "bcccccvaaa", "bcccccvbaa", "bcccccwaaa", "bcccccwbaa", "bcccccxaaa", "bcccccxbaa", "bcccccyaaa", "bcccccybaa", "bccccczaaa", "bccccczbaa", "bccccccbaa", "bccccccdaa", "bccccccdba", "bcccccceaa", "bcccccceba", "bccccccfaa", "bccccccfba", "bccccccgaa", "bccccccgba", "bcccccchaa", "bcccccchba", "bcccccciaa", "bcccccciba", "bccccccjaa", "bccccccjba", "bcccccckaa", "bcccccckba", "bcccccclaa", "bcccccclba", "bccccccmaa", "bccccccmba", "bccccccnaa", "bccccccnba", "bccccccoaa", "bccccccoba", "bccccccpaa", "bccccccpba", "bccccccqaa", "bccccccqba", "bccccccraa", "bccccccrba", "bccccccsaa", "bccccccsba", "bcccccctaa", "bcccccctba", "bccccccuaa", "bccccccuba", "bccccccvaa", "bccccccvba", "bccccccwaa", "bccccccwba", "bccccccxaa", "bccccccxba", "bccccccyaa", "bccccccyba", "bcccccczaa", "bcccccczba", "bcccccccba", "bcccccccda", "bcccccccdb", "bcccccccea", "bccccccceb", "bcccccccfa", "bcccccccfb", "bcccccccga", "bcccccccgb", "bcccccccha", "bccccccchb", "bcccccccia", "bcccccccib", "bcccccccja", "bcccccccjb", "bcccccccka", "bccccccckb", "bcccccccla", "bccccccclb", "bcccccccma", "bcccccccmb", "bcccccccna", "bcccccccnb", "bcccccccoa", "bcccccccob", "bcccccccpa", "bcccccccpb", "bcccccccqa", "bcccccccqb", "bcccccccra", "bcccccccrb", "bcccccccsa", "bcccccccsb", "bcccccccta", "bccccccctb", "bcccccccua", "bcccccccub", "bcccccccva", "bcccccccvb", "bcccccccwa", "bcccccccwb", "bcccccccxa", "bcccccccxb", "bcccccccya", "bcccccccyb", "bcccccccza", "bccccccczb", "bccccccccb", "dccccccccb", "ddcccccccb", "eccccccccb", "edcccccccb", "fccccccccb", "fdcccccccb", "gccccccccb", "gdcccccccb", "hccccccccb", "hdcccccccb", "iccccccccb", "idcccccccb", "jccccccccb", "jdcccccccb", "kccccccccb", "kdcccccccb", "lccccccccb", "ldcccccccb", "mccccccccb", "mdcccccccb", "nccccccccb", "ndcccccccb", "occccccccb", "odcccccccb", "pccccccccb", "pdcccccccb", "qccccccccb", "qdcccccccb", "rccccccccb", "rdcccccccb", "sccccccccb", "sdcccccccb", "tccccccccb", "tdcccccccb", "uccccccccb", "udcccccccb", "vccccccccb", "vdcccccccb", "wccccccccb", "wdcccccccb", "xccccccccb", "xdcccccccb", "yccccccccb", "ydcccccccb", "zccccccccb", "zdcccccccb", "cdcccccccb", "cbcccccccb", "cbdccccccb", "cccccccccb", "ccdccccccb", "cfcccccccb", "cfdccccccb", "cgcccccccb", "cgdccccccb", "chcccccccb", "chdccccccb", "cicccccccb", "cidccccccb", "cjcccccccb", "cjdccccccb", "ckcccccccb", "ckdccccccb", "clcccccccb", "cldccccccb", "cmcccccccb", "cmdccccccb", "cncccccccb", "cndccccccb", "cocccccccb", "codccccccb", "cpcccccccb", "cpdccccccb", "cqcccccccb", "cqdccccccb", "crcccccccb", "crdccccccb", "cscccccccb", "csdccccccb", "ctcccccccb", "ctdccccccb", "cucccccccb", "cudccccccb", "cvcccccccb", "cvdccccccb", "cwcccccccb", "cwdccccccb", "cxcccccccb", "cxdccccccb", "cycccccccb", "cydccccccb", "czcccccccb", "czdccccccb", "cedccccccb", "cebccccccb", "cebdcccccb", "cecccccccb", "cecdcccccb", "cefccccccb", "cefdcccccb", "cegccccccb", "cegdcccccb", "cehccccccb", "cehdcccccb", "ceiccccccb", "ceidcccccb", "cejccccccb", "cejdcccccb", "cekccccccb", "cekdcccccb", "celccccccb", "celdcccccb", "cemccccccb", "cemdcccccb", "cenccccccb", "cendcccccb", "ceoccccccb", "ceodcccccb", "cepccccccb", "cepdcccccb", "ceqccccccb", "ceqdcccccb", "cerccccccb", "cerdcccccb", "cesccccccb", "cesdcccccb", "cetccccccb", "cetdcccccb", "ceuccccccb", "ceudcccccb", "cevccccccb", "cevdcccccb", "cewccccccb", "cewdcccccb", "cexccccccb", "cexdcccccb", "ceyccccccb", "ceydcccccb", "cezccccccb", "cezdcccccb", "ceedcccccb", "ceebcccccb", "ceebdccccb", "ceeccccccb", "ceecdccccb", "ceefcccccb", "ceefdccccb", "ceegcccccb", "ceegdccccb", "ceehcccccb", "ceehdccccb", "ceeicccccb", "ceeidccccb", "ceejcccccb", "ceejdccccb", "ceekcccccb", "ceekdccccb", "ceelcccccb", "ceeldccccb", "ceemcccccb", "ceemdccccb", "ceencccccb", "ceendccccb", "ceeocccccb", "ceeodccccb", "ceepcccccb", "ceepdccccb", "ceeqcccccb", "ceeqdccccb", "ceercccccb", "ceerdccccb", "ceescccccb", "ceesdccccb", "ceetcccccb", "ceetdccccb", "ceeucccccb", "ceeudccccb", "ceevcccccb", "ceevdccccb", "ceewcccccb", "ceewdccccb", "ceexcccccb", "ceexdccccb", "ceeycccccb", "ceeydccccb", "ceezcccccb", "ceezdccccb", "ceeedccccb", "ceeebccccb", "ceeebdcccb", "ceeecccccb", "ceeecdcccb", "ceeefccccb", "ceeefdcccb", "ceeegccccb", "ceeegdcccb", "ceeehccccb", "ceeehdcccb", "ceeeiccccb", "ceeeidcccb", "ceeejccccb", "ceeejdcccb", "ceeekccccb", "ceeekdcccb", "ceeelccccb", "ceeeldcccb", "ceeemccccb", "ceeemdcccb", "ceeenccccb", "ceeendcccb", "ceeeoccccb", "ceeeodcccb", "ceeepccccb", "ceeepdcccb", "ceeeqccccb", "ceeeqdcccb", "ceeerccccb", "ceeerdcccb", "ceeesccccb", "ceeesdcccb", "ceeetccccb", "ceeetdcccb", "ceeeuccccb", "ceeeudcccb", "ceeevccccb", "ceeevdcccb", "ceeewccccb", "ceeewdcccb", "ceeexccccb", "ceeexdcccb", "ceeeyccccb", "ceeeydcccb", "ceeezccccb", "ceeezdcccb", "ceeeedcccb", "ceeeebcccb", "ceeeebdccb", "ceeeeccccb", "ceeeecdccb", "ceeeefcccb", "ceeeefdccb", "ceeeegcccb", "ceeeegdccb", "ceeeehcccb", "ceeeehdccb", "ceeeeicccb", "ceeeeidccb", "ceeeejcccb", "ceeeejdccb", "ceeeekcccb", "ceeeekdccb", "ceeeelcccb", "ceeeeldccb", "ceeeemcccb", "ceeeemdccb", "ceeeencccb", "ceeeendccb", "ceeeeocccb", "ceeeeodccb", "ceeeepcccb", "ceeeepdccb", "ceeeeqcccb", "ceeeeqdccb", "ceeeercccb", "ceeeerdccb", "ceeeescccb", "ceeeesdccb", "ceeeetcccb", "ceeeetdccb", "ceeeeucccb", "ceeeeudccb", "ceeeevcccb", "ceeeevdccb", "ceeeewcccb", "ceeeewdccb", "ceeeexcccb", "ceeeexdccb", "ceeeeycccb", "ceeeeydccb", "ceeeezcccb", "ceeeezdccb", "ceeeeedccb", "ceeeeebccb", "ceeeeebdcb", "ceeeeecccb", "ceeeeecdcb", "ceeeeefccb", "ceeeeefdcb", "ceeeeegccb", "ceeeeegdcb", "ceeeeehccb", "ceeeeehdcb", "ceeeeeiccb", "ceeeeeidcb", "ceeeeejccb", "ceeeeejdcb", "ceeeeekccb", "ceeeeekdcb", "ceeeeelccb", "ceeeeeldcb", "ceeeeemccb", "ceeeeemdcb", "ceeeeenccb", "ceeeeendcb", "ceeeeeoccb", "ceeeeeodcb", "ceeeeepccb", "ceeeeepdcb", "ceeeeeqccb", "ceeeeeqdcb", "ceeeeerccb", "ceeeeerdcb", "ceeeeesccb", "ceeeeesdcb", "ceeeeetccb", "ceeeeetdcb", "ceeeeeuccb", "ceeeeeudcb", "ceeeeevccb", "ceeeeevdcb", "ceeeeewccb", "ceeeeewdcb", "ceeeeexccb", "ceeeeexdcb", "ceeeeeyccb", "ceeeeeydcb", "ceeeeezccb", "ceeeeezdcb", "ceeeeeedcb", "ceeeeeebcb", "ceeeeeebdb", "ceeeeeeccb", "ceeeeeecdb", "ceeeeeefcb", "ceeeeeefdb", "ceeeeeegcb", "ceeeeeegdb", "ceeeeeehcb", "ceeeeeehdb", "ceeeeeeicb", "ceeeeeeidb", "ceeeeeejcb", "ceeeeeejdb", "ceeeeeekcb", "ceeeeeekdb", "ceeeeeelcb", "ceeeeeeldb", "ceeeeeemcb", "ceeeeeemdb", "ceeeeeencb", "ceeeeeendb", "ceeeeeeocb", "ceeeeeeodb", "ceeeeeepcb", "ceeeeeepdb", "ceeeeeeqcb", "ceeeeeeqdb", "ceeeeeercb", "ceeeeeerdb", "ceeeeeescb", "ceeeeeesdb", "ceeeeeetcb", "ceeeeeetdb", "ceeeeeeucb", "ceeeeeeudb", "ceeeeeevcb", "ceeeeeevdb", "ceeeeeewcb", "ceeeeeewdb", "ceeeeeexcb", "ceeeeeexdb", "ceeeeeeycb", "ceeeeeeydb", "ceeeeeezcb", "ceeeeeezdb", "ceeeeeeedb", "ceeeeeeebb", "ceeeeeeebc", "ceeeeeeecb", "ceeeeeeecc", "ceeeeeeefb", "ceeeeeeefc", "ceeeeeeegb", "ceeeeeeegc", "ceeeeeeehb", "ceeeeeeehc", "ceeeeeeeib", "ceeeeeeeic", "ceeeeeeejb", "ceeeeeeejc", "ceeeeeeekb", "ceeeeeeekc", "ceeeeeeelb", "ceeeeeeelc", "ceeeeeeemb", "ceeeeeeemc", "ceeeeeeenb", "ceeeeeeenc", "ceeeeeeeob", "ceeeeeeeoc", "ceeeeeeepb", "ceeeeeeepc", "ceeeeeeeqb", "ceeeeeeeqc", "ceeeeeeerb", "ceeeeeeerc", "ceeeeeeesb", "ceeeeeeesc", "ceeeeeeetb", "ceeeeeeetc", "ceeeeeeeub", "ceeeeeeeuc", "ceeeeeeevb", "ceeeeeeevc", "ceeeeeeewb", "ceeeeeeewc", "ceeeeeeexb", "ceeeeeeexc", "ceeeeeeeyb", "ceeeeeeeyc", "ceeeeeeezb", "ceeeeeeezc", "ceeeeeeeec", "aaaaaaaaaz", "aaaaaaaabz", "aaaaaaacbz", "aaaaaaacbc", "aaaaaadcbc", "aaaaaedcbc", "aaaaaedccc", "aaaafedccc", "aaaafecccc", "aaaffecccc", "aafffecccc", "aaffcecccc", "aaffcccccc", "acffcccccc", "acfccccccc", "accccccccc", "accccccccb", "accccccccf", "acccccccff", "accccccfff", "acccccffff", "acccccfffc", "accccefffc", "accceefffc", "acceeefffc", "aceeeefffc", "aceeeeeffc", "aceeeeeefc", "aceeeeeeec", "aeeeeeeeec");
        List<List<String>> ladders = findLadders("aaaaaaaaaa", "ceeeeeeeec", list);
        System.out.println(ladders);
    }
}
