package com.weiwei.testplugin;

/**
 * @Author weiwei
 * @Date 2022/5/23 00:27
 */
public class PluginUtil {

    /**
     * 获取某个插件的安装目录
     *
     * @param plugId 插件id
     * @return 插件的安装目录
     */
    public static String getPlugDir(String plugId) {
        return "sdcard/" + plugId + "/";
    }
}
