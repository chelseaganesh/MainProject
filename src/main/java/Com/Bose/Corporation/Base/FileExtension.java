/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.Base;
/*
 *
 */

import java.io.*;
import java.nio.file.NotDirectoryException;

public class FileExtension {

    private static String File_Directory = "";
    private static final String Android_File_With_Extension = ".apk";
    private static final String Ios_File_with_Extension = ".ipa";
    public static File environmentFile;
    public GenericExtensionFilter extensionFilter;

    public void buildPath() {
        TestBase.propFile();
        String Environment = TestBase.prop.getProperty("Environment");
        File_Directory = TestBase.prop.getProperty("ResourcesPath");

        try {
            if (Environment.equals("android")) {
                listFilesWithExtension(File_Directory, Android_File_With_Extension);


            } else if (Environment.equals("ios")) {
                listFilesWithExtension(File_Directory, Ios_File_with_Extension);
            } else {
                System.out.println("Value of " + Environment + "Not found");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }



    public void listFilesWithExtension(String folder, String extension) {


        try {
            extensionFilter = new GenericExtensionFilter(extension);

            File directory = new File(folder);

            if (directory.isDirectory() == false){
                System.out.println("Directory Does not Exist" + File_Directory);
                //return;
            }

            String[] list = directory.list(extensionFilter);

            if (list.length == 0) {
                System.out.println("no files end with :" + extension);
                //return;
            }

            for (String file : list) {
                String build = new StringBuffer(File_Directory).append(File.separator).append(file).toString();
                environmentFile = new File(build);
                System.out.println("File :" + environmentFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  class GenericExtensionFilter implements FilenameFilter{

        private String extension;

        public GenericExtensionFilter(String extension){
            this.extension = extension;
        }

        @Override
        public boolean accept(File dir, String name) {
            return (name.endsWith(extension));
        }
    }
}


