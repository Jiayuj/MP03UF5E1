import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1 {
    public static void main(String[] args) throws IOException {
        String pareNoel = "*<]:-DOo";
        String rens = ">:o)";
        String follets = "<]:-D";
        //read file to list line by line
        List<String> allLines = Files.readAllLines(Paths.get("santako.txt"));
        System.out.println("Sin Expressions Regulas");
        for (String line : allLines) {
            int indexP, indexR = 0, indexF = 0;
            int contP=0,contR=0,contF=0;
            do {
                if ((indexP = line.indexOf(pareNoel)) != -1){//comprobar si existe y busca que posicion de inicio.
                    contP++;
                    var endIndex = indexP+pareNoel.length();// posicion inicio de parable y donde acabar
                    line= line.substring(0,indexP) + line.substring(endIndex);// eleminar caracte de posicion indes a endindex
                }else if ((indexR = line.indexOf(rens)) != -1){
                    contR++;
                    var endIndex = indexR+rens.length();
                    line= line.substring(0,indexR) + line.substring(endIndex) ;
                }else if ((indexF = line.indexOf(follets)) != -1){
                    contF++;
                    var endIndex = indexF+follets.length();
                    line= line.substring(0,indexF) + line.substring(endIndex) ;
                }
            }while (indexR != -1 && indexF != -1 && indexP != -1);
            if (contP != 0) System.out.print("P "+ contP+ " ");
            if (contR != 0) System.out.print("R " + contR+ " ");
            if (contF != 0) System.out.print("F "+ contF+ " ");
            if (contF== 0 && contP == 0 && contR == 0) System.out.print("");
            System.out.println();
        }
        System.out.println("Expressions Regulas");
        for (String line : allLines) {
            int contP=0,contR=0,contF=0;
            Pattern pattern = Pattern.compile("\\*<]:-DOo");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                contP++;
                line = line.replaceAll("\\*<]:-DOo","");
            }
            pattern = Pattern.compile(">:o\\)");
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                contR++;
                line = line.replaceAll(">:o\\)","");
            }
            pattern = Pattern.compile("<]:-D");
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                contF++;
                line = line.replaceAll("<]:-D","");
            }

            if (contP != 0) System.out.print("P "+ contP+ " ");
            if (contR != 0) System.out.print("R " + contR+ " ");
            if (contF != 0) System.out.print("F "+ contF+ " ");
            if (contF== 0 && contP == 0 && contR == 0) System.out.print("");
            System.out.println();
        }
    }
}
