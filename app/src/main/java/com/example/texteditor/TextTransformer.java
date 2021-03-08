package com.example.texteditor;

public class TextTransformer {

    private String wordList;
    private String replacedList;
    private String aux;
    private char letter;
    private Integer setType = 0;

    private String normalListCharacters     = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_,;.?!/\\";
    private String bubbleListCharacters     = "⓪①②③④⑤⑥⑦⑧⑨ⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏ_,;.?!/\\";
    private String strikeListCharacters     = "̶0̶̶1̶2̶3̶4̶5̶6̶7̶8̶9̶a̶b̶c̶d̶e̶f̶g̶h̶i̶j̶k̶l̶m̶n̶o̶p̶q̶r̶s̶t̶u̶v̶w̶x̶y̶z̶A̶B̶C̶D̶E̶F̶G̶H̶I̶J̶K̶L̶M̶N̶O̶P̶Q̶R̶S̶T̶U̶V̶W̶X̶Y̶Z_,;.?!/\\";
    private String boldListCharacters       = "𝟎𝟏𝟐𝟑𝟒𝟓𝟔𝟕𝟖𝟗𝐚𝐛𝐜𝐝𝐞𝐟𝐠𝐡𝐢𝐣𝐤𝐥𝐦𝐧𝐨𝐩𝐪𝐫𝐬𝐭𝐮𝐯𝐰𝐱𝐲𝐳𝐀𝐁𝐂𝐃𝐄𝐅𝐆𝐇𝐈𝐉𝐊𝐋𝐌𝐍𝐎𝐏𝐐𝐑𝐒𝐓𝐔𝐕𝐖𝐗𝐘𝐙_,;.?!/\\";
    private String mirrordownListCharacters = "0ƖᄅƐㄣϛ9ㄥ86ɐqɔpǝɟƃɥᴉɾʞlɯuodbɹsʇnʌʍxʎz∀qƆpƎℲפHIſʞ˥WNOԀQɹS┴∩ΛMX⅄Z‾';˙¿¡/\\";


    public TextTransformer() {
        this.wordList = new String();
        this.replacedList = new String();

    }

    public TextTransformer(String wordList) {
        this.wordList = wordList;
        this.replacedList = new String();

    }

    public void setWordList(String wordList) {
        this.wordList = wordList;
    }

    public void resetReplaceList() {
        this.replacedList = new String();
    }

    public void setSetType(Integer setType) {
        this.setType = setType;
    }

    public String getNormalListCharacters() {
        return normalListCharacters;
    }

    public String getBubbleListCharacters() {
        return bubbleListCharacters;
    }

    public String getWordList() {
        return wordList;
    }

    public String getReplacedList() {
        return replacedList;
    }

    public Integer getSetType() { return setType; }

    public String replaceList() {
        this.replacedList = new String();
        this.aux = new String();
        switch(setType) {
            case 0 :
                for (int x = 0; x < wordList.length(); x++) {
                    this.letter = wordList.charAt(x);
                    int a = normalListCharacters.indexOf(this.letter);

                    aux += (a != -1) ? bubbleListCharacters.charAt(a) : this.letter;
                }
                return new StringBuilder(aux).toString();

            case 1 : // Don't ask why this works, it just does so let's leave it at that, ok?
                for (int x = 0; x < wordList.length(); x++) {
                    this.letter = wordList.charAt(x);
                    //int a = normalListCharacters.indexOf(this.letter);
                    //switch(letter) {
                      //  case 'a' :
                        //    aux += "a̶";
                        //default :
//                            break;
//                    }
                    aux += this.letter + "̶\\";
                    StringBuilder sb = new StringBuilder(aux);
                    sb.deleteCharAt(sb.length()-1);
                    aux = sb.toString();

                }
                return new StringBuilder(aux).toString();

            case 2 :
                for (int x = 0; x < wordList.length(); x++) {
                    this.letter = wordList.charAt(x);
                    int a = normalListCharacters.indexOf(this.letter);

                    aux += (a != -1) ? mirrordownListCharacters.charAt(a) : this.letter;
                }
               return new StringBuilder(aux).reverse().toString();

            case 3 :
              /*  for (int x = 0; x < wordList.length(); x++) {
                    this.letter = wordList.charAt(x);
                    int a = normalListCharacters.indexOf(this.letter);

                    aux += (a != -1) ? boldListCharacters.charAt(a) : this.letter;
                }*/
                String aux1 = aux + "\033[0;1m";
                return new StringBuilder(aux1).toString();

            default:
                return wordList;
        }
    }


    public static void main(String[] args)
    {
        TextTransformer txt = new TextTransformer("Ana are mere");
        System.out.println(txt.getWordList());

        //String bla = txt.getWordList();
        //System.out.println(bla.charAt(0));
        //System.out.println(bla.indexOf('A'));
        txt.setSetType(0);
        txt.replaceList();
        System.out.println(txt.replaceList());
        //System.out.println(txt.getBubbleListCharacters());
        //System.out.println(txt.getNormalListCharacters());
        txt.setSetType(1);
        txt.replaceList();
        System.out.println(txt.replaceList());

        txt.setSetType(3);
        txt.replaceList();
        System.out.println(txt.replaceList());
        //System.out.println("\u001B[1m" + "Ana are mere");
        //System.out.println("/[^\\W_]/g" + "Ana are mere");



    }

}
