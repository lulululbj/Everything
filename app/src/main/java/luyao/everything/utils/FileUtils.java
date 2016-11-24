package luyao.everything.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Lu
 * on 2016/11/24 14:03.
 */

public class FileUtils {

    /**
     * 读取Assets下文件
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getAssetsFile(Context context, String fileName) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
