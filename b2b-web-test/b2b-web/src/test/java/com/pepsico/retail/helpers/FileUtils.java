package com.pepsico.retail.helpers;


import com.pepsico.retail.runners.Hook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class FileUtils  {

    @Autowired
     Hook hook;

    private static String getOperatingSystem() {
        return System.getProperty("os.name");
    }

    private static String getUserName() {
        return System.getProperty("user.name");
    }

    private static String getDownloadPath() {
        if (getOperatingSystem().contains("Mac")) {
            return File.separator + "Users" + File.separator + getUserName() + File.separator + "Downloads";
        } else if (getOperatingSystem().contains("Windows")) {
            return "C:" + File.separator + "Users" + File.separator + getUserName() + File.separator + "Downloads";
        } else {
            return null;
        }
    }

    public static boolean isFileDownloaded(String fileName) {
        File dir = new File(getDownloadPath());
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    private static String getUserDirectory() {
        return System.getProperty("user.dir");
    }

    public void uploadImage(String path) throws IOException {
        if (getOperatingSystem().contains("Mac")) {
            switch (hook.getBrowser()) {
                case "chrome":
                    String commandMac = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptChrome.exe" + " " + getUserDirectory() + "\\" + path;
                    Runtime.getRuntime().exec(commandMac);
                case "firefox":
                    String commandFFMac = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptFirefox.exe" + " " + getUserDirectory() + "\\" + path;
                    Runtime.getRuntime().exec(commandFFMac);
                case "edge":
                    String commandEdgeMac = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptChrome.exe" + " " + getUserDirectory() + "\\" + path;
                    Runtime.getRuntime().exec(commandEdgeMac);
                case "safari":
                    String commandSafariMac = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptChrome.exe" + " " + getUserDirectory() + "\\" + path;
                    Runtime.getRuntime().exec(commandSafariMac);
            }
            } else if (getOperatingSystem().contains("Windows")) {
                switch (hook.getBrowser()) {
                    case "chrome":
                        String commandChromeWindow = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptChrome.exe" + " " + getUserDirectory() + "\\" + path;
                        Runtime.getRuntime().exec(commandChromeWindow);
                    case "firefox":
                        String commandFFWindow = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptFirefox.exe" + " " + getUserDirectory() + "\\" + path;
                        Runtime.getRuntime().exec(commandFFWindow);
                    case "edge":
                        String commandEdgeWindow = getUserDirectory() + "\\" + "src\\test\\resources\\AutoItScript\\AutoITScriptEdge.exe" + " " + getUserDirectory() + "\\" + path;
                        Runtime.getRuntime().exec(commandEdgeWindow);
                }
            }

        }
    }
