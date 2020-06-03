import java.util.Objects;

public class LogicVariable {

    private String name;
    private boolean value;
    private LogicGate calculatedBy;

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.calculatedBy = null;
    }

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
        this.calculatedBy = null;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        if(calculatedBy != null) calculatedBy.calculate();
        return value;
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }


    public String getFormula() {

        if(calculatedBy == null) return name;

        String formula = calculatedBy.getSymbol() + "(";

        for(LogicVariable input : calculatedBy.getInputs()){
            formula = formula.concat(input.getFormula() + ",");
        }

        formula = formula.substring(0, formula.length() - 1);
        formula = formula.concat(")");

        return formula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicVariable)) return false;
        LogicVariable that = (LogicVariable) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
