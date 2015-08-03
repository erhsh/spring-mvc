package com.erhsh.prj.distrmgmtsys.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
	public static List<File> listSub(String directory) {
		File file = new File(directory);
		return Arrays.asList(file.listFiles());
	}
}
