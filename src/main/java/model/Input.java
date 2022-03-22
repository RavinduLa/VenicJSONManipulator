package model;

public class Input {
    private String input;
    private long isCommand;

    public Input(String input, long isCommand) {
        this.input = input;
        this.isCommand = isCommand;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public long getIsCommand() {
        return isCommand;
    }

    public void setIsCommand(int isCommand) {
        this.isCommand = isCommand;
    }
}
