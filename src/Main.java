import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String inputFile = "";
        String outputFile = "";
        String mode = "enc";
        int key = 0;
        String data = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                if (args[i + 1].equals("dec")) {
                    mode = "dec";
                }

            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            } else if (args[i].equals("-in")) {
                inputFile = args[i + 1];
            } else if (args[i].equals("-out")) {
                outputFile = args[i + 1];
            }

        }

        if (!inputFile.equals("")) {
            File file1 = new File(inputFile);
            try {
                Scanner scanner = new Scanner(file1);
                data = scanner.nextLine();
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }


        char[] charOfInputWord = data.toCharArray();


        if (mode.equals("enc")) {

            encryption(charOfInputWord, key, data, outputFile, alg);
        } else if (mode.equals("dec")) {
            decryption(charOfInputWord, key, data, outputFile, alg);

        }

    }

    public static void encryption(char[] charOfInputWord, int keyInt, String data, String outputFile, String alg) {

        if ((outputFile.equals(""))) {
            if (alg.equals("unicode")) {
                for (char tempChar : charOfInputWord) {
                    {
                        tempChar = (char) ((tempChar + keyInt));
                        System.out.print(Character.toString(tempChar));
                    }
                }

            } else if (alg.equals("shift")) {
                for (char tempChar : charOfInputWord) {
                    if (Character.isLowerCase(tempChar)) {

                        if (tempChar > 'z' - keyInt) {
                            tempChar = (char) (((int) (tempChar + keyInt)) % 'z' + 'a' - 1);
                            System.out.print(tempChar);
                        } else {
                            tempChar = (char) ((tempChar + keyInt));
                            System.out.print(tempChar);
                        }

                    } else if (Character.isUpperCase(tempChar)) {
                        if (tempChar > 'Z' - keyInt) {
                            tempChar = (char) (((int) (tempChar + keyInt)) % 'Z' + 'A' - 1);
                            System.out.print(tempChar);
                        } else {
                            tempChar = (char) ((tempChar + keyInt));
                            System.out.print(tempChar);
                        }

                    } else if (tempChar < 'a' || tempChar > 'z') {
                        System.out.print(tempChar);

                    }


                }

            }


        } else if (outputFile != "") {
            File file1 = new File(outputFile);
            try (FileWriter writer = new FileWriter(file1)) {

                if (alg.equals("unicode")) {
                    for (char tempChar : charOfInputWord) {
                        {
                            tempChar = (char) ((tempChar + keyInt));
                            writer.write(tempChar);
                        }
                    }

                } else if (alg.equals("shift")) {
                    for (char tempChar : charOfInputWord) {
                        if (Character.isLowerCase(tempChar)) {

                            if (tempChar > 'z' - keyInt) {
                                tempChar = (char) (((int) (tempChar + keyInt)) % 'z' + 'a' - 1);
                                writer.write(tempChar);
                            } else {
                                tempChar = (char) ((tempChar + keyInt));
                                writer.write(tempChar);
                            }

                        } else if (Character.isUpperCase(tempChar)) {
                            if (tempChar > 'Z' - keyInt) {
                                tempChar = (char) (((int) (tempChar + keyInt)) % 'Z' + 'A' - 1);
                                writer.write(tempChar);
                            } else {
                                tempChar = (char) ((tempChar + keyInt));
                                writer.write(tempChar);
                            }

                        } else if (tempChar < 'a' || tempChar > 'z') {
                            writer.write(tempChar);

                        }


                    }

                }


            } catch (IOException e) {
                System.out.println("Error");
                System.out.println("Exception come" + e.getMessage());
            }

        }


    }


    public static void decryption(char[] charOfInputWord, int keyInt, String data, String outputFile, String alg) {

        if ((outputFile.equals(""))) {
            if (alg.equals("unicode")) {
                for (char tempChar : charOfInputWord) {
                    {
                        tempChar = (char) ((tempChar - keyInt));
                        System.out.print(Character.toString(tempChar));
                    }
                }

            } else if (alg.equals("shift")) {
                for (char tempChar : charOfInputWord) {
                    if (Character.isLowerCase(tempChar)) {

                        if (tempChar > 'z' + keyInt) {
                            tempChar = (char) (((int) 'z' % (tempChar - keyInt)) + 'a' - 1);
                            System.out.print(tempChar);

                        } else if (tempChar < 'a' + keyInt) {
                            tempChar = (char) (((int) 'z' + 1 - 'a' % (tempChar - keyInt)));
                            System.out.print(tempChar);

                        } else {
                            tempChar = (char) ((tempChar - keyInt));
                            System.out.print(tempChar);
                        }

                    } else if (Character.isUpperCase(tempChar)) {

                        if (tempChar > 'Z' + keyInt) {
                            tempChar = (char) (((int) 'Z' % (tempChar - keyInt)) + 'A' - 1);
                            System.out.print(tempChar);
                        } else if (tempChar < 'A' + keyInt) {
                            tempChar = (char) (((int) 'Z' + 1 - 'A' % (tempChar - keyInt)));
                            System.out.print(tempChar);

                        } else {
                            tempChar = (char) ((tempChar - keyInt));
                            System.out.print(tempChar);
                        }

                    } else if (tempChar < 'a' || tempChar > 'z') {
                        System.out.print(tempChar);

                    }


                }

            }


        } else if (outputFile != "") {
            File file1 = new File(outputFile);
            try (FileWriter writer = new FileWriter(file1)) {

                if (alg.equals("unicode")) {
                    for (char tempChar : charOfInputWord) {
                        {
                            tempChar = (char) ((tempChar - keyInt));
                            writer.write(tempChar);
                        }
                    }

                } else if (alg.equals("shift")) {
                    for (char tempChar : charOfInputWord) {
                        if (Character.isLowerCase(tempChar)) {

                            if (tempChar > 'z' + keyInt) {
                                tempChar = (char) (((int) 'z' % (tempChar - keyInt)) + 'a' - 1);
                                writer.write(tempChar);
                            } else if (tempChar < 'a' + keyInt) {
                                tempChar = (char) (((int) 'z' + 1 - 'a' % (tempChar - keyInt)));
                                writer.write(tempChar);

                            } else {
                                tempChar = (char) ((tempChar - keyInt));
                                writer.write(tempChar);
                            }

                        } else if (Character.isUpperCase(tempChar)) {
                            if (tempChar > 'Z' - keyInt) {
                                tempChar = (char) (((int) 'Z' % (tempChar - keyInt)) + 'A' - 1);
                                writer.write(tempChar);
                            } else if (tempChar < 'A' + keyInt) {
                                tempChar = (char) (((int) 'Z' + 1 - 'A' % (tempChar - keyInt)));
                                System.out.print(tempChar);

                            } else {
                                tempChar = (char) ((tempChar - keyInt));
                                writer.write(tempChar);
                            }

                        } else if (tempChar < 'a' || tempChar > 'z') {
                            writer.write(tempChar);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error");
                System.out.println("Exception come" + e.getMessage());
            }

        }
    }
}









