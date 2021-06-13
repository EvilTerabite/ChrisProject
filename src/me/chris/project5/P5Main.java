package me.chris.project5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class P5Main {
    public static void main(String[] args) {
        FormLetter letter1 = new FormLetter("formLetter..txt");
        FormLetter letter2 = new FormLetter("longLetter.txt");
        FormLetter letter3 = new FormLetter("formLetter.txt");
        letter1.generateLetter("insertions.txt");
        letter2.generateLetter("insertions.txt");
        letter3.generateLetter("insertions.txt");
    }

    public static class FormLetter {
        private String txtFile;

        public FormLetter(String txtFile) {
            this.txtFile = txtFile;
        }

        public void generateLetter(String insertionFile) {
            //Set the file path
            String filePath = "src/me/chris/project5/resources/";

            //Read both text files and ensure that none of them are null
            String rawLetter = readText(filePath + this.txtFile);
            String letter;
            String insertionString = readText(filePath + insertionFile);
            if(rawLetter == null | insertionString == null) {
                return;
            }

            //Splitting each insertion into entries in a list.
            ArrayList<String> letterInsertions = new ArrayList<>(Arrays.asList(insertionString.split("\\n")));

            //Loop through the arraylist and generate each letter
            for (String insertion : letterInsertions) {
                //Split the text using the "@" delimiter.
                ArrayList<String> insertionList = new ArrayList<>(Arrays.asList(insertion.split("@")));

                //Replace the "@#" with the values specified in the insertions.txt by using the arraylist index.
                letter = rawLetter
                        .replace("@1", insertionList.get(0))
                        .replace("@2", insertionList.get(1))
                        .replace("@3", insertionList.get(2))
                        .replace("@4", insertionList.get(3));

                //print out the letter and a line to clearly differentiate between them.
                System.out.println(letter);
                System.out.println("-------------------------------------------");
            }
        }

        public String getTxtFile() {
            return txtFile;
        }

        public void setTxtFile(String txtFile) {
            this.txtFile = txtFile;
        }

        private String readText(String file) {
            try {
                //Open a Buffered Reader which takes a Input Stream Reader as a argument, the input stream reader takes an input stream as an argument.
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader buffer = new BufferedReader(inputStreamReader);

                //Read each line of text from the file and build it into a string.
                String line = buffer.readLine();
                StringBuilder builder = new StringBuilder();

                //Adds a "\n" argument to the end of the line to separate it and format it correctly
                while (line != null) {
                    builder.append(line).append("\n");
                    line = buffer.readLine();
                }

                //Finally, build the string and return it.
                return builder.toString();

            }
            //Catch the IOException OR FileNotFoundException and print it to the console.
            catch (IOException e) {
                System.out.println("ERROR: Could not read {file}".replace("{file}", file));
                return null;
            }
        }
    }
}
