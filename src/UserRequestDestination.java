public class UserRequestDestination {
    String outputPath;

    public UserRequestDestination(String outputPath){
        this.outputPath = outputPath;
    }

    public UserRequestDestination(){
    }
    
    public String getOutputPath() {
        return outputPath;
    }
    
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }   
}
