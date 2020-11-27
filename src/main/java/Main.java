import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        genLexer lexer = new genLexer(CharStreams.fromFileName("test.txt"));
        TokenStream tokens = new CommonTokenStream(lexer);
        genParser parser = new genParser(tokens);
        Visitor v = new Visitor();
        System.out.println(v.visitProgram(parser.program()));
    }
}