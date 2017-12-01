package service;

import java.util.List;

public class MyPojo
{
    private List<CommandeParser> commandeParser;

    public List<CommandeParser> getCommandeParser ()
    {
        return commandeParser;
    }

    public void setCommandeParser (List<CommandeParser> commandeParser)
    {
        this.commandeParser = commandeParser;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [commandeParser = "+commandeParser+"]";
    }
}
			