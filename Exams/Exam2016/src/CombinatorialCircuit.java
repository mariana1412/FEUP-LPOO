import java.util.HashSet;
import java.util.Set;

public class CombinatorialCircuit {

    private Set<LogicVariable> variables;

    public CombinatorialCircuit() {
        this.variables = new HashSet<>();
    }

    public boolean addVariable(LogicVariable variable) {
        return variables.add(variable);
    }

    public LogicVariable getVariableByName(String name) {
        for(LogicVariable variable : variables){
            if(variable.getName() == name) return variable;
        }

        return null;
    }
}
