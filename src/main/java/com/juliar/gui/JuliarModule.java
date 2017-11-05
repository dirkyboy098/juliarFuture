package com.juliar.gui;

/**
 * Created by AndreiM on 5/30/2017.
 */
public class JuliarModule {

    private boolean installed = false;
    private String module = "default";
    private String category = "Must Have";
    private String stability = "stable";
    private String latestversion = "0.1";
    private String installedversion = "";

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    public String getLatestversion() {
        return latestversion;
    }

    public void setLatestversion(String latestversion) {
        this.latestversion = latestversion;
    }

    public String getInstalledversion() {
        return installedversion;
    }

    public void setInstalledversion(String installedversion) {
        this.installedversion = installedversion;
    }

    public JuliarModule() { this(false,"","","","","");}

    public JuliarModule(boolean installed, String module, String category, String stability, String latestversion, String installedversion){
        setInstalled(installed);
        setModule(module);
        setCategory(category);
        setStability(stability);
        setLatestversion(latestversion);
        setInstalledversion(installedversion);
    }
}
