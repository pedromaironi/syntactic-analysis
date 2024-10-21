package analizador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        // Rutas de los archivos .flex y .cup
        String ruta1 = "C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "src" + File.separator + "analizador" + File.separator + "Lexer.flex";
        String ruta2 = "C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "src" + File.separator + "analizador" + File.separator + "LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "src" + File.separator + "analizador" + File.separator + "Sintax.cup"};
        
        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        // Generación del archivo Lexer a partir de los archivos .flex
        String[] archivo1 = {ruta1}; // Colocamos el archivo en un arreglo de Strings
        jflex.Main.generate(archivo1);

        String[] archivo2 = {ruta2}; // Colocamos el archivo en un arreglo de Strings
        jflex.Main.generate(archivo2);

        // Ejecutar el analizador sintáctico de java_cup
        java_cup.Main.main(rutaS);

        // Mover y reemplazar sym.java
        Path rutaSym = Paths.get("C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "src" + File.separator + "analizador" + File.separator + "sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "sym.java"), 
                rutaSym
        );

        // Mover y reemplazar Sintax.java
        Path rutaSin = Paths.get("C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "src" + File.separator + "analizador" + File.separator + "Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:" + File.separator + "Users" + File.separator + "Pedro M. Toribio" + File.separator + "Desktop" + File.separator + "Analizador_Sintactico" + File.separator + "Analizador_Sintactico" + File.separator + "Sintax.java"), 
                rutaSin
        );
    }
}
