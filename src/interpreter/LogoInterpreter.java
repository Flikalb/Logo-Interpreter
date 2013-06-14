package interpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

import context.ExecutionContext;
import error.InterpretationException;

import parser.LogoParser;

import syntaxtree.AbsStatementNode;
import ui.UserInterface;

public class LogoInterpreter {

    private static SortedMap<Integer, AbsStatementNode> code = null;
    private static LogoParser parser;

    public static void main(String args[]) {

        String filename;
        File f;

        if (args.length == 1) {
            f = new File(args[0]);
            try {
                parser = new LogoParser(new java.io.FileInputStream(f));
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
            filename = f.getName();
        } else {
            return;
        }

        try {
            code = parser.executeCompiler();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if (code == null) {
            code = new TreeMap<Integer, AbsStatementNode>();
        }

        // RUN
        UserInterface ui = new UserInterface();
        ui.displayOn();
        FileInputStream stream;
        try {
            stream = new FileInputStream(f);
            InputStreamReader ipsr = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(ipsr);
            String str;
            while ((str = br.readLine()) != null) {
                str += "\n";
                ui.setCodeText(ui.getCodeText() + str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutionContext context = new ExecutionContext(parser.getSymbolTable(), ui);
        for (Integer i : code.keySet()) {
            try {
                code.get(i).run(context);
            } catch (InterpretationException e) {
                System.out.println("Exception at code.get(" + i + ")");
                System.out.println(code.get(i));
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
    }
}
