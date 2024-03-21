package Network;

public class Response {

    private String result="Success\n---\n";

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Response(String result) {
        this.result = result;
    }

    public Response() {
    }
}
