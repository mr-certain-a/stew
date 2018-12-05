package orange;

public class ModuleVersion {

    private final String module;
    private final long serialNoOfVersion;

    public ModuleVersion(String module, long serialNoOfVersion) {
        this.module = module;
        this.serialNoOfVersion = serialNoOfVersion;
    }

    public String getModule() {
        return module;
    }
    
    public long getSerialNoOfVersion() {
        return serialNoOfVersion;
    }

}
